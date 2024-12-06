package segundoParcial;
/**
 *
 * @author Marcelo
 */
public class PruebaExpendedora {

    public static void main(String[] args) {
        try {
            Expendedora maquina = new Expendedora("Super Maquinita");
			
            System.out.println("--- Agregado de productos... ---");
            agregarProductos(maquina);
//          maquina.listarProductos();
            System.out.println("--- Aplicando actualizaciones de precio... ---");
            actualizarPrecio(maquina);

            System.out.println("--- Listados ---");
            maquina.mostrarHistoricoActualizaciones();
//            maquina.mostrarErrores();
            
	} catch (RuntimeException re) {
            System.out.println(re.getMessage());
	}
    }

    private static void agregarProductos(Expendedora maquina) {
        agregar(maquina, new Producto(1, 1300.0, "Alfajor Josecito"));
	agregar(maquina, new Producto(2, 1200.0, "Cindor"));
	agregar(maquina, new Producto(3, 1500.0, "Turrón Pirulito"));
	agregar(maquina, new Producto(3, 1500.0, "Chupetín Topolin"));
    }

    private static void actualizarPrecio(Expendedora maquina) {
        maquina.ajustarPrecio(1, null);
        maquina.ajustarPrecio(1, new ActualizacionPorcentual(10));
	maquina.ajustarPrecio(2, new ActualizacionPorMonto(2000));
	maquina.ajustarPrecio(2, new ActualizacionPorMonto(-2500));
	maquina.ajustarPrecio(1, new ActualizacionDirecta(-1));
    }

    private static void agregar(Expendedora maquina, Producto producto) {
    	try {
            maquina.agregarProducto(producto);
        } catch (RuntimeException e) {
            System.out.println("Error agregando un producto: " + e.getMessage());
	}
    }
}
