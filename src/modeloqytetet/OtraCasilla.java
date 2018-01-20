package modeloqytetet;


public class OtraCasilla extends Casilla {

    public OtraCasilla(int numeroCasilla, int coste, TipoCasilla tipo) {
        super(numeroCasilla, coste, tipo);
    }
    
    @Override
    boolean soyEdificable(){
        return false;
    }
    
    @Override
    public String toString() {
        String resultado = super.toString();
        
        return resultado;
    }
}
