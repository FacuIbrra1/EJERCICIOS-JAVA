package segundoRecup;
import java.util.ArrayList;
/**
 *
 * @author Marcelo
 */
public class PruebaRestaurante {
    
    public static void main(String[] args) {
        
/*  se crean productos*/        
        ArrayList<Producto> nuevosProductos = new ArrayList<Producto>();
        nuevosProductos.add(new Comida(150,"bife de chorizo",10000));
        nuevosProductos.add(new Comida(250,"milanesa a caballo",6000)); // 4500000.0
//        nuevosProductos.add(new Comida(1,"milanesa a caballo",6000)); Pruebo las cuentas pasandole 1 gramo para chequear la cuenta de Precio por pesoPorcion
        nuevosProductos.add(new Comida(200,"ravioles",4000));
        nuevosProductos.add(new Bebida(false,"gaseosa",1000));
        nuevosProductos.add(new Bebida(true,"vino tinto",9000));
        nuevosProductos.add(new Bebida(true,"vino blanco",8000));

/*  se crea el restaurante con sus productos*/        
        Restaurante miResto = new Restaurante("una papa",nuevosProductos);

        System.out.println("probando mesas");
        probarMesa(miResto,AmbienteDeseado.EN_EL_SALON);
        probarMesa(miResto,AmbienteDeseado.EN_EL_SALON);
        probarMesa(miResto,AmbienteDeseado.EN_LA_VEREDA);

    }

    private static void probarMesa(Restaurante miResto,AmbienteDeseado ambiente){
        int laMesa = miResto.abrirMesa(ambiente);
        if (laMesa!=-1){
            System.out.println("Se abre la mesa "+laMesa);
            miResto.registrarComanda(laMesa, "milanesa a caballo", 3);
            miResto.registrarComanda(laMesa, "vino tinto", 3);
            miResto.cerrarMesa(laMesa);
            System.out.println("*--------------------------------*");
        } else {
            System.out.println("no hay lugar disponibles en el ambiente deseado");
        }
    }
    
}