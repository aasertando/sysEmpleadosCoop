package com.mycompany.sys.empleados;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // 1. Ampliamos las dimensiones iniciales a 1100 x 680
        scene = new Scene(loadFXML("primary"), 1280, 750);
        
        // 2. Título de la ventana
        stage.setTitle("Sistema de Nómina");
        
        // 3. Establecemos límites mínimos para que no se recorte el diseño
        stage.setMinWidth(980);
        stage.setMinHeight(620);
        
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        System.setProperty("glass.gtk.uiScale", "1.25"); // Prueba con 1.25 o 1.3
        launch();
    }

}