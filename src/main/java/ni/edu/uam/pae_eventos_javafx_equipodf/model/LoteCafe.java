package ni.edu.uam.pae_eventos_javafx_equipodf.model;

public class LoteCafe {
    private String codigo;
    private String productor;
    private String variedad;
    private double pesoKg;

    public LoteCafe(String codigo, String productor, String variedad, double pesoKg) {
        this.codigo = codigo;
        this.productor = productor;
        this.variedad = variedad;
        this.pesoKg = pesoKg;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getProductor() { return productor; }
    public void setProductor(String productor) { this.productor = productor; }
    public String getVariedad() { return variedad; }
    public void setVariedad(String variedad) { this.variedad = variedad; }
    public double getPesoKg() { return pesoKg; }
    public void setPesoKg(double pesoKg) { this.pesoKg = pesoKg; }
}
