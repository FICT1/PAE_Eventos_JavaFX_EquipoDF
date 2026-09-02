package ni.edu.uam.pae_eventos_javafx_equipodf.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Optional;

import ni.edu.uam.pae_eventos_javafx_equipodf.model.LoteCafe;

public class CafeController {

    @FXML private TextField txtCodigo;
    @FXML private TextField txtProductor;
    @FXML private TextField txtVariedad;
    @FXML private TextField txtPeso;
    @FXML private Label lblEstado;

    @FXML private TableView<LoteCafe> tablaLotes;
    @FXML private TableColumn<LoteCafe, String> colCodigo;
    @FXML private TableColumn<LoteCafe, String> colProductor;
    @FXML private TableColumn<LoteCafe, String> colVariedad;
    @FXML private TableColumn<LoteCafe, Double> colPeso;

    private final ObservableList<LoteCafe> listaLotes = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colProductor.setCellValueFactory(new PropertyValueFactory<>("productor"));
        colVariedad.setCellValueFactory(new PropertyValueFactory<>("variedad"));
        colPeso.setCellValueFactory(new PropertyValueFactory<>("pesoKg"));

        tablaLotes.setItems(listaLotes);
        configurarFilasInteractivas();
    }

    private void configurarFilasInteractivas() {
        tablaLotes.setRowFactory(tv -> {
            TableRow<LoteCafe> fila = new TableRow<>();

            MenuItem itemEditar = new MenuItem("Editar lote");
            itemEditar.setOnAction(event -> editarLote(fila.getItem()));

            MenuItem itemEliminar = new MenuItem("Eliminar lote");
            itemEliminar.setOnAction(event -> eliminarLote(fila.getItem()));

            ContextMenu menuContextual = new ContextMenu(itemEditar, itemEliminar);
            fila.contextMenuProperty().bind(
                    javafx.beans.binding.Bindings.when(fila.emptyProperty())
                            .then((ContextMenu) null)
                            .otherwise(menuContextual)
            );

            fila.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !fila.isEmpty()) {
                    mostrarDetalleLote(fila.getItem());
                }
            });

            return fila;
        });
    }

    @FXML
    private void guardarLote(ActionEvent event) {
        try {
            String codigo = txtCodigo.getText().trim();
            String productor = txtProductor.getText().trim();
            String variedad = txtVariedad.getText().trim();

            if (codigo.isEmpty() || productor.isEmpty() || variedad.isEmpty()) {
                lblEstado.setText("Estado: Llene todos los campos requeridos.");
                return;
            }

            double peso = Double.parseDouble(txtPeso.getText().trim());

            listaLotes.add(new LoteCafe(codigo, productor, variedad, peso));
            lblEstado.setText("Estado: Lote registrado correctamente.");
            limpiarCampos();

        } catch (NumberFormatException e) {
            lblEstado.setText("Estado: El peso debe ser un valor numérico.");
        }
    }

    @FXML
    private void accionCargarDemostracion(ActionEvent event) {
        listaLotes.clear();
        listaLotes.addAll(
                new LoteCafe("LOT-101", "Carlos Mendoza", "Caturra", 46.5),
                new LoteCafe("LOT-102", "Rosa Gutiérrez", "Bourbon", 52.0),
                new LoteCafe("LOT-103", "Esteban Ruiz", "Catuaí", 38.2),
                new LoteCafe("LOT-104", "María López", "Pacamara", 60.75)
        );
        lblEstado.setText("Estado: Datos de demostración cargados en la tabla.");
    }

    private void mostrarDetalleLote(LoteCafe lote) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Detalle del Lote");
        alert.setHeaderText("Lote " + lote.getCodigo());
        alert.setContentText(
                "Productor: " + lote.getProductor() + "\n" +
                        "Variedad: " + lote.getVariedad() + "\n" +
                        "Peso: " + lote.getPesoKg() + " kg"
        );
        alert.showAndWait();
    }

    private void editarLote(LoteCafe lote) {
        if (lote == null) return;

        TextInputDialog dialog = new TextInputDialog(lote.getProductor());
        dialog.setTitle("Editar Lote");
        dialog.setHeaderText("Modificar productor del lote " + lote.getCodigo());
        dialog.setContentText("Nuevo nombre del productor:");

        Optional<String> resultado = dialog.showAndWait();
        resultado.ifPresent(nuevoProductor -> {
            if (!nuevoProductor.trim().isEmpty()) {
                lote.setProductor(nuevoProductor.trim());
                tablaLotes.refresh();
                lblEstado.setText("Estado: Productor del lote " + lote.getCodigo() + " actualizado.");
            }
        });
    }

    private void eliminarLote(LoteCafe lote) {
        if (lote == null) return;

        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Eliminar Lote");
        confirmacion.setHeaderText("¿Está seguro de eliminar el lote " + lote.getCodigo() + "?");
        confirmacion.setContentText("Esta acción no se puede deshacer.");

        Optional<ButtonType> resultado = confirmacion.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            listaLotes.remove(lote);
            lblEstado.setText("Estado: Lote eliminado.");
        }
    }

    private void limpiarCampos() {
        txtCodigo.clear();
        txtProductor.clear();
        txtVariedad.clear();
        txtPeso.clear();
    }
}
