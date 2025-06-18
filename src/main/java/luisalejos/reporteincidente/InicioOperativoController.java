/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luisalejos.reporteincidente;

/**
 *
 * @author alexis
 */
public class InicioOperativoController {
    
    private AppModel modelo;
    private VistaInicioOperativo vista;
    private AppController appController;

    public InicioOperativoController(AppModel modelo, VistaInicioOperativo vista, AppController appController) {
        this.modelo = modelo;
        this.vista = vista;
        this.appController = appController;
        
        // Cargar los datos iniciales cuando se crea el controlador
        this.cargarDatos();

        // Añadir listener para el logout
        this.vista.addLogoutListener(e -> cerrarSesion());
        this.vista.addVerIncidentesListener(e -> verIncidentes());
    }

    public void cargarDatos() {
        
        Personal usuario = modelo.getUsuarioLogueado();
        if (usuario != null) {
            vista.setSaludo(usuario.getNombre());
        }
    }
    
    private void verIncidentes() {
        
    
        appController.mostrarListaIncidentes();
    }
    
    
    
    private void cerrarSesion() {
        modelo.cerrarSesion();
        appController.mostrarLogin();
    }
    
    
}
