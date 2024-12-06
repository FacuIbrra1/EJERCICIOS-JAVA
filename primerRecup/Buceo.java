package primerRecup;
/**
 *
 * @author Marcelo
 */
public class Buceo {
    
    private static final int CANTIDAD_MESES=12;
    private static final int MAXIMO_BUZOS=10;
    private int id;
    private String nombrePuntoBuceo;
    private int profundidad;
    private int [] reservasMensuales;

    public Buceo(int id, String nombrePuntoBuceo, int profundidad) {
        this.id = id;
	this.nombrePuntoBuceo = nombrePuntoBuceo;
	this.profundidad = profundidad;
        this.reservasMensuales = new int [CANTIDAD_MESES];
    }

    public boolean agregarBuzoEnSalida(int mes) {
        boolean pudo = false;
        if (this.reservasMensuales[mes] < Buceo.MAXIMO_BUZOS){
            this.reservasMensuales[mes]++;
            pudo = true;
        }
        return pudo;
    }

    
    @Override
    public String toString() {
    	return "Buceo [id=" + id + ", nombrePuntoBuceo=" + nombrePuntoBuceo + ", profunidad=" + profundidad + "]";
    }
	
    public int getId() {
    	return id;
    }

    public boolean nombreBuceo(String nombreBuceo) {
        return this.nombrePuntoBuceo.equals(nombreBuceo);
    }

    public int getProfundidad() {
        return this.profundidad;
    }
}
