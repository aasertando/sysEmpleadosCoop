package com.mycompany.sys.empleados;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.*;

public class PrimaryController {
    
    //comentario para commit de prueba
    //commit de prueba
    
    //comentario de prueba 2
    
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
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
    public void initialize(){
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
}
