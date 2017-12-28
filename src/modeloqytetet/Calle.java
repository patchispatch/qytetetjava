package modeloqytetet;

public class Calle extends Casilla {
    
    private TituloPropiedad titulo;
    private int numCasas = 0;
    private int numHoteles = 0;
    
    public Calle(int numeroCasilla, int coste, TituloPropiedad title) {
        super(numeroCasilla, coste);
        titulo = title;
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
        int valor_hipoteca = calcularValorHipoteca();
        double porcentaje = valor_hipoteca * 0.1;
        valor_hipoteca = (int)(valor_hipoteca + porcentaje);
        return valor_hipoteca;
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
    
    public int getNumeroCasilla() {
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
    
    boolean sePuedeEdificarCasa(int factorEspeculador){
        if(numCasas < 4 * factorEspeculador)
            return true;
        else
            return false;
    }
    
    boolean sePuedeEdificarHotel(int factorEspeculador){
        if( numCasas == 4 * factorEspeculador  && numHoteles < 4 * factorEspeculador){
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
        int precioCompra = precioTotalComprar();
        int precioVenta = (int)(precioCompra+ titulo.getFactorRevalorizacion()*precioTotalComprar());
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
    
    @Override
    public String toString() {
        String resultado = super.toString() +
                    "\nNúmero de casas: " + numCasas + 
                    "\nNúmero de hoteles: " + numHoteles +
                    "\nTítulo de propiedad: " + titulo.toString();
        
        return resultado;
    }
    
    @Override 
    boolean soyEdificable() {
        return true;
    }
}
