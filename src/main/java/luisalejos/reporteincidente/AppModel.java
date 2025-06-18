/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luisalejos.reporteincidente;

/**
 *
 * @author alexis
 */

public class AppModel {
    
    
    private Personal personalLogueado;
    
    
    

    public Personal getUsuarioLogueado() {
        return personalLogueado;
    }

    public void setUsuarioLogueado(Personal usuarioLogueado) {
        this.personalLogueado = usuarioLogueado;
    }

    // Lógica de negocio: autenticar usuario
    public boolean autenticar(String user, String pass) {
         AuthService authService = new AuthService();
        // Simulación: en una app real, aquí se consultaría una base de datos.
        if (authService.verificarCredenciales(user, pass)) {
            
            
            System.out.println(user);
            Personal usuario = new AuthService().obtenerDatosPersonalPorDni(user);
            
            if(usuario != null) {
                this.setUsuarioLogueado(usuario);
                return true;
            }
           
            
        }
        this.personalLogueado = null;
        return false;
    }

    public void cerrarSesion() {
        this.personalLogueado = null;
    }
}