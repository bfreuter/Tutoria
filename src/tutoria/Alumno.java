package tutoria;

import jade.core.AID;
import tutoria.gui.OfertaAyuda;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.FSMBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.Property;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.gui.GuiEvent;
import jade.lang.acl.ACLMessage;
import jade.proto.SubscriptionInitiator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tutoria.acceso.bd.AccesoLog;
import tutoria.gui.ListaTutores;

/**
 * La idea de este alumno es hacerlo como una máquina de estados finitos donde
 * primero tenga un comportamiento que monitoree las actividades del estudiante
 * y en cuanto detecte que tiene un problema con alguna actividad, ofrecerle un
 * tutor para que lo ayude
 */
public class Alumno extends Agent {

    private static final String STATE_MON = "MONITOREAR";
    private static final String STATE_OFR = "OFRECER";
    private static final String STATE_CONC = "CONCRETAR";

    private int estado = 0;

    @Override
    protected void setup() {

        System.out.println("Alumno: " + getAID().getName() + " Estoy iniciado....");
        FSMBehaviour fsm = new FSMBehaviour() {
            @Override
            public int onEnd() {
                System.out.println("");
                return super.onEnd();
            }
        };
        fsm.registerFirstState(new Monitorear(), STATE_MON);
        fsm.registerState(new OfrecerTutores(), STATE_OFR);
        fsm.registerState(new ConcretarCita(), STATE_CONC);

        fsm.registerTransition(STATE_MON, STATE_OFR, 1);
        fsm.registerDefaultTransition(STATE_OFR, STATE_CONC);
        fsm.registerDefaultTransition(STATE_CONC, STATE_MON);

        addBehaviour(fsm);
    }

    class Monitorear extends Behaviour {

        private static final int FT_REGULAR = 1000;
        private static final int FT_ESPERA = 1001;
        private int ftMonitorear = FT_REGULAR;

        public void action2() {
            try {
                estado = 0;
                System.out.println("Alumno: " + getAID().getName() + " - Monitorear ");
                AccesoLog al = new AccesoLog();
                HashMap<String, Integer> oasProblemas = al.leerLogsOA();
                if (!oasProblemas.isEmpty()) {
                    ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                    msg.addReceiver(new AID("AgenteGUI", AID.ISLOCALNAME));
                    msg.setLanguage("Español");
                    msg.setContentObject(oasProblemas);
                    send(msg);

                }
                ACLMessage respuesta = receive();
                if (respuesta != null) {
                    System.out.println("LLega la respuesta!");
                    System.out.println(respuesta.getPerformative());
                    if (respuesta.getPerformative() == ACLMessage.ACCEPT_PROPOSAL) {
                        estado = 1;
                        System.out.println("acepto");
                    } else {
                        if (respuesta.getPerformative() == ACLMessage.REJECT_PROPOSAL) {
                            estado = 0;
                            System.out.println("no acepto");
                        }
                    }
                } else {
                    System.out.println("Esperando respuesta del alumno");
                    block();
                }
            } catch (IOException ex) {
                Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void action() {

            System.out.println("Alumno: " + getAID().getName() + " - Monitorear ");
            if (ftMonitorear == FT_REGULAR) {
                estado = 0;
                AccesoLog al = new AccesoLog();
                HashMap<String, Integer> oasProblemas = al.leerLogsOA();
                if (!oasProblemas.isEmpty()) {
                    try {
                        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                        msg.addReceiver(new AID("AgenteGUI", AID.ISLOCALNAME));
                        msg.setLanguage("Español");
                        msg.setContentObject(oasProblemas);
                        send(msg);
                        ftMonitorear = FT_ESPERA;
                        System.out.println("Esperando respuesta del alumno");
                        block();
                    } catch (IOException ex) {
                        Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else { // ftMonitorear == FT_ESPERA 
                ACLMessage respuesta = receive();
                if (respuesta != null) {
                    System.out.println("LLega la respuesta!");
                    if (respuesta.getPerformative() == ACLMessage.ACCEPT_PROPOSAL) {
                        estado = 1;
                        System.out.println("acepto");
                    } else if (respuesta.getPerformative() == ACLMessage.REJECT_PROPOSAL) {
                        estado = 0;
                        System.out.println("no acepto");
                    }
                }
                ftMonitorear = FT_REGULAR;
            }
        }

        @Override
        public boolean done() {
            return estado == 1;
        }

        @Override
        public int onEnd() {
            return estado;
        }

    }

    class OfrecerTutores extends OneShotBehaviour {

        private static final int FT_REGULAR = 1000;
        private static final int FT_ESPERA = 1001;
        private int ft = FT_REGULAR;

        @Override
        public void action() {

            System.out.println("Alumno: " + getAID().getName() + " Ofrecer tutores ");
            /*  try {
             DFAgentDescription dfd = new DFAgentDescription();
             DFAgentDescription[] result = DFService.search(super.myAgent,dfd);
	
             System.out.println("Search returns: " + result.length + " elements" );
             if (result.length>0)
             System.out.println(" " + result[0].getName() );
             } catch (FIPAException fe) { fe.printStackTrace(); }*/
            if (ft == FT_REGULAR) {
                estado = 1;
                AccesoLog al = new AccesoLog();
                al.actualizarUltimoAcceso();

                DFAgentDescription template = new DFAgentDescription();
                ServiceDescription sd = new ServiceDescription();
                sd.setName("Definiciondemodelos");
                Property p = new Property();
                p.setName("Nivel");
                p.setValue("ALTO");
                sd.addProperties(p);
                template.addServices(sd);
                addBehaviour(new SubscriptionInitiator(super.myAgent, DFService.createSubscriptionMessage(super.myAgent, getDefaultDF(), template, null)) {
                    protected void handleInform(ACLMessage inform) {
                        try {
                            DFAgentDescription[] dfds = DFService.decodeNotification(inform.getContent());
                            if (dfds.length == 0) {
                                System.out.println("Ningun agente ofrece el servicio deseado");
                            } else {
                                for (int i = 0; i < dfds.length; ++i) {
                                    System.out.println("El agente " + dfds[0].getName() + " ofrece ese tipo de servicio");
                                    ACLMessage msg = new ACLMessage(ACLMessage.PROPOSE);
                                    msg.addReceiver(new AID("AgenteGUI", AID.ISLOCALNAME));
                                    msg.setLanguage("Español");
                                    msg.setContentObject(dfds);
                                    send(msg);
                                    ft = FT_ESPERA;
                                    System.out.println("Esperando respuesta del alumno");
                                    block();
                                }
                            }
                        } catch (FIPAException fe) {
                            fe.printStackTrace();
                        } catch (IOException ex) {
                            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });

            } else { // ftMonitorear == FT_ESPERA 
                ACLMessage respuesta = receive();
                if (respuesta != null) {
                    System.out.println("LLega la respuesta!");
                    if (respuesta.getPerformative() == ACLMessage.ACCEPT_PROPOSAL) {
                        estado = 2;
                        System.out.println("acepto, el tutor elegido para el chat es: " + respuesta.getContent());

                    } else if (respuesta.getPerformative() == ACLMessage.REJECT_PROPOSAL) {
                        estado = 0;
                        System.out.println("no acepto");
                    }
                }
                ft = FT_REGULAR;
            }

        }
    }

    class ConcretarCita extends OneShotBehaviour {

        @Override
        public void action() {

            System.out.println("Alumno: " + getAID().getName() + " Concretar cita ");
        }
    }

}
