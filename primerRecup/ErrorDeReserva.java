package primerRecup;
/**
 *
 * @author Marcelo
 */
public class ErrorDeReserva {

    private String nombreBuzo;
    private String descripcionError;

    public ErrorDeReserva(String nombreBuzo,String descripcionError){
        this.setNombreBuzo(nombreBuzo);
        this.setDescripcionError(descripcionError);
    }
    
    private void setNombreBuzo(String nombreBuzo) {
        this.nombreBuzo = nombreBuzo;
    }

    private void setDescripcionError(String descripcionError) {
        this.descripcionError = descripcionError;
    }

    @Override
    public String toString() {
        return "ErrorDeReserva{" + "nombreBuzo=" + nombreBuzo + ", descripcionError=" + descripcionError + '}';
    }
    
    
    
}
