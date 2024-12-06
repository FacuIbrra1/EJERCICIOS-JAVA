package segundoRecup;

/**
 *
 * @author admin
 */
public enum AmbienteDeseado {
    EN_EL_SALON(0),
    EN_LA_VEREDA(1);
    
    private int indice;
    
    AmbienteDeseado(int indice) {
        this.indice = indice;
    }

    public int getIndice() {
        return this.indice;
    }
}
