package primerRecup;
/**
 *
 * @author Marcelo
 */
public interface BuceoProfundo {

	/**
	 * Indica si la entidad puede realizar, o no, buceos mayores a 30 metros
	 * @return
	 */
	boolean habilitadoBuceoProfundo();
	
	/**
	 * Indica si la entidad puede realizar, o no, buceos de hasta 30 metros inclusive 
	 * @return
	 */
	boolean habilitadoBuceoMedio();
}
