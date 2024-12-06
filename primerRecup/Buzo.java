package primerRecup;
/**
 *
 * @author Marcelo
 */
public abstract class Buzo implements BuceoProfundo {

	private static final String NOMBRE_INVALIDO = "Nombre inválido";
	private static final String NACIONALIDAD_INVALIDA = "Nacionalidad inválida";
	private static final String EDAD_INVALIDA = "Un buzo no puede ser menor de edad";
	private String nombre;
	private String nacionalidad;
	private int edad;

	public Buzo(String nombre, String nacionalidad, int edad) {
            setNombre(nombre);
            setNacionalidad(nacionalidad);
            setEdad(edad);
	}

	private void setNombre(String nombre) {
            if (nombre == null || nombre.isEmpty()) {
            	throw new IllegalArgumentException(NOMBRE_INVALIDO);
            }
            this.nombre = nombre;
	}

	private void setNacionalidad(String nacionalidad) {
            if (nacionalidad == null || nacionalidad.isEmpty()) {
                throw new IllegalArgumentException(NACIONALIDAD_INVALIDA);
            }
            this.nacionalidad = nacionalidad;
	}

	private void setEdad(int edad) {
            if (edad < 18) {
                throw new IllegalArgumentException(EDAD_INVALIDA);
            }
            this.edad = edad;
	}

	public String getNombre() {
            return nombre;
	}

	public String getNacionalidad() {
            return nacionalidad;
	}

	public int getEdad() {
            return edad;
	}

	@Override
	public String toString() {
		return "Buzo [nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", edad=" + edad + "]";
	}

	public abstract boolean habilitado(int metros);

}
