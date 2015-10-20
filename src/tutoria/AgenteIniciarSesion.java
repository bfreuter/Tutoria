/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutoria;

import jade.gui.GuiAgent;
import jade.gui.GuiEvent;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tutoria.gui.GuiAgente;

/**
 *
 * @author Beatriz
 */
public class AgenteIniciarSesion extends GuiAgent {

    transient protected GuiAgente myGui;
    static final int NADA = -1;
    static final int ISALU = 0;
    static final int ISPRO = 1;
    private int command = NADA;

    protected void onGuiEvent(GuiEvent ev) {
        command = ev.getType();
        alertGui(command);
    }

    protected void setup() {
// ------------------------

        // Set up the gui
        myGui = new GuiAgente(this);
        myGui.setVisible(true);
        try {
            startNewAgent("tutoria.AgenteGUI", "AgenteGUI", null);
            startNewAgent("tutoria.Alumno", "AJimCarrey", null);
            
            startNewAgent("tutoria.Tutor", "JuanPerez", null);
            startNewAgent("tutoria.Tutor", "MariaLopez", null);
            startNewAgent("tutoria.Tutor", "MariahCarey", null);
            startNewAgent("tutoria.Tutor", "JimCarrey", null);     
            
        } catch (StaleProxyException ex) {
            Logger.getLogger(AgenteIniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void startNewAgent(String className, String agentName, Object[] arguments) throws StaleProxyException {
        ((AgentController) getContainerController().createNewAgent(agentName, className, arguments)).start();
    }

    void alertGui(Object response) {
// --------------------------------  Process the response of the server
//                                   to the gui for display
        myGui.alertResponse(response);
    }
}
