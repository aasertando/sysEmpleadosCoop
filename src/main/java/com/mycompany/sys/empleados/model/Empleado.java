/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sys.empleados.model;

/**
 *
 * @author aser
 */
import java.time.LocalDate;
public class Empleado {
    
    private String id;
    private String nombre;
    private String genero;
    private int estrato;
    private int horasExtra;
    private float salarioBasico;
    private LocalDate fecha;

    public Empleado(String id, String nombre, String genero, int estrato, int horasExtra, float salarioBasico, LocalDate fecha) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.estrato = estrato;
        this.horasExtra = horasExtra;
        this.salarioBasico = salarioBasico;
        this.fecha = fecha;
    }
    
    //inicio getter y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEstrato() {
        return estrato;
    }

    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }

    public float getSalarioBasico() {
        return salarioBasico;
    }

    public void setSalarioBasico(float salarioBasico) {
        this.salarioBasico = salarioBasico;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    //fin getter y setter
    
}
