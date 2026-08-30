/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sys.empleados.model;

/**
 *
 * @author aser
 */
public class ResumenEstrato {

    private int estrato;
    private int cantidad;
    private String aplica;

    public ResumenEstrato(int estrato, int cantidad, String aplica) {
        this.estrato = estrato;
        this.cantidad = cantidad;
        this.aplica = aplica;
    }

    public int getEstrato() {
        return estrato;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getAplica() {
        return aplica;
    }

}
