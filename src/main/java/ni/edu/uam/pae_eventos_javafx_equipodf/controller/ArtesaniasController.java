package ni.edu.uam.pae_eventos_javafx_equipodf.controller;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import ni.edu.uam.pae_eventos_javafx_equipodf.model.Artesania;

import java.util.Optional;

public class ArtesaniasController {

    @FXML private Label lblEstado;
    @FXML private TableView<Artesania> tablaArtesanias;
    @FXML private TableColumn<Artesania, ImageView> colImagen;
    @FXML private TableColumn<Artesania, String> colCodigo;
    @FXML private TableColumn<Artesania, String> colNombre;
    @FXML private TableColumn<Artesania, Double> colPrecio;

    private final ObservableList<Artesania> listaArtesanias = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colImagen.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getImagenView()));

        tablaArtesanias.setItems(listaArtesanias);
    }

    @FXML
    private void accionNuevo(ActionEvent event) {
        Artesania nueva = new Artesania("ART-" + (listaArtesanias.size() + 1), "Vasija de Barro", 350.00, "https://via.placeholder.com/40");
        listaArtesanias.add(nueva);
        lblEstado.setText("Acción: Se ha agregado una nueva artesanía.");
    }

    @FXML
    private void accionGuardar(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Guardar Catálogo");
        alert.setHeaderText(null);
        alert.setContentText("El catálogo actual de artesanías se ha guardado con éxito.");
        alert.showAndWait();
        lblEstado.setText("Acción: Catálogo guardado.");
    }

    @FXML
    private void accionCargarDemostración(ActionEvent event) {
        listaArtesanias.clear();
        listaArtesanias.addAll(
                new Artesania("ART-101", "Hamaca de Masaya", 1200.00, "https://via.placeholder.com/40"),
                new Artesania("ART-102", "Jarrón de San Juan de Oriente", 850.00, "https://via.placeholder.com/40"),
                new Artesania("ART-103", "Muñeca de Trapo", 250.00, "https://via.placeholder.com/40"),
                new Artesania("ART-104", "Cesta de Fibra Natural", 400.00, "https://via.placeholder.com/40"),
                new Artesania("ART-105", "Collar de Chaquira", 150.00, "https://via.placeholder.com/40"),
                new Artesania("ART-106", "Máscara de Madera", 600.00, "https://via.placeholder.com/40"),
                new Artesania("ART-107", "Tapiz Bordado", 950.00, "https://via.placeholder.com/40")

        );
        lblEstado.setText("Acción: Datos de demostración cargados en la tabla.");
    }

    @FXML
    private void accionBuscar(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Buscar Artesanía");
        dialog.setHeaderText("Búsqueda por código");
        dialog.setContentText("Ingrese código:");
        Optional<String> result = dialog.showAndWait();

        result.ifPresent(codigo -> {
            for (Artesania a : listaArtesanias) {
                if (a.getCodigo().equalsIgnoreCase(codigo)) {
                    tablaArtesanias.getSelectionModel().select(a);
                    lblEstado.setText("Acción: Artesanía encontrada -> " + a.getNombre());
                    return;
                }
            }
            lblEstado.setText("Acción: Artesanía no encontrada.");
        });
    }

    @FXML
    private void accionAcercaDe(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ayuda");
        alert.setHeaderText("Gestión de Tienda de Artesanías");
        alert.setContentText("Módulo diseñado para la gestión de productos artesanales nicaragüenses.");
        alert.showAndWait();
    }
}