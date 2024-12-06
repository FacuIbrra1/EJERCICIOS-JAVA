package segundoRecup;
import java.util.ArrayList;
/**
 *
 * @author admin
 */
public class Ticket {
    private static int numerador;
    private int numeroDeTicket;
    private int numeroDeMesa;
    private ArrayList<Item> items;
    
    public Ticket(int numeroDeMesa){
        Ticket.numerador++;
        this.setNumeroDeMesa(numeroDeMesa);
        this.setNumeroDeTicket(Ticket.numerador);
        this.items = new ArrayList<Item>();
    }

    public void setNumeroDeTicket(int numeroDeTicket) {
        this.numeroDeTicket = numeroDeTicket;
    }

    public void setNumeroDeMesa(int numeroDeMesa) {
        this.numeroDeMesa = numeroDeMesa;
    }

    public int getNumeroDeTicket() {
        return numeroDeTicket;
    }

    public int getNumeroDeMesa() {
        return numeroDeMesa;
    }
    
    public void agregarItem(Producto nuevoArticulo, int cantidad){
        this.items.add(new Item(nuevoArticulo,cantidad));
    }

    
    private double obtenerTotal(){
        double total = 0;
        for (Item itemActual : this.items) {
            total += itemActual.obtenerImporteItem();
        }
        return total;
    }
    
    public void mostrarTicket() {
        System.out.println("Numero de Ticket : " + numerador);
        System.out.println("Numero de Mesa: " + numeroDeMesa);
        System.out.println("Detalle:");
        for (Item item : items) {
            System.out.println(item.getCantidad() + " x " + item.getProducto().getDescripcion() + " = " + item.obtenerImporteItem());
        }
        System.out.println("Total a pagar: " + obtenerTotal());
    }
    
      
}
