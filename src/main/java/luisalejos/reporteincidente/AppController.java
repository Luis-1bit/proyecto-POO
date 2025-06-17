/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luisalejos.reporteincidente;

import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author alexis
 */
public class AppController {
    
    private JPanel contenedorVistas;
    private CardLayout cardLayout;

    public AppController(JPanel contenedor, CardLayout layout) {
        this.contenedorVistas = contenedor;
        this.cardLayout = layout;
    }

    public void mostrarLogin() {
        cardLayout.show(contenedorVistas, "login");
    }

    public void mostrarInicioOperativo() {
        cardLayout.show(contenedorVistas, "inicioOperativo");
    }
    
    
}
