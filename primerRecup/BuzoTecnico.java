package primerRecup;
/**
 *
 * @author Marcelo
 */
/**
 * Buzo con autorización para bajar mas alla de los 30 metros.
 *
 */
public class BuzoTecnico extends Buzo {

    public BuzoTecnico(String nombre, String nacionalidad, int edad) {
        super(nombre, nacionalidad, edad);
    }

    @Override
    public boolean habilitadoBuceoProfundo() {
        return true;
    }

    @Override
    public boolean habilitadoBuceoMedio() {
        return true;
    }
	
    @Override
    public boolean habilitado(int metros) {
        return true;
    }

}