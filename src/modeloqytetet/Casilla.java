package modeloqytetet;


public class Casilla {
    private int numeroCasilla;
    private int coste;
    private int numHoteles = 0;
    private int numCasas = 0;
    private TipoCasilla tipo;
    private TituloPropiedad titulo;

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
    

    
    public TipoCasilla getTipo() {
        return tipo;
    }

    public TituloPropiedad getTitulo() {
        return titulo;
    }
    
    TituloPropiedad asignarPropietario(Jugador jugador){
        titulo.setPropietario(jugador);
        return (titulo);
    }
    
    int calcularValorHipoteca(){
        int cantidadRecibida = titulo.getHipotecaBase() + 
                (int)(numCasas*0.5*titulo.getHipotecaBase() + numHoteles * titulo.getHipotecaBase());
        return cantidadRecibida;
    }
    
    int cancelarHipoteca(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int cobrarAlquiler(){
        int alquilerBase = titulo.getAlquilerBase();
        int costeAlquiler = alquilerBase + (int)(numCasas * 0.5 + numHoteles * 2);
        titulo.propietario.modificarSaldo(costeAlquiler);
        
        return costeAlquiler;
    }
    
    int edificarCasa(){
        setNumCasas(numCasas+1);
        int costeEdificarCasa = titulo.getPrecioEdificar();
        return costeEdificarCasa;
    }
    
    int edificarHotel(){
        setNumHoteles(numHoteles+1);
        int costeEdificarHotel = titulo.getPrecioEdificar();
        return costeEdificarHotel;
    }
    
    boolean estaHipotecada(){
        return titulo.getHipotecada();
    }
    
    int getCoste() {
        return coste;
    }
    
    int getCosteHipoteca(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int getNumeroCasilla() {
        return numeroCasilla;
    }
  
    int getNumCasas() {
        return numCasas;
    }
    
    int getNumHoteles() {
        return numHoteles;
    }
    
    int getPrecioEdificar(){
        return titulo.getPrecioEdificar();
    }
    
    int hipotecar(){
        int cantidadRecibida = calcularValorHipoteca();
        titulo.setHipotecada(true);
        return cantidadRecibida;
        
    }
    
    int precioTotalComprar(){
        int precioCompra = coste + (numCasas + numHoteles) * titulo.getPrecioEdificar();
        return precioCompra;
    }
    
    boolean propietarioEncarcelado(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean sePuedeEdificarCasa(){
        if(numCasas < 4)
            return true;
        else
            return false;
    }
    
    boolean sePuedeEdificarHotel(){
        if( numCasas == 4  && numHoteles < 4){
            return true;
        }
        else 
            return false;
    }
    
    void setNumCasas(int numCasas) {
        this.numCasas = numCasas;
    }

    void setNumHoteles(int numHoteles) {
        this.numHoteles = numHoteles;
    }
    
    boolean tengoPropietario(){
        return titulo.tengoPropietario();
    }
    
    int venderTitulo(){
        int precioVenta = precioTotalComprar() + (int)titulo.getFactorRevloracizacion()*precioTotalComprar();
        titulo.setPropietario(null);
        setNumHoteles(0);
        setNumCasas(0);
        return precioVenta;
    }
    
    private void setTituloPropiedad(TituloPropiedad titulo) {
        this.titulo = titulo;
    }

    private void asignarTituloPropiedad(TituloPropiedad titulo){
        this.setTituloPropiedad(titulo);
        this.titulo.setCasilla(this);
    }
    
    boolean soyEdificable() {
        
        boolean edificable = false;
        
        if(tipo == TipoCasilla.CALLE)
            edificable = true;
                    
        return edificable;
    }
 
    
    @Override
    public String toString() {
        String resultado = "";
        
        if(titulo != null) {
            resultado = "Número de casilla: " + numeroCasilla + 
                        "\nTipo de casilla: " + tipo +
                        "\nCoste: " + coste +
                        "\nNúmero de casas: " + numCasas + 
                        "\nNúmero de hoteles: " + numHoteles +
                        "\nTítulo de propiedad: " + titulo.toString();
        }
        
        return resultado;
    }
    
    
}
