package com.mycompany.sys.empleados;

import com.mycompany.sys.empleados.model.Empleado;
import java.io.IOException;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class PrimaryController {
    
    
    //comentario para commit de prueba

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
    //nombre de los campos de la vista
    @FXML
    private TextField inputIdEmpleado;
    private TextField inputNombreEmpleado;
    private TextField inputSalarioBasicoEmpleado;
    private CheckBox checkHombreEmpleado;
//    private ComboBox<Integer> comboEstratoEmpleado;
    private TextField inputHorasExtraEmpleado;
    private DatePicker inputFechaEmpleado;
    
    //lo equivalente a init component en swing normal
    //esto para llenar los estratos
//    @FXML
//    public void Initializable(){
//        comboEstratoEmpleado.getItems().addAll(2, 3, 4, 5, 6, 7, 8);
//    }

//    @FXML
//    private void buscarEmpleadoPorId(String id){
//        
//        String nombre = inputNombreEmpleado.getText();
//        String salarioBasico = inputSalarioBasicoEmpleado.getText();
//        float horasExtras = Float.parseFloat(inputHorasExtraEmpleado.getText());
//        LocalDate fecha = inputFechaEmpleado.getValue();
//        String genero = null;
//        
//        if (checkHombreEmpleado.isSelected()){
//            genero = "hombre";
//        } else {
//            genero = "mujer";
//        }
//        
//        
//        
//        
////        Empleado e = new Empleado(id, id, id, 0, 0, 0, LocalDate.EPOCH)
//    }
    
    
}
