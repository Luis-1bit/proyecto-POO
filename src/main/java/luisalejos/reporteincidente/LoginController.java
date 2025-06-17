/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luisalejos.reporteincidente;

/**
 *
 * @author alexis
 */
public class LoginController {
    private AppModel modelo;
    private VistaInicioOperativo vista;
    private AppController appController; // Para poder navegar

    public LoginController(AppModel modelo, VistaLogin vista, AppController appController) {
        this.modelo = modelo;
        this.vista = vista;
        this.appController = appController;

        // Añadir listener al botón de la vista
        this.vista.addLoginListener(e -> autenticarUsuario());
    }

    private void autenticarUsuario() {
        String user = vista.getUsuario();
        String pass = vista.getPassword();

        if (modelo.autenticar(user, pass)) {
            // Si la autenticación en el modelo es exitosa...
            // ...le pedimos al controlador principal que cambie de vista.
            appController.mostrarDashboard();
        } else {
            // Manejar error (en una app real)
            System.out.println("Credenciales incorrectas");
        }
    }
}
