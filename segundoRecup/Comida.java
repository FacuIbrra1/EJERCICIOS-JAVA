package segundoRecup;

/**
 *
 * @author admin
 */
public class Comida extends Producto {
    private double pesoPorcion;

    public Comida(double pesoPorcion, String descripcion, double precioBase) {
        super(descripcion, precioBase);
        this.pesoPorcion = pesoPorcion;
    }

    @Override
    public double obtenerPrecioVenta() {
        return getPrecioBase() * pesoPorcion;
    }
}
