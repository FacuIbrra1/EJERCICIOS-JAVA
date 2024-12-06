package segundoRecup;

/**
 *
 * @author admin
 */
public class Bebida extends Producto {
    private boolean esVino;

    public Bebida(boolean esVino, String descripcion, double precioBase) {
        super(descripcion, precioBase);
        this.esVino = esVino;
    }

    @Override
    public double obtenerPrecioVenta() {
        double precioVenta = getPrecioBase();
        if (esVino) {
            precioVenta *= 1.05;
        }
        return precioVenta;
    }
}
