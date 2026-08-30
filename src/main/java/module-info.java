module com.mycompany.sys.empleados {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.mycompany.sys.empleados to javafx.fxml;
    opens com.mycompany.sys.empleados.model to javafx.fxml, javafx.base;

    exports com.mycompany.sys.empleados;
}