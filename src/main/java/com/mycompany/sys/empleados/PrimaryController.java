package com.mycompany.sys.empleados;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.layout.*;

public class PrimaryController {
    
    //comentario para commit de prueba
    
    
    //comentario de prueba 2
    
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
    @FXML private VBox panelIngresar;
    @FXML private VBox panelBuscarLiquidar;
    @FXML private VBox panelListaSalarios;
    @FXML private VBox panelListaEmpleados;
    @FXML private VBox panelListaEstratos;
    
    
    @FXML
    private void mostrarPanelIngresar (){
        panelIngresar.toFront();
        panelIngresar.setVisible(true);
    }
    
    @FXML
    private void mostrarPanelBuscarLiquidar (){
        panelBuscarLiquidar.toFront();
        panelBuscarLiquidar.setVisible(true);
    }
    
    @FXML
    private void mostrarPanelListaSalario (){
        panelListaSalarios.toFront();
        panelListaSalarios.setVisible(true);
    }
    
    @FXML
    private void mostrarPanelListaEmpleado (){
        panelListaEmpleados.toFront();
        panelListaEmpleados.setVisible(true);
    }
    
    @FXML
    private void mostrarPanelListaEstrato (){
        panelListaEstratos.toFront();
        panelListaEstratos.setVisible(true);
    }
    //.toFront para que se pongan encima de todo y se vean
    //hago que sean visibles por si en el scenebuilder yo los marqué como invisibles
}
