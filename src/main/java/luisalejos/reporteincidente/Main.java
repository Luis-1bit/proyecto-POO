package luisalejos.reporteincidente;

import java.security.CryptoPrimitive;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

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
        
       IncidenteDAO ind = new IncidenteDAO();
       IncidenteTecnico it = new IncidenteTecnico();
       
       it.setTitulo("servidor no funciona");
       it.setDescripcion("el dispositivo estaba funcionando de manera correcta hasta hoy en la mañana");
       it.setEstado("abierto");
       it.setPrioridad("baja");
       
       
       
       it.setDispositivoAfectado("Servidor");
       it.setMarca("DELL");
       it.setModelo("DX-2301H");
       it.setNumeroSerie("1023-2025");
       it.setUbicacion("Piso 2 - Lab 201");
       
       ind.crearIncidente(it);
    }
    
}
