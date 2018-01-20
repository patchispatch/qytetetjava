package modeloqytetet;


   public abstract class Casilla {
    
        protected int numeroCasilla;
        protected int coste;
        protected TipoCasilla tipo;
    
    public Casilla(int numero, int cost, TipoCasilla type) {
        numeroCasilla = numero;
        coste = cost;
        tipo = type;
    }

    public int getCoste() {
        return coste;
    }
    
    public int getNumeroCasilla() {
        return numeroCasilla;
    }
    
    public TipoCasilla getTipo() {
        return tipo;
    }
    
    abstract boolean soyEdificable();
    
    @Override
    public String toString() {
        String resultado;
        
        resultado = "Número de casilla: " + numeroCasilla + 
                    "\nCoste: " + coste;
        
        return resultado;
    }
    
    
}
