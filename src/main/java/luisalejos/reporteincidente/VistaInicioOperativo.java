/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luisalejos.reporteincidente;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author alexis
 */
public class VistaInicioOperativo extends JPanel {
    
    private JLabel etiquetaBienvenida = new JLabel("¡Bienvenido!");
    private JButton botonLogout = new JButton("Salir");

    public VistaInicioOperativo() {
        this.add(etiquetaBienvenida);
        this.add(botonLogout);
    }
    
    // Método para que el controlador actualice el saludo
    public void setSaludo(String nombre) {
        etiquetaBienvenida.setText("¡Bienvenido, " + nombre + "!");
    }

    public void addLogoutListener(ActionListener listener) {
        botonLogout.addActionListener(listener);
    }
}
    

