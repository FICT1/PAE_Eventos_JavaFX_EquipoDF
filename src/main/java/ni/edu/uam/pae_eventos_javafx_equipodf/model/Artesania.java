package ni.edu.uam.pae_eventos_javafx_equipodf.model;

import javafx.scene.image.ImageView;

public class Artesania {
    private String codigo;
    private String nombre;
    private double precio;
    private String imagenUrl;

    public Artesania(String codigo, String nombre, double precio, String imagenUrl) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.imagenUrl = imagenUrl;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public String getImagenUrl() { return imagenUrl; }

    public ImageView getImagenView() {
        try {
            ImageView img = new ImageView(imagenUrl);
            img.setFitWidth(40);
            img.setFitHeight(40);
            img.setPreserveRatio(true);
            return img;
        } catch (Exception e) {
            return new ImageView();
        }
    }
}