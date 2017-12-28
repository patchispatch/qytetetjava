package modeloqytetet;


   public abstract class Casilla {
    
        protected int numeroCasilla;
        protected int coste;
    

    /*
    public Casilla(int numeroCasilla, int coste, TipoCasilla tipo) {
        this.numeroCasilla = numeroCasilla;
        this.coste = coste;
        this.tipo = tipo;
    }

    public Casilla(int numeroCasilla, int coste, TipoCasilla tipo, TituloPropiedad titulo) {
        this.numeroCasilla = numeroCasilla;
        this.coste = coste;
        this.tipo = tipo;
        this.asignarTituloPropiedad(titulo);
        
    }
    */
    
    public Casilla(int numero, int cost) {
        numeroCasilla = numero;
        coste = cost;
    }

    public int getCoste() {
        return coste;
    }
    
    public int getNumeroCasilla() {
        return numeroCasilla;
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
