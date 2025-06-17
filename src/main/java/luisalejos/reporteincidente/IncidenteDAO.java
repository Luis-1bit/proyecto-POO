/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luisalejos.reporteincidente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IncidenteDAO {

    public void crearIncidente(Incidente incidente) {
        Connection conn = null;
        System.out.println(System.getProperty("user.dir"));
        // Sentencia SQL para la tabla base 'Incidentes'
        String sqlIncidenteBase = "INSERT INTO Incidentes (titulo, descripcion, fecha_reporte, estado, prioridad, dni_personal_reporta, tipo_incidente) VALUES (?, ?, now(), ?, ?, ?, ?)";
        
        // Sentencias SQL para las tablas específicas
        String sqlIncidenteEspecifico = "";
        
        // Determinar el tipo de incidente para preparar la segunda inserción
        if (incidente instanceof IncidenteTecnico) {
            sqlIncidenteEspecifico = "INSERT INTO Incidentes_Tecnico (dispositivo_afectado, marca, modelo, numero_serie, ubicacion) VALUES (?, ?, ?, ?, ?)";
       

        try {
            conn = BaseDeDatos.getInstance().getConexion();
            
            // ---> INICIO DE LA TRANSACCIÓN <---
            conn.setAutoCommit(false);

            // 1. Insertar en la tabla base 'Incidentes'
            try (PreparedStatement pstmtBase = conn.prepareStatement(sqlIncidenteBase)) {
               
                pstmtBase.setString(1, incidente.getTitulo());
                pstmtBase.setString(2, incidente.getDescripcion());
                pstmtBase.setString(3, incidente.getEstado());
                pstmtBase.setString(4, incidente.getPrioridad());
            
              
                
                
                
                pstmtBase.setString(5, incidente.getReportadoPor().getDniPersonal());
               
                
                // Asignar el tipo de incidente (discriminador)
                if (incidente instanceof IncidenteTecnico) {
                    pstmtBase.setString(6, "tecnico");
                } 
                
                pstmtBase.executeUpdate();
            }

            // 2. Insertar en la tabla específica
            try (PreparedStatement pstmtEspecifico = conn.prepareStatement(sqlIncidenteEspecifico)) {
                if (incidente instanceof IncidenteTecnico) {
                    IncidenteTecnico tecnico = (IncidenteTecnico) incidente;
                   
                    pstmtEspecifico.setString(1, tecnico.getDispositivoAfectado());
                    pstmtEspecifico.setString(2, tecnico.getMarca());
                    pstmtEspecifico.setString(3, tecnico.getModelo());
                    pstmtEspecifico.setString(4, tecnico.getNumeroSerie());
                    pstmtEspecifico.setString(5, tecnico.getUbicacion());
                } // ... else if para otros tipos
                
                pstmtEspecifico.executeUpdate();
            }

            // ---> CONFIRMAR LA TRANSACCIÓN <---
            // Si ambas inserciones fueron exitosas, se confirman los cambios.
            conn.commit();
            System.out.println("Incidente creado exitosamente!");

        } catch (SQLException e) {
            System.err.println("Error en la transacción. Realizando rollback...");
            e.printStackTrace();
            if (conn != null) {
                try {
                    // ---> REVERTIR LA TRANSACCIÓN <---
                    // Si algo falló, se deshacen todos los cambios desde el setAutoCommit(false).
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true); // Restaurar el modo por defecto
                    conn.close(); // Cerrar la conexión
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    }
}
