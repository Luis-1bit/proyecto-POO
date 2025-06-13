package luisalejos.reporteincidente;

import java.sql.Timestamp;
import java.time.Instant;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alexis
 */
public class Main {
    public static void main(String[] args) {
         IncidenteTecnico nuevoIncidente = new IncidenteTecnico();
        
        // Datos para la tabla base 'Incidentes'
       
        nuevoIncidente.setTitulo("El proyector de la sala de juntas no enciende");
        nuevoIncidente.setDescripcion("El proyector marca Epson no da señal de video al conectar una laptop.");
        nuevoIncidente.setEstado("abierto");
        nuevoIncidente.setPrioridad("media");
        nuevoIncidente.setReportadoPor("12345678"); // ID de Ana Torres
            // ID de Lucia Fernandez
        
        // Datos específicos para 'Incidentes_Tecnico'
        nuevoIncidente.setDispositivoAfectado("Proyector");
        nuevoIncidente.setMarca("Epson");
        nuevoIncidente.setModelo("PowerLite S41+");
        nuevoIncidente.setNumeroSerie("EPS-PL-98765");
        nuevoIncidente.setUbicacion("Sala de Juntas, Piso 4");

        // 2. Usar el DAO para guardarlo en la base de datos
        IncidenteDAO dao = new IncidenteDAO();
        dao.crearIncidente(nuevoIncidente);
    }
    
}
