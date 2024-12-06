package segundoRecup;

import java.util.ArrayList;

public class Restaurante {
    private final int CANT_AMBIENTES = 2;
    private final int CANT_MESAS_POR_AMBIENTE = 10;

    private String nombre;
    private ArrayList<Producto> productos;
    private Ticket [] [] ubicacionMesas;


    public Restaurante(String nombre, ArrayList<Producto> nuevosProductos) {
        this.nombre = nombre;
        this.productos = nuevosProductos;
        this.ubicacionMesas = new Ticket[CANT_AMBIENTES][CANT_MESAS_POR_AMBIENTE];
    }
    
     
    public int abrirMesa(AmbienteDeseado ambiente)
    {
        int nuevaMesa = -1;
        if (ambiente != null)
        {
            int indice = ambiente.getIndice();
            int ubicacion = this.buscarMesaLibre(ambiente);
            if (ubicacion != -1 )
            {
                int numeroMesa = (10 * indice) + (ubicacion + 1);
                this.ubicacionMesas[indice][ubicacion] = new Ticket(numeroMesa);
                nuevaMesa = numeroMesa;
            }
        }
        
        return nuevaMesa;
    }
    
    
    private int buscarMesaLibre(AmbienteDeseado ambienteBuscado){
        int j = 0;
        int posic = -1;
        int indice = ambienteBuscado.getIndice();
        while (j < this.ubicacionMesas[indice].length && this.ubicacionMesas[indice][j] != null) 
        {
            j++;
        }
        if ( j < this.ubicacionMesas[indice].length){
            posic = j;
        }
        
        return posic;
    }
    
    
    
    public void registrarComanda(int numeroMesa, String pedido, int cantPorciones)
    {
        Producto pedidoAgregado = buscarProducto(pedido);
        if (pedidoAgregado != null)
        {
            int fila = this.obtieneFilaUbic(numeroMesa);
            int columna = this.obtieneColumnaUbic(numeroMesa);
            this.ubicacionMesas[fila][columna].agregarItem(pedidoAgregado, cantPorciones);
        }
    }
    
    private Producto buscarProducto(String descripcion){
        Producto productoBuscado = null;
        int i = 0;
        while (i < this.productos.size() && productoBuscado == null)
        {
            if (this.productos.get(i).getDescripcion() == descripcion)
            {
                productoBuscado = this.productos.get(i);
            } 
            else 
            {
                i++;
            }
        }
        return productoBuscado;
    }
    
    private int obtieneFilaUbic(int laMesa){
        int fila = 0;
        if (laMesa > 10)
        { 
            fila = 1;
        }
        return fila;
    }
    
    private int obtieneColumnaUbic(int laMesa){
        return laMesa - ( 10 * obtieneFilaUbic(laMesa)) - 1;
    }
    
    
    public void cerrarMesa(int laMesa){
        int fila = this.obtieneFilaUbic(laMesa);
        int columna = this.obtieneColumnaUbic(laMesa);
        this.ubicacionMesas[fila][columna].mostrarTicket();
/*  agregar a histo */
        this.ubicacionMesas[fila][columna] = null;
    }

}