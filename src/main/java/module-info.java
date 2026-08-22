module com.mycompany.sys.empleados {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.sys.empleados to javafx.fxml;
    exports com.mycompany.sys.empleados;
}
