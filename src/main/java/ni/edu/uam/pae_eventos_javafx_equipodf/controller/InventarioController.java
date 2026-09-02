package ni.edu.uam.pae_eventos_javafx_equipodf.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import ni.edu.uam.pae_eventos_javafx_equipodf.model.Producto;

public class InventarioController {

    @FXML private TextField txtCodigo;
    @FXML private TextField txtNombre;
    @FXML private TextField txtPrecio;
    @FXML private TextField txtCantidad;
    @FXML private Label lblEstado;

    @FXML private TableView<Producto> tablaProductos;
    @FXML private TableColumn<Producto, String> colCodigo;
    @FXML private TableColumn<Producto, String> colNombre;
    @FXML private TableColumn<Producto, Double> colPrecio;
    @FXML private TableColumn<Producto, Integer> colCantidad;

    private final ObservableList<Producto> listaProductos = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

        tablaProductos.setItems(listaProductos);
    }

    @FXML
    private void guardarProducto(ActionEvent event) {
        try {
            String codigo = txtCodigo.getText().trim();
            String nombre = txtNombre.getText().trim();

            if (codigo.isEmpty() || nombre.isEmpty()) {
                lblEstado.setText("Estado: Llene todos los campos requeridos.");
                return;
            }

            double precio = Double.parseDouble(txtPrecio.getText().trim());
            int cantidad = Integer.parseInt(txtCantidad.getText().trim());

            Producto p = new Producto(codigo, nombre, precio, cantidad);
            listaProductos.add(p);

            lblEstado.setText("Estado: Producto guardado correctamente.");
            limpiarCampos();

        } catch (NumberFormatException e) {
            lblEstado.setText("Estado: Precio y cantidad deben ser numéricos.");
        }
    }

    @FXML
    private void buscarConEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            String codigo = txtCodigo.getText().trim();
            if (codigo.isEmpty()) {
                lblEstado.setText("Estado: Ingrese un código para buscar.");
                return;
            }

            for (Producto p : listaProductos) {
                if (p.getCodigo().equalsIgnoreCase(codigo)) {
                    txtNombre.setText(p.getNombre());
                    txtPrecio.setText(String.valueOf(p.getPrecio()));
                    txtCantidad.setText(String.valueOf(p.getCantidad()));
                    lblEstado.setText("Estado: Producto encontrado.");
                    return;
                }
            }
            lblEstado.setText("Estado: No se encontró ningún producto con ese código.");
        }
    }

    private void limpiarCampos() {
        txtCodigo.clear();
        txtNombre.clear();
        txtPrecio.clear();
        txtCantidad.clear();
    }
}