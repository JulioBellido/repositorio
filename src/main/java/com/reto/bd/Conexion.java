/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto.bd;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
/**
 *
 * @author ADMIN
 */
public class Conexion {
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;
static {
    config.setJdbcUrl( "jdbc:mysql://localhost:3306/reto?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" );
    config.setUsername( "root" );
    config.setPassword( "julio" );
    config.setDriverClassName("com.mysql.cj.jdbc.Driver");
ds = new HikariDataSource( config );
}
private Conexion() {}

public static Connection getConnection() throws SQLException {
return ds.getConnection();
}
}
