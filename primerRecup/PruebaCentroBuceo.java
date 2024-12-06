package primerRecup;
/**
 *
 * @author Marcelo
 */
public class PruebaCentroBuceo {
    
    public static void main(String[] args) {
        
        final int MAXIMO_LUGARES_DE_BUCEO = 10;
        
        Buceo [] salidasDeBuceo = new Buceo [MAXIMO_LUGARES_DE_BUCEO];

	System.out.println("Se Agregan buceos");
        cargarBuceos(salidasDeBuceo);

        CentroBuceoAvanzado cba = new CentroBuceoAvanzado("UTN Diving Center",salidasDeBuceo);

        System.out.println("Se registran buceadores");
	registrarBuceadores(cba);
		
	System.out.println("Listados");
	cba.listarErrores();
    }

    private static void cargarBuceos(Buceo [] salidasDeBuceo) {
        salidasDeBuceo [0] = new Buceo(6, "Isla Victoria", 18);
	salidasDeBuceo [1] = new Buceo(2, "Dique Piedras Moras", 23);
	salidasDeBuceo [2] = new Buceo(8, "Parque Nacional de Tierra del Fuego", 20);
	salidasDeBuceo [3] = new Buceo(4, "Los Reyunos", 25);
	salidasDeBuceo [4] = new Buceo(3, "Bosque sumergido de Villa Traful", 20);
	salidasDeBuceo [5] = new Buceo(1, "Dique Segunda Usina", 35);
	salidasDeBuceo [6] = new Buceo(10, "Puerto Madryn", 30);
	salidasDeBuceo [7] = new Buceo(5, "Nahuel Huapi", 22);
	salidasDeBuceo [8] = new Buceo(7, "Golfo San Matías", 30);
	salidasDeBuceo [9] = new Buceo(9, "Pirámides", 25);
    }

    private static void registrarBuceadores(CentroBuceoAvanzado cba) {
    	registrarBuceadorOpenWater(cba, "Juan", "Argentino", 23, 3,4);
    	registrarBuceadorOpenWater(cba, "John", "Norteamericano", 16, 1,4);
    	registrarBuceadorOpenWater(cba, "Catalina", "Argentina", 23, 5,4);
    	registrarBuceadorOpenWater(cba, "Catalina", "Argentina", 23, 10,4);
        registrarBuceadorAdvanced(cba, "Esteban", "Argentino", 23, 3,4);
	registrarBuceadorAdvanced(cba, "", "Chileno", 23, 3,4);
	registrarBuceadorAdvanced(cba, "Ricardo", "Español", 23, 7,4);
	registrarBuceadorAdvanced(cba, "Juana", null, 23, 7,4);
	registrarBuceadorAdvanced(cba, "Carolina", "Argentina", 23, 1,4);
	registrarBuceadorTecnico(cba, "Maximiliano", "Argentino", 23, 1,4);
	registrarBuceadorTecnico(cba, "Maximiliano", "Argentino", 23, 144,4);
	registrarBuceadorTecnico(cba, "Juana", "Argentina", 23, 2,4);
	registrarBuceadorTecnico(cba, "Josefa", "Argentino", 23, 7,4);
    }

    private static void registrarBuceadorOpenWater(CentroBuceoAvanzado cba, String nombre, String nacionalidad,
			int edad, int idBuceo, int elMes) {
        try {
            cba.registrarBuceo(new BuzoOpenWater(nombre, nacionalidad, edad), idBuceo,elMes);
	} catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
	}
    }

    private static void registrarBuceadorAdvanced(CentroBuceoAvanzado cba, String nombre, String nacionalidad, int edad,
    			int idBuceo, int elMes) {
        try {
            cba.registrarBuceo(new BuzoAdvancedOpenWater(nombre, nacionalidad, edad), idBuceo,elMes);
	} catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
	}
    }

    private static void registrarBuceadorTecnico(CentroBuceoAvanzado cba, String nombre, String nacionalidad, int edad,
    			int idBuceo, int elMes) {
        try {
            cba.registrarBuceo(new BuzoTecnico(nombre, nacionalidad, edad), idBuceo,elMes);
	} catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
	}

    }
}