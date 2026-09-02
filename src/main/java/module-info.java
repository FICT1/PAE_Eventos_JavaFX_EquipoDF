module ni.edu.uam.pae_eventos_javafx_equipodf {
    requires javafx.controls;
    requires javafx.fxml;

    opens ni.edu.uam.pae_eventos_javafx_equipodf to javafx.fxml;
    opens ni.edu.uam.pae_eventos_javafx_equipodf.controller to javafx.fxml;
    opens ni.edu.uam.pae_eventos_javafx_equipodf.model to javafx.base, javafx.fxml;

    exports ni.edu.uam.pae_eventos_javafx_equipodf;
}