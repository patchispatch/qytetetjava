package modeloqytetet;

public class Especulador extends Jugador {
    
    //final int factorEspeculador;
    private int fianza;
    
    public Especulador(Jugador jugador, int fianza) {
        super(jugador);
        this.fianza = fianza;
    }
    
    @Override
    int getFactorEspeculador() {
        return super.factorEspeculador * 2;
    }
    
    @Override
    protected void pagarImpuestos(int cantidad) {
        modificarSaldo(-(cantidad/2));
    }
    
    private boolean pagarFianza() {
        boolean resultado;
        
        if(saldo > fianza) {
            modificarSaldo(-fianza);
            resultado = true;
        }
        
        else
            resultado = false;
        
        return resultado;
    }
    
    @Override
    protected void irACarcel(Casilla casilla) {
        if(!pagarFianza()) {
            super.irACarcel(casilla);
        }
    }
    
    @Override
    protected Especulador convertirme(int fianza) {
    
        return this;
    }
    
}
