/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto.bd;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class Cliente {
     private String nombre;

    private String apellido;
    private String edad;

    private Date fechanacimiento;
    private String fechamuerte;

    public Date getFechaNacimiento() {
		return fechanacimiento;
	}

	public void setFechaNacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
    }

    public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
    }


    public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
    }

    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
    }
    
        public String getFechaMuerte() {
		return fechamuerte;
	}

	public void setFechaMuerte(String fechamuerte) {
		this.fechamuerte = fechamuerte;
    }
}
