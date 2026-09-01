package ni.edu.uam.pae_eventos_javafx_equipodf.model;

public class Artesania {
    private String codigo;
    private String nombre;
    private double precio;
    private String urlImagen;

    public Artesania(String codigo, String nombre, double precio, String urlImagen) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.urlImagen = urlImagen;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public String getUrlImagen() { return urlImagen; }
}