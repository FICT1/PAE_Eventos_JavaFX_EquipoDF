module ni.edu.uam.pae_eventos_javafx_equipodf {
    requires javafx.controls;
    requires javafx.fxml;


    opens ni.edu.uam.pae_eventos_javafx_equipodf to javafx.fxml;
    exports ni.edu.uam.pae_eventos_javafx_equipodf;
}