package segundoRecup;

/**
 *
 * @author admin
 */
public abstract class Producto {
    private String descripcion;
    private double precioBase;

    public Producto(String descripcion, double precioBase) {
        this.descripcion = descripcion;
        this.precioBase = precioBase;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public abstract double obtenerPrecioVenta();
}
