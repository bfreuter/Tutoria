/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutoria.gui;

import jade.gui.GuiEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import tutoria.AgenteIniciarSesion;


/**
 *
 * @author Beatriz
 * 
 */
public class GuiAgente extends JFrame {
    
    private AgenteIniciarSesion myAgent;
    private JButton isalu, ispro;

 public GuiAgente(AgenteIniciarSesion a) {
//        initComponents();  
        myAgent = a;      // Reference to class BankClientAgent
        setTitle("Mi agente - " + myAgent.getLocalName());
        
        //********************************************//
        
      JPanel p = new JPanel();
//      base.add(panel, BorderLayout.EAST);
//      panel.setLayout(new BorderLayout(0,10));
//      pane = new JPanel();
//      pane.setLayout(new BorderLayout(0,0));
//      pane.add(new JLabel("Input"), BorderLayout.NORTH);
//      pane.add(input = new JTextField(8));
//      panel.add(pane, BorderLayout.NORTH);
//      pane = new JPanel();
//      panel.add(pane, BorderLayout.SOUTH);
//      pane.setBorder(new EmptyBorder(0,0,130,0));
//      pane.setLayout(new GridLayout(3,1,0,5));
//      pane.add(ok = new JButton("OK"));
//      ok.setToolTipText("Submit operation");
//      ok.addActionListener(this);
//      pane.add(cancel = new JButton("Cancel"));
//      cancel.setToolTipText("Submit operation");
//      cancel.setEnabled(false);
//      cancel.addActionListener(this);
//      pane.add(quit = new JButton("QUIT"));
//      quit.setToolTipText("Stop agent and exit");
//      quit.addActionListener(this);
//
//      addWindowListener(new WindowAdapter() {
//         public void windowClosing(WindowEvent e) {
//            shutDown();
//         }
//      });
        
    }

    
    public void alertResponse(Object o) {
        JOptionPane.showMessageDialog(this, o);
    }
    
    public void actionPerformed(ActionEvent ae) {
// ---------------------------------------------

      if (ae.getSource() == isalu) {
          GuiEvent ge = new GuiEvent(this, 0);
            ge.addParameter(CmbUsuarios.getSelectedItem().toString());
            myAgent.postGuiEvent(ge);
         }else 
          if (ae.getSource() == isalu) {
              GuiEvent ge = new GuiEvent(this, 1);
               ge.addParameter(CmbUsuarios.getSelectedItem().toString());
               myAgent.postGuiEvent(ge);
          }
   }

    // Variables declaration - do not modify                     
//    private javax.swing.JButton BtIniciarSesionProfesor;
//    private javax.swing.JButton BtLogin;
    private javax.swing.JComboBox CmbProfesor;
    private javax.swing.JComboBox CmbUsuarios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;

}
