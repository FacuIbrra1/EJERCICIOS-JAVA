package primerRecup;
import java.util.ArrayList;
/**
 *
 * @author Marcelo
 */
public class CentroBuceoAvanzado {

    private static final String BUCEO_INVALIDO = "Buceo Inválido";
    private static final int CANTIDAD_BUCEOS = 10;
    private String nombre;
        
    private ArrayList<ErrorDeReserva> erroresDeReserva;
    private Buceo [] buceosDisponibles;
    private ArrayList<Buzo> buzosRegistrados;

    public CentroBuceoAvanzado(String nombre,Buceo [] salidasDeBuceo) {
        this.setNombre(nombre);
        this.erroresDeReserva = new ArrayList<>();
        this.buzosRegistrados = new ArrayList<>();
        //this.buceosDisponibles = new Buceo [CANTIDAD_BUCEOS]; 
        this.buceosDisponibles = salidasDeBuceo; 
    }

    private void setNombre(String nombre) {
        if (nombre.isEmpty() || nombre==null) {
            throw new RuntimeException("NOMBRE INVALIDO");
        } 
        this.nombre = nombre;
    }

    public void registrarBuceo(Buzo buzo, int idBuceo, int elMes) 
    {    
        if (buzo == null) 
        {
            erroresDeReserva.add(new ErrorDeReserva("sin nombre","Buzo nulo"));
	} 
        else 
        {
            String nombreBuzo = buzo.getNombre();
            Buceo buceo = buscarBuceo(idBuceo);
            if (buceo == null) 
            {
            	erroresDeReserva.add(new ErrorDeReserva(nombreBuzo,"Buceo no disponible"));
            } 
            else if (!buzo.habilitado(buceo.getProfundidad())) 
            {
                erroresDeReserva.add(new ErrorDeReserva(nombreBuzo,"Buzo no habilitado por profundidad"));
            } 
            else 
            {
                if (!buceo.agregarBuzoEnSalida(elMes)) 
                {
                    erroresDeReserva.add(new ErrorDeReserva(nombreBuzo,"No hay lugar en el buceo elegido"));
                } 
                else 
                {
                    this.buzosRegistrados.add(buzo);
                }
            }
	}
    }

    private Buceo buscarBuceo(int idBuceoBuscado) {
        Buceo buceoBuscado = null;
        int posic = 0;
        while (posic < this.buceosDisponibles.length && this.buceosDisponibles[posic]!= null && this.buceosDisponibles[posic].getId()!= idBuceoBuscado) 
        {
            posic++;
        }
        if (posic < this.buceosDisponibles.length) 
        {
            buceoBuscado = this.buceosDisponibles[posic];
        }
        return buceoBuscado;
    }
    
    public void listarErrores() {
    	System.out.println("Listado de errorres de registración");
        for (ErrorDeReserva errorActual : this.erroresDeReserva) {
            System.out.println(errorActual);
        }
    }

}
