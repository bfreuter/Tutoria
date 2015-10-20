package tutoria;

import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.gui.GuiAgent;
import jade.gui.GuiEvent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import tutoria.gui.ListaTutores;
import tutoria.gui.OfertaAyuda;

/**
 *
 */
public class AgenteGUI extends GuiAgent{
    
    //Variables para el manejo de la GUI
    
    transient protected OfertaAyuda ayudaGui;
    transient protected ListaTutores tutoresGui;
    
    public static final int SALIR = 1000;
    public static final int ACCEPT_HELP_EVENT = 1001;
    public static final int REJECT_HELP_EVENT = 1002;
    public static final int SELECT_TUTOR_EVENT = 1003;
    
    //Variables del agente
    
    private AID remitente = null;

    public AID getRemitente() {
        return remitente;
    }

    public void setRemitente(AID remitente) {
        this.remitente = remitente;
    }
    
    
    @Override
    protected void setup(){
    
        System.out.println("AgenteGUI "+ getAID().getName() +" iniciado.");
        addBehaviour(new mostrarGui());
    }    

    @Override
    protected void onGuiEvent(GuiEvent ge) {
        
        switch(ge.getType()) {
        case SALIR:
            ayudaGui.dispose();
            ayudaGui = null;
            doDelete();
            break;
        case ACCEPT_HELP_EVENT:
            System.out.println("El alumno acepta la ayuda");
            enviarMsjeAccept();
            ayudaGui.dispose();
            ayudaGui = null;
            break;
        case REJECT_HELP_EVENT:
            System.out.println("El alumno rechaza la ayuda");
            enviarMsjeReject();
            ayudaGui.dispose();
            ayudaGui = null;
            break;    
        }
    }
    
    private void enviarMsjeAccept(){
    
        ACLMessage msg = new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);
        msg.addReceiver(remitente);
        msg.setLanguage("Español");
        msg.setContent("");
        send(msg);
                
    }
    
     private void enviarMsjeReject(){
    
        ACLMessage msg = new ACLMessage(ACLMessage.REJECT_PROPOSAL);
        msg.addReceiver(remitente);
        msg.setLanguage("Español");
        msg.setContent("");
        send(msg);
                
    }
    
    class mostrarGui extends CyclicBehaviour{

        @Override
        public void action() {
        
            ACLMessage msje = receive();
            if (msje != null) {
            switch(msje.getPerformative()){
                case ACLMessage.INFORM:
                    /* HashMap<String, Integer> oasProblema = (HashMap) msje.getContentObject();
                    System.out.println(oasProblema);*/
                    setRemitente(msje.getSender());
                    ayudaGui = new OfertaAyuda((AgenteGUI) myAgent);
                    ayudaGui.setVisible(true); 
                    System.out.println("Deberías estar viendo la oferta de ayuda!");  
                    break;
                case ACLMessage.PROPOSE:
                    setRemitente(msje.getSender());
                    
            try {
//                 tutores = msje.getContentObject();
//                Object[] args = agenteGUI.getArguments();
//        System.out.println(args);
//        for (Object ar: args){
//            modeloTutores.addElement(ar.toString());
//        } 
//        System.out.println(modeloTutores);
//        tutoresList.setModel(modeloTutores);
            Object[] tutores = {msje.getContentObject()};
                    myAgent.setArguments(tutores);
                    tutoresGui = new ListaTutores((AgenteGUI) myAgent);
                    tutoresGui.setVisible(true); 
                    System.out.println("Deberías estar viendo la lista de tutores!");  
                    break;
                    } catch (UnreadableException ex) {
                Logger.getLogger(AgenteGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
            }
            /*
            ACLMessage msje = receive();
            if (msje != null) {
                if (msje.getPerformative() == ACLMessage.INFORM) {
                    System.out.println(getLocalName() + ": acaba de recibir el siguiente mensaje: " + msje.getContent());
                }
            System.out.println(getLocalName() + ": acaba de recibir el siguiente mensaje: " + msje.getContent());    
            ayudaDialogGui = new OfertaAyuda((AgenteGUI) myAgent);
            ayudaDialogGui.showGui();
            }
            else{System.out.println("mensaje nulo!");}
            if (  .ayudaResponseDialog){
            }*/
        }
        
    }
}
