package ni.edu.uam.pae_eventos_javafx_equipodf.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ni.edu.uam.pae_eventos_javafx_equipodf.model.Artesania;

public class ArtesaniasController {

    @FXML private TableView<Artesania> tablaArtesanias;
    @FXML private TableColumn<Artesania, String> colImagen;
    @FXML private TableColumn<Artesania, String> colCodigo;
    @FXML private TableColumn<Artesania, String> colNombre;
    @FXML private TableColumn<Artesania, Double> colPrecio;
    @FXML private Label lblNotificacion;

    private final ObservableList<Artesania> listaArtesanias = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        colImagen.setCellValueFactory(new PropertyValueFactory<>("urlImagen"));
        colImagen.setCellFactory(param -> new TableCell<>() {
            private final ImageView imageView = new ImageView();

            @Override
            protected void updateItem(String urlImagen, boolean empty) {
                super.updateItem(urlImagen, empty);
                if (empty || urlImagen == null || urlImagen.isEmpty()) {
                    setGraphic(null);
                } else {
                    try {
                        Image img = new Image(urlImagen, 40, 40, true, true);
                        imageView.setImage(img);
                        setGraphic(imageView);
                    } catch (Exception e) {
                        setGraphic(null);
                    }
                }
            }
        });

        tablaArtesanias.setItems(listaArtesanias);
    }

    @FXML
    private void cargarDatosEjemplo(ActionEvent event) {
        listaArtesanias.clear();
        listaArtesanias.add(new Artesania("ART-01", "Jarrón de Barro", 350.00, "https://via.placeholder.com/40/8B4513/FFFFFF?text=Jarron"));
        listaArtesanias.add(new Artesania("ART-02", "Hamaca Masaya", 1200.00, "https://via.placeholder.com/40/008080/FFFFFF?text=Hamaca"));
        lblNotificacion.setText("Acción: Cátalogo de demostración cargado.");
    }

    @FXML
    private void accionNuevo(ActionEvent event) {
        lblNotificacion.setText("Acción: Menú/Herramienta 'Nuevo' ejecutada.");
    }

    @FXML
    private void accionGuardar(ActionEvent event) {
        lblNotificacion.setText("Acción: Menú/Herramienta 'Guardar' ejecutada.");
    }
    @FXML
    private void accionAyuda(ActionEvent event) {
        lblNotificacion.setText("Acción: Módulo de Ayuda abierto.");
    }
}