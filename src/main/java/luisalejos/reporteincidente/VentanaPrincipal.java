/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luisalejos.reporteincidente;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.http.WebSocket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author alexis
 */
public class VentanaPrincipal extends JFrame {
    
    private JPanel cards;
    
    public VentanaPrincipal() {
        setTitle("PROGRAMA DE REGISTRO DE INCIDENTES");
        setPreferredSize(new Dimension(640, 420));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
     
        JPanel operario = new PanelOperario();
        //JLabel ope = new JLabel("operario");
        JPanel seguridad = new JPanel();
        JLabel seg = new JLabel("seguridad");
        
        JPanel main = new JPanel();
        
        //operario.add(ope);
        
        seguridad.add(seg);
       
        JButton oper = new JButton("Operario");
        oper.setActionCommand("ope");
        JButton segu = new JButton("seguridad");
        segu.setActionCommand("seg");
        
        
        main.add(oper);
        main.add(segu);
        
        cards = new JPanel(new CardLayout());
        cards.add(main, "main");
        cards.add(operario, "ope");
        cards.add(seguridad, "seg");
        
        
        add(cards);
      
        
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println(ae.getActionCommand());
                CardLayout cl = (CardLayout) cards.getLayout();
                cl.show(cards, ae.getActionCommand());
                
            }
        
        };
        
        
        oper.addActionListener(listener);
        segu.addActionListener(listener);
        
        pack();
    }
    
    
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                new VentanaPrincipal().setVisible(true);
            }
            
        });
        
    }
    
}
