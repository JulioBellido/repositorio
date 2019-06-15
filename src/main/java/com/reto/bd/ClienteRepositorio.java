/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;


/**
 *
 * @author ADMIN
 */

public class ClienteRepositorio {
    
    public static List<Cliente> listarclientes() throws SQLException {
    String SQL_QUERY = "select * from cliente";
    List<Cliente> clientes = null;
    try (Connection con = Conexion.getConnection();
        PreparedStatement pst = con.prepareStatement( SQL_QUERY );
        ResultSet rs = pst.executeQuery();) {
            clientes = new ArrayList<>();
            Cliente cliente;
            while ( rs.next() ) {
                cliente = new Cliente();
                 cliente.setNombre(rs.getString("nombre" ) ); 
                 cliente.setApellido(rs.getString("apellido" ) ); 
                 cliente.setEdad(rs.getString("edad" ) ); 
                 cliente.setFechaNacimiento(rs.getDate("fechanac" ) );
                 cliente.setFechaMuerte("80");
                clientes.add( cliente );
            }
    } 
    return clientes;
}
    
    public static String kpiclientes() throws SQLException {
    String SQL_QUERY = "select round(avg(edad),2) promedio, round(stddev_pop(edad),2) desv_stand from  cliente";
    String resultprom = null;
    String resultdesv = null;
    String resultado = null;
    try (Connection con = Conexion.getConnection();
        PreparedStatement pst = con.prepareStatement( SQL_QUERY );
        ResultSet rs = pst.executeQuery();) {
        
        while ( rs.next() ) {
          resultprom = rs.getString("promedio");
          resultdesv = rs.getString("desv_stand");
        }
        
        resultado = "Promedio: " + resultprom + "   Desviacion Estandar: " + resultdesv;

    } 
    return resultado;
}

    public static String Grabar(Cliente cliente) throws SQLException {
    String SQL_QUERY = "insert into cliente (nombre,apellido,edad,fechanac)values(?,?,?,?)";
    Connection con = Conexion.getConnection();
        PreparedStatement pst = con.prepareStatement( SQL_QUERY );
        pst.setString(1,cliente.getNombre());
        pst.setString(2,cliente.getApellido());
        pst.setString(3,cliente.getEdad());
        pst.setDate(4,cliente.getFechaNacimiento());

        pst.executeUpdate();
    
   
    return "ok";
}  
    
}
