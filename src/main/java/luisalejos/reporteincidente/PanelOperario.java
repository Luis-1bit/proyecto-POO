/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luisalejos.reporteincidente;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author alexis
 */
public class PanelOperario extends JPanel {
    
    private CardLayout operarioCardLayout;
    private JPanel operarioViews;
    
    public PanelOperario() {
        
        operarioCardLayout = new CardLayout();
        operarioViews = new JPanel(operarioCardLayout);
        
        JPanel main = new JPanel();
        JLabel principalLabel = new JLabel("OPERARIO PRINCIPAL");
        
        JButton irSecundario = new JButton("ir secundadio");
        irSecundario.setActionCommand("sec");
        
        main.add(principalLabel);
        main.add(irSecundario);
        
        JPanel operarioSecundario = new TipoIncidenteSelector();
        
        
        
        operarioViews.add(main, "main");
        operarioViews.add(operarioSecundario, "sec");
        
        irSecundario.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
               // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
               
               CardLayout cl  = (CardLayout) operarioViews.getLayout();
               cl.show(operarioViews, ae.getActionCommand());
               
               
            }
        
        });
        
        
        
        add(operarioViews);
    }
    
    
    
}
