package com.mycompany.sys.empleados;

import com.mycompany.sys.empleados.model.Empleado;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.control.TextField; // importante para las cajas de texto

public class PrimaryController {
    
    //comentario para commit de prueba
    //commit de prueba
    
    //comentario de prueba 2
    
    // declaracion vector empleado y su respectivo contador con un limite de 20
    private Empleado[] listaEmpleados = new Empleado[20]; 
    private int contadorEmpleados = 0; 
    
    //textfields del panel de ingreso 
    
    // vinculalos al scene builder
    @FXML private TextField txtIngresarId;         
    @FXML private TextField txtIngresarNombre;
    @FXML private TextField txtIngresarGenero;     
    @FXML private TextField txtIngresarHorasExtra;
    @FXML private TextField txtIngresarEstrato;
    @FXML private TextField txtIngresarSalario;
    
    // Label opcional en el panel de ingreso para dar taza de éxito o error
    @FXML private Label lblEstadoIngreso; 
    
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
    //labels tomados de el esqueleto que hace scene builder de la pantalla buscar (factura)
     @FXML
    private Label lblBuscarArl;

    @FXML
    private Label lblBuscarEstrato;

    @FXML
    private Label lblBuscarHorasExtraTrabajadas;

    @FXML
    private Label lblBuscarNeto;

    @FXML
    private Label lblBuscarNombre;

    @FXML
    private Label lblBuscarPagoHorasExtra;

    @FXML
    private Label lblBuscarPension;

    @FXML
    private Label lblBuscarSalarioBasico;

    @FXML
    private Label lblBuscarSalud;

    @FXML
    private Label lblBuscarSubTransporte;

    @FXML
    private Label lblBuscarValorHora;
    
    //inicio de funcionamiento de botones laterales de la interfaz
    @FXML private VBox panelIngresar;
    @FXML private VBox panelBuscarLiquidar;
    @FXML private VBox panelListaSalarios;
    @FXML private VBox panelListaEmpleados;
    @FXML private VBox panelListaEstratos;
    
    @FXML
    private void ocultarPaneles () {
        
    panelIngresar.setVisible(false);
    panelBuscarLiquidar.setVisible(false);
    panelListaSalarios.setVisible(false);
    panelListaEmpleados.setVisible(false);
    panelListaEstratos.setVisible(false);
}
    
    //como el initComponents en swing, ejecuta al iniciar
    @FXML
    public void initializer(){
        mostrarPanelBuscarLiquidar();
    }
    
    
    @FXML
    private void mostrarPanelIngresar (){
        ocultarPaneles();
        panelIngresar.toFront();
        panelIngresar.setVisible(true);
    }
    
    @FXML
    private void mostrarPanelBuscarLiquidar (){
        ocultarPaneles();
        panelBuscarLiquidar.toFront();
        panelBuscarLiquidar.setVisible(true);
    }
    
    @FXML
    private void mostrarPanelListaSalario (){
        ocultarPaneles();
        panelListaSalarios.toFront();
        panelListaSalarios.setVisible(true);
    }
    
    @FXML
    private void mostrarPanelListaEmpleado (){
        ocultarPaneles();
        panelListaEmpleados.toFront();
        panelListaEmpleados.setVisible(true);
    }
    
    @FXML
    private void mostrarPanelListaEstrato (){
        ocultarPaneles();
        panelListaEstratos.toFront();
        panelListaEstratos.setVisible(true);
    }
    
    //ocultarPaneles()  oculta todo
    //.toFront()             para que se ponga encima de todo
    //.setVisible()         para que se vea el requerido
    // Enlaza este método en la propiedad "On Action" de tu botón en Scene Builder
    @FXML
    private void handleGuardarEmpleado() {
        // Valida si el vector estático tiene casillas libres
        if (contadorEmpleados < listaEmpleados.length) {
            try {
                // Capturar strings de los TextField de JavaFX
                String id = txtIngresarId.getText();
                String nombre = txtIngresarNombre.getText();
                String genero = txtIngresarGenero.getText();
                
                // Conversión de tipos numéricos
                int horasExtra = Integer.parseInt(txtIngresarHorasExtra.getText());
                int estrato = Integer.parseInt(txtIngresarEstrato.getText());
                float salarioBasico = Float.parseFloat(txtIngresarSalario.getText()); 

                LocalDate fechaIngreso = LocalDate.now(); 

                Empleado nuevoEmpleado = new Empleado(id, nombre, genero, estrato, horasExtra, salarioBasico, fechaIngreso);

                listaEmpleados[contadorEmpleados] = nuevoEmpleado;
                contadorEmpleados++; // Pasamos a la siguiente posición vacía
                
                txtIngresarId.clear();
                txtIngresarNombre.clear();
                txtIngresarGenero.clear();
                txtIngresarHorasExtra.clear();
                txtIngresarEstrato.clear();
                txtIngresarSalario.clear();

                if (lblEstadoIngreso != null) {
                    lblEstadoIngreso.setText("¡Empleado guardado! Total: " + contadorEmpleados);
                }
                
            } catch (NumberFormatException e) {
                if (lblEstadoIngreso != null) {
                    lblEstadoIngreso.setText("Error: Verifique los campos numéricos.");
                }
            }
        } else {
            if (lblEstadoIngreso != null) {
                lblEstadoIngreso.setText("Error: Vector lleno.");
            }
        }
    }
    
    private void hacerRecibo(Empleado e){
        
        double subsidioTransporte = 0;
        double aporteSalud = 0;
        double aportePension = 0;
        double aporteARL = 0;
        double netoHorasExtra = 0;
        double pagoNeto = 0;
        double valorHora = 0;
        
//        String id = e.getId();
        String nombre = e.getNombre();
        int horasExtra = e.getHorasExtra();
        int estrato = e.getEstrato();
        float salarioBasico = e.getSalarioBasico();
        
        aporteSalud = salarioBasico * 0.04;
        aportePension = salarioBasico * 0.0375;
        aporteARL = salarioBasico * 0.02;
        
        //para saber los años trabajados
        LocalDate fechaIngreso = e.getFecha();
        LocalDate fechaHoy = LocalDate.now();
        
        Period tiempoTrabajado = Period.between(fechaIngreso, fechaHoy);
        int añosTrabajados = tiempoTrabajado.getYears();
        
        //para establecer el valor de la hora según los años trabajados
        if (añosTrabajados > 10){
            valorHora = 45000;
        } else {
            if (añosTrabajados >= 5 && añosTrabajados ==10){
                valorHora = 35000;
            } else {
                if (añosTrabajados >= 3 && añosTrabajados < 5){
                    valorHora = 30000;
                } else {
                    if(añosTrabajados < 3){
                        valorHora = 25000;
                    }
                }
            }
        }
        
        if (estrato == 1 || estrato == 2){
            subsidioTransporte = 78000;
        }
        
        netoHorasExtra = horasExtra * valorHora;
        pagoNeto = (salarioBasico + netoHorasExtra) - subsidioTransporte;
        
        //colocacion de la info en los label
        lblBuscarNombre.setText(nombre);
        lblBuscarSalarioBasico.setText(String.valueOf(salarioBasico));
        lblBuscarHorasExtraTrabajadas.setText(String.valueOf(horasExtra));
        lblBuscarValorHora.setText(String.valueOf(valorHora));
        lblBuscarEstrato.setText(String.valueOf(estrato));
        lblBuscarSubTransporte.setText(String.valueOf(subsidioTransporte));
        lblBuscarPagoHorasExtra.setText(String.valueOf(netoHorasExtra));
        lblBuscarSalud.setText(String.valueOf(aporteSalud));
        lblBuscarPension.setText(String.valueOf(aportePension));
        lblBuscarArl.setText(String.valueOf(aporteARL));
        lblBuscarNeto.setText(String.valueOf(pagoNeto));
        
    }
    
//    este es el metodo para que cuando el programa se inicie haga
//    automaticamente el recibo, pero, para eso debemos mandarle
//    un empleado, para eso la variable ' e ', estoy a la espera de que
//    mi compañero termine su trabajo para poder hacer esto.
    
//    public void initialize(e){
//        hacerRecibo(e);
//    }
    
}
