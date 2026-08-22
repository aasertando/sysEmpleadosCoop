package com.mycompany.sys.empleados;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {
    
    //comentario para commit de prueba

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
