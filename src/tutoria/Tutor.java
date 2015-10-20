package tutoria;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.Property;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tutoria.acceso.bd.Base;

/**
 * En el caso del tutor se debe definir que tipo de tutor es y apenas se inicia
 * el agente publica su servicio de tutoria Despues debe tener un comportamiento
 * que escuche pedidos de tutorías y concrete citas.
 */
public class Tutor extends Agent {

    private int estado;

    protected void setup() {

        System.out.println("Tutor: " + getAID().getName() + " - Estoy iniciado... ");
        String Nombre = getAID().getName();
            int pos;
            pos = Nombre.indexOf(64); // arroba
            Nombre= Nombre.substring(0, pos);
        try {
            DFAgentDescription dfd = new DFAgentDescription();
            dfd.setName(getAID());
            Base oBase = new Base();
            ResultSet rs = oBase.ObtenerTemasTutoria(Nombre);
            while (rs.next()) {

                ServiceDescription sd = new ServiceDescription();

                sd.setType("Tutoria");
                sd.setName(oBase.QuitarEspacios(rs.getString("Temas_descripcion")));
                Property p = new Property();
                p.setName("Nivel");
                int posi;
                posi = rs.getString("Conocimiento_nivel").indexOf("-");
                String Nivel = rs.getString("Conocimiento_nivel").substring(posi+1, rs.getString("Conocimiento_nivel").length());
                p.setValue(oBase.QuitarEspacios(Nivel));
                sd.addProperties(p);
                dfd.addServices(sd);
            }

            DFService.register(this, dfd);
        } catch (FIPAException ex) {
            Logger.getLogger(Tutor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Tutor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    class EscucharPedidos extends Behaviour {

        public void action() {

            System.out.println("Tutor: " + getAID().getName() + " - Escuchar pedidos");
        }

        public boolean done() {
            return estado == 1;
        }

    }
}
