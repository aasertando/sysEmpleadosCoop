package com.mycompany.sys.empleados;

import com.mycompany.sys.empleados.model.Empleado;
import com.mycompany.sys.empleados.model.OrdenamientoEmpleados;
import com.mycompany.sys.empleados.model.ResumenEstrato;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;

public class PrimaryController {

    private Empleado[] listaEmpleados = new Empleado[20];
    private int contadorEmpleados = 0;

    @FXML
    private TableColumn<Empleado, Integer> columnaEmpleadosEstrato;
    @FXML
    private TableColumn<Empleado, String> columnaEmpleadosId;
    @FXML
    private TableColumn<Empleado, String> columnaEmpleadosNombre;
    @FXML
    private TableColumn<Empleado, Float> columnaEmpleadosSueldoBasico;

    @FXML
    private TableColumn<ResumenEstrato, String> columnaEstratosAplica;
    @FXML
    private TableColumn<ResumenEstrato, Integer> columnaEstratosCantidad;
    @FXML
    private TableColumn<ResumenEstrato, Integer> columnaEstratosEstrato;

    @FXML
    private TableColumn<Empleado, Float> columnaSalariosBase;
    @FXML
    private TableColumn<Empleado, String> columnaSalariosCedula;
    @FXML
    private TableColumn<Empleado, Double> columnaSalariosNeto;
    @FXML
    private TableColumn<Empleado, String> columnaSalariosNombre;
    @FXML
    private TableView<Empleado> columnaSalariosSalarioBase;
    @FXML
    private TableColumn<Empleado, Double> columnaSalariosTotalDescontado;
    @FXML
    private TableColumn<Empleado, Double> columnaSalariosTotalGanado;

    @FXML
    private ComboBox<String> comboEstratoEmpleado;
    @FXML
    private RadioButton comboHombreEmpleado;

    @FXML
    private DatePicker inputFechaEmpleado;
    @FXML
    private TextField inputHorasExtraEmpleado;
    @FXML
    private TextField inputIdEmpleado;
    @FXML
    private TextField inputNombreEmpleado;
    @FXML
    private TextField inputSalarioBasicoEmpleado;

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

    @FXML
    private VBox panelBuscarLiquidar;
    @FXML
    private VBox panelIngresar;
    @FXML
    private VBox panelListaEmpleados;
    @FXML
    private VBox panelListaEstratos;
    @FXML
    private VBox panelListaSalarios;

    @FXML
    private TableView<Empleado> tablaEmpleados;
    @FXML
    private TableView<ResumenEstrato> tablaEstratos;

    @FXML
    private TextField txtBuscarId;

    //es como initComponents
    @FXML
    public void initialize() {
        //colocar los numeros para crear el empleado
        comboEstratoEmpleado.getItems().add("1");
        comboEstratoEmpleado.getItems().add("2");
        comboEstratoEmpleado.getItems().add("3");
        comboEstratoEmpleado.getItems().add("4");
        comboEstratoEmpleado.getItems().add("5");
        comboEstratoEmpleado.getItems().add("6");
        comboEstratoEmpleado.setValue("1");

        //listado de salarios
        columnaSalariosCedula.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnaSalariosNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaSalariosBase.setCellValueFactory(new PropertyValueFactory<>("salarioBasico"));
        columnaSalariosNeto.setCellValueFactory(new PropertyValueFactory<>("salarioNeto"));
        columnaSalariosTotalGanado.setCellValueFactory(new PropertyValueFactory<>("totalGanado"));
        columnaSalariosTotalDescontado.setCellValueFactory(new PropertyValueFactory<>("totalDescontado"));

        //listado de empleados
        columnaEmpleadosId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnaEmpleadosNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaEmpleadosEstrato.setCellValueFactory(new PropertyValueFactory<>("estrato"));
        columnaEmpleadosSueldoBasico.setCellValueFactory(new PropertyValueFactory<>("salarioBasico"));

        //listado de estratos
        columnaEstratosEstrato.setCellValueFactory(new PropertyValueFactory<>("estrato"));
        columnaEstratosCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        columnaEstratosAplica.setCellValueFactory(new PropertyValueFactory<>("aplica"));

        mostrarPanelBuscarLiquidar();
    }

    private void ocultarPaneles() {
        panelIngresar.setVisible(false);
        panelBuscarLiquidar.setVisible(false);
        panelListaSalarios.setVisible(false);
        panelListaEmpleados.setVisible(false);
        panelListaEstratos.setVisible(false);
    }

    @FXML
    void mostrarPanelBuscarLiquidar() {
        ocultarPaneles();
        panelBuscarLiquidar.toFront();
        panelBuscarLiquidar.setVisible(true);
    }

    @FXML
    void mostrarPanelIngresar() {
        ocultarPaneles();
        panelIngresar.toFront();
        panelIngresar.setVisible(true);
    }

    @FXML
    void mostrarPanelListaSalario() {
        ocultarPaneles();
        panelListaSalarios.toFront();
        panelListaSalarios.setVisible(true);

        //punto 1 quicksort por salario neto descendente
        Empleado[] listaOrdenados = listaEmpleados.clone();
        OrdenamientoEmpleados.quicksortPorNeto(listaOrdenados, 0, contadorEmpleados - 1);

        ObservableList<Empleado> datos = FXCollections.observableArrayList();
        for (int i = 0; i < contadorEmpleados; i++) {
            datos.add(listaOrdenados[i]);
        }
        columnaSalariosSalarioBase.setItems(datos);
    }

    @FXML
    void mostrarPanelListaEmpleado() {
        ocultarPaneles();
        panelListaEmpleados.toFront();
        panelListaEmpleados.setVisible(true);

        // punto 2: seleccion por nombre ascendente
        Empleado[] ordenados = listaEmpleados.clone();
        OrdenamientoEmpleados.seleccionPorNombre(ordenados, contadorEmpleados);

        ObservableList<Empleado> datos = FXCollections.observableArrayList();
        for (int i = 0; i < contadorEmpleados; i++) {
            datos.add(ordenados[i]);
        }
        tablaEmpleados.setItems(datos);
    }

    @FXML
    void mostrarPanelListaEstrato() {
        ocultarPaneles();
        panelListaEstratos.toFront();
        panelListaEstratos.setVisible(true);

        // punto 3: shell por estrato descendente
        Empleado[] ordenados = listaEmpleados.clone();
        OrdenamientoEmpleados.shellPorEstrato(ordenados, contadorEmpleados);

        ObservableList<ResumenEstrato> resumen = FXCollections.observableArrayList();

        for (int i = 0; i < contadorEmpleados; i++) {
            int estrato = ordenados[i].getEstrato();
            boolean yaContado = false;

            for (int j = 0; j < i; j++) {
                if (ordenados[j].getEstrato() == estrato) {
                    yaContado = true;
                }
            }

            if (!yaContado) {
                int cantidad = 0;
                for (int k = 0; k < contadorEmpleados; k++) {
                    if (ordenados[k].getEstrato() == estrato) {
                        cantidad++;
                    }
                }
                String aplica = (estrato == 1 || estrato == 2) ? "Si" : "No";
                resumen.add(new ResumenEstrato(estrato, cantidad, aplica));
            }
        }

        tablaEstratos.setItems(resumen);
    }

    @FXML
    void handleGuardarEmpleado() {
        if (contadorEmpleados >= listaEmpleados.length) {
            JOptionPane.showMessageDialog(null, "Vector lleno.");
            return;
        }

        if (inputIdEmpleado.getText().isEmpty() || inputNombreEmpleado.getText().isEmpty()
                || comboEstratoEmpleado.getValue() == null || inputFechaEmpleado.getValue() == null
                || inputHorasExtraEmpleado.getText().isEmpty() || inputSalarioBasicoEmpleado.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.");
            return;
        }

        if (!inputHorasExtraEmpleado.getText().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(null, "Las horas extra deben ser un numero.");
            return;
        }

        if (!inputSalarioBasicoEmpleado.getText().matches("[0-9]+(\\.[0-9]+)?")) {
            JOptionPane.showMessageDialog(null, "El salario debe ser un numero.");
            return;
        }

        String id = inputIdEmpleado.getText();
        String nombre = inputNombreEmpleado.getText();
        String genero = comboHombreEmpleado.isSelected() ? "Hombre" : "Mujer";
        int estrato = Integer.parseInt(comboEstratoEmpleado.getValue());
        int horasExtra = Integer.parseInt(inputHorasExtraEmpleado.getText());
        float salarioBasico = Float.parseFloat(inputSalarioBasicoEmpleado.getText());
        LocalDate fechaIngreso = inputFechaEmpleado.getValue();

        Empleado nuevoEmpleado = new Empleado(id, nombre, genero, estrato, horasExtra, salarioBasico, fechaIngreso);
        listaEmpleados[contadorEmpleados] = nuevoEmpleado;
        contadorEmpleados++;

        inputIdEmpleado.clear();
        inputNombreEmpleado.clear();
        inputHorasExtraEmpleado.clear();
        inputSalarioBasicoEmpleado.clear();
        comboEstratoEmpleado.setValue(null);
        inputFechaEmpleado.setValue(null);
    }

    @FXML
    void handleBuscarEmpleado() {
        String idBuscado = txtBuscarId.getText();

        if (idBuscado.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un id para buscar.");
            return;
        }

        for (int i = 0; i < contadorEmpleados; i++) {
            if (listaEmpleados[i].getId().equals(idBuscado)) {
                hacerRecibo(listaEmpleados[i]);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No se encontro un empleado con ese id.");
    }

    private void hacerRecibo(Empleado e) {
        String nombre = e.getNombre();
        int horasExtra = e.getHorasExtra();
        int estrato = e.getEstrato();
        float salarioBasico = e.getSalarioBasico();

        double valorHora = e.getValorHora();
        double subsidioTransporte = e.getSubsidioTransporte();
        double aporteSalud = salarioBasico * 0.04;
        double aportePension = salarioBasico * 0.0375;
        double aporteARL = salarioBasico * 0.02;
        double netoHorasExtra = horasExtra * valorHora;
        double pagoNeto = e.getSalarioNeto();

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

    @FXML
    void handleSalir() {
        System.exit(0);
    }
}
