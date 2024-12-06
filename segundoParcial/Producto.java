package segundoParcial;
import java.util.ArrayList;
/**
 *
 * @author Marcelo
 */
public class Producto implements Apreciable {

	private static final String MSJ_AJUSTE_INVALIDO = "Actualizacion Invalido";
	private final static String MSJ_PRECIO_INVALIDO = "Precio Invalido";
	private final static String MSJ_NOMBRE_INVALIDO = "Nombre Invalido";
	private static final String MSJ_ID_INVALIDO = "ID Invalido";

	private int id;
	private String nombre;

	private ArrayList<HistoricoActualizacion> historicoActualizaciones;

	public Producto(int id, double precioInicial, String nombre) {
            setId(id);
            setNombre(nombre);
            this.historicoActualizaciones = new ArrayList<>();
            setPrecio(precioInicial);
	}

	private void setPrecio(double precio) {
            aplicarActualizacion(new ActualizacionDirecta(precio));
	}

	private void setNombre(String nombre) {
            if (nombre == null || nombre.isEmpty()) {
            	throw new RuntimeException(MSJ_NOMBRE_INVALIDO);
            }
            this.nombre = nombre;
	}

	private void setId(int id) {
            if (id < 1) {
            	throw new RuntimeException(MSJ_ID_INVALIDO);
            }
            this.id = id;
	}

	public int getId() {
            return id;
	}
	
	public boolean mismoId(int otroId) {
            return otroId==this.id;
	}
	
	public String getNombre() {
            return nombre;
	}

	public double obtenerPrecio() {
            double ultimoPrecio = 0;
            if (historicoActualizaciones.size()>0) 
            {
            	ultimoPrecio = historicoActualizaciones.get(historicoActualizaciones.size()-1).getPrecio();
            }
            return ultimoPrecio;
	}

	@Override
	public String toString() {
            return "Producto [id=" + id + ", precio=" + obtenerPrecio() + ", nombre=" + nombre + "]";
	}

	@Override
	public void aplicarActualizacion(Actualizacion actualizacion) throws RuntimeException {
            if (actualizacion == null) {
                throw new RuntimeException(MSJ_AJUSTE_INVALIDO);
            }
            double precio = obtenerPrecio();
            double nuevoPrecio = 0;
            if (actualizacion instanceof ActualizacionDirecta){
            	nuevoPrecio = ((ActualizacionDirecta) actualizacion).obtenerValorCalculado();	// upcasting explícito
            } else {
            	nuevoPrecio = ((ActualizacionExtendida) actualizacion).obtenerValorCalculado(precio);
            }
            if (nuevoPrecio < 0) {
            	throw new RuntimeException(MSJ_PRECIO_INVALIDO);
            }
            this.historicoActualizaciones.add(new HistoricoActualizacion(actualizacion, precio, nuevoPrecio));
	}  

	public void listarActualizacionesDePrecio() {
            System.out.println("Mostrando actualizaciones de: " + this);
            for (HistoricoActualizacion actActual : this.historicoActualizaciones) {
                System.out.println(actActual);
            }
            System.out.println("*---------------------------------------------------------------------*");
	}
}