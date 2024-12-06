package segundoParcial;
import java.util.ArrayList;
/**
 *
 * @author Marcelo
 */
public class Expendedora {

	private final static String MSJ_NOMBRE_INVALIDO = "Nombre Invalido";
	private final static String MSJ_ID_INVALIDO = "ID de producto Invalido";
	private static final String MSJ_ACTUALIZACION_NULA = "La actualizacion no puede ser nula";
	private static final String MSJ_PRODUCTO_NULO = "El producto no puede ser nulo";
	private static final String MSJ_PRODUCTO_REPETIDO = "ID de producto ya existente";
        private static final int CANTIDAD_PRODUCTOS = 30;
        
	private String nombre;
        private Producto [] productos;
        private ArrayList<String> erroresDeActualizacion;
        
	public Expendedora(String nombre) {
            this.setNombre(nombre);
            this.productos = new Producto [CANTIDAD_PRODUCTOS];
            this.erroresDeActualizacion = new ArrayList<>();
	}

	private void setNombre(String nombre) {
            if (nombre == null || nombre.isEmpty()) {
                throw new RuntimeException(MSJ_NOMBRE_INVALIDO);
            }
            this.nombre = nombre;
	}

	public void agregarProducto(Producto nuevoProd) {
            if (nuevoProd == null) {
                throw new RuntimeException(MSJ_PRODUCTO_NULO);
            }
            Producto aux = buscarProducto(nuevoProd.getId());
            if (aux != null) {
            	throw new RuntimeException(MSJ_PRODUCTO_REPETIDO);
            }
            int posic=0;
            while (posic<this.productos.length && this.productos[posic]!=null) {
                posic++;
            }
            if (posic != this.productos.length) {
                this.productos[posic] = nuevoProd;
            } else {
            	throw new RuntimeException("no se pueden agregar más productos");
            }
	}

	private Producto buscarProducto(int idBuscado) {
            Producto producto = null;
            int posicion = 0;
            while(posicion < this.productos.length && this.productos[posicion]!=null &&
                this.productos[posicion].getId()!= idBuscado) {
		posicion++;
            }
            if (posicion < this.productos.length) {
		producto = this.productos[posicion];
            }
            return producto;
	}

	public void ajustarPrecio(int idProducto, Actualizacion actualizacion) {
            Producto producto = this.buscarProducto(idProducto);
            if (producto == null) {
                agregarError(MSJ_ID_INVALIDO, idProducto, actualizacion);
            } else if (actualizacion == null) {
                agregarError(MSJ_ACTUALIZACION_NULA, idProducto, actualizacion);
            } else {
                try {
                    producto.aplicarActualizacion(actualizacion);
		} catch (RuntimeException re) {
                    agregarError(re.getMessage(), idProducto, actualizacion);
		}
            }
	}

	private void agregarError(String mensaje, int idProducto, Actualizacion actualizacion) {
            erroresDeActualizacion.add(
                String.format("%s - %s - %s", mensaje, idProducto, actualizacion));
	}

	public void mostrarHistoricoActualizaciones() {
            System.out.println();
            System.out.println("Resumen actualizacion de precio de la maquina: " + this.nombre);
            System.out.println("Se muestra cada producto.");
            for (Producto productoActual : this.productos) {
                if (productoActual!=null) {
                    productoActual.listarActualizacionesDePrecio();
                }
            }
	}

	public void mostrarErrores() {
            System.out.println();
            System.out.println("Errores de actualizacion de precio de la maquina: " + this.nombre);
            if (this.erroresDeActualizacion.size()>0){
                for (String errorActual : this.erroresDeActualizacion){
                    if (!errorActual.isEmpty()){
                        System.out.println(errorActual);
                    }
                }
            } else {
                System.out.println("No se detectaron errores de actualizacion de precio de la maquina: " + this.nombre);
            }
	}
        
        public void listarProductos() {
            System.out.println();
            System.out.println("Listado de productos de la maquina: " + this.nombre);
            for (Producto productoActual : this.productos) {
            	System.out.println(productoActual);
            }
	}        
}
