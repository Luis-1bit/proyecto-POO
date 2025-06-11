/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luisalejos.reporteincidente;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.Border;

/**
 *
 * @author alexis
 */
public class TipoIncidenteSelector extends JPanel {
    
    private String tipo;

    public TipoIncidenteSelector() {
    
        setPreferredSize(new Dimension(480, 360));
        
        ButtonGroup tipoIncidente = new ButtonGroup();
        JRadioButton incidenteTecnico = new JRadioButton("");
        JRadioButton incidenteSeguridad = new JRadioButton("");
        JRadioButton incidenteInstalacion = new JRadioButton("");
        
        incidenteSeguridad.setActionCommand("seguridad");
        
        Border bordeSeleccionado = BorderFactory.createDashedBorder(Color.BLUE, 3,2,2,true);
        Border bordeVacio = BorderFactory.createEmptyBorder(2, 2, 2, 2); // 
       
        
        ImageIcon iconoSeguridad = new ImageIcon("iconos/seguridad.png", "seguridad");
        ImageIcon iconoInstalacion = new ImageIcon("iconos/instalacion.png", "instalacion");
        ImageIcon iconoTecnico = new ImageIcon("iconos/tecnico.png", "tecnico");
        
        
        
        incidenteSeguridad.setBorder(bordeVacio);
        incidenteSeguridad.setBorderPainted(true);
        incidenteTecnico.setBorder(bordeVacio);
        incidenteTecnico.setBorderPainted(true);
        incidenteInstalacion.setBorder(bordeVacio);
        incidenteInstalacion.setBorderPainted(true);
        
        
        System.out.println(TipoIncidenteSelector.class.getResource("src/iconos/seguridad.png"));
        
        incidenteSeguridad.setIcon(iconoSeguridad);
        incidenteInstalacion.setIcon(iconoInstalacion);
        incidenteTecnico.setIcon(iconoTecnico);
       
        
        
        
        
        JButton test = new JButton("test");
        
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton boton = (JRadioButton) e.getSource();
              
                tipo = boton.getActionCommand();
                System.out.println("Opción seleccionada: " + tipo);
            }
        };

        ItemListener listener2 = e -> {
                JRadioButton boton = (JRadioButton) e.getSource();
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // 3. Aplicar el borde seleccionado
                    
                    boton.setBorder(bordeSeleccionado);
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    // 3. Quitar el borde (volver al vacío)
                    boton.setBorder(bordeVacio);
                }
            };
        
        
        
        
        
        tipoIncidente.add(incidenteTecnico);
        tipoIncidente.add(incidenteSeguridad);
        tipoIncidente.add(incidenteInstalacion);
        
        incidenteInstalacion.addActionListener(listener);
        incidenteTecnico.addActionListener(listener);
        incidenteSeguridad.addActionListener(listener);
        
        incidenteSeguridad.addItemListener(listener2);
        incidenteInstalacion.addItemListener(listener2);
        incidenteTecnico.addItemListener(listener2);
        
        add(incidenteInstalacion);
        add(incidenteTecnico);
        add(incidenteSeguridad);
        
        
       
    
        add(test);
        
        
        
    }
    
    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            JFrame ventana = new JFrame();
            
            
            
            
            public void run() {
                ventana.setDefaultCloseOperation(3);
                ventana.setLocationRelativeTo(null);
                
                
                
                ventana.add(new TipoIncidenteSelector());
                
                ventana.pack();
                ventana.setVisible(true);
            }
        });
        
    }
    
    
    
}
