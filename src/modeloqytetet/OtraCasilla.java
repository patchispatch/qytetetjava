package modeloqytetet;


public class OtraCasilla extends Casilla {
    
    private TipoCasilla tipo;

    public OtraCasilla(int numeroCasilla, int coste, TipoCasilla tipo) {
        super(numeroCasilla, coste);
        this.tipo = tipo;
    }
       
    public TipoCasilla getTipo() {
        return tipo;
    }
    
    @Override
    boolean soyEdificable(){
        return false;
    }
        
    
}
