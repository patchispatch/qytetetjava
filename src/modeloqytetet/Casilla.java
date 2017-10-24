package modeloqytetet;


public class Casilla {
    private int numeroCasilla;
    private int coste;
    private int numHoteles = 0;
    private int numCasas = 0;
    private TipoCasilla tipo;
    private TituloPropiedad titulo;

    Casilla(int numeroCasilla, int coste, TipoCasilla tipo) {
        this.numeroCasilla = numeroCasilla;
        this.coste = coste;
        this.tipo = tipo;
    }

    Casilla(int numeroCasilla, int coste, TipoCasilla tipo, TituloPropiedad titulo) {
        this.numeroCasilla = numeroCasilla;
        this.coste = coste;
        this.tipo = tipo;
        this.setTituloPropiedad(titulo);
    }

    
    public TipoCasilla getTipo() {
        return tipo;
    }

    public TituloPropiedad getTitulo() {
        return titulo;
    }
    
    TituloPropiedad asignarPropietario(Jugador jugador){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int calcularValorHipoteca(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int cancelarHipoteca(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int cobrarAlquiler(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int edificarCasa(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int edificarHotel(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean estaHipotecada(){
        throw new UnsupportedOperationException("Sin implementar");
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
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int hipotecar(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int precioTotalComprar(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean propietarioEncarcelado(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean sePuedeEdificarCasa(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean sePuedeEdificarHotel(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void setNumCasas(int numCasas) {
        this.numCasas = numCasas;
    }

    void setNumHoteles(int numHoteles) {
        this.numHoteles = numHoteles;
    }
    
    boolean soyEdificable(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean tengoPropietario(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int venderTitulo(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private void setTituloPropiedad(TituloPropiedad titulo) {
        this.titulo = titulo;
    }

    private void asignarTituloPropiedad(){
        
    }
    @Override
    public String toString() {
        String resultado = "Casilla{" + "numeroCasilla=" + numeroCasilla + ", coste=" + coste + ", tipo=" + tipo ;
    
        if(!(titulo == null)){
            resultado += "TituloCasilla=" + titulo + "numHotel=" + numHoteles + "numCasas=" + numCasas+ '}';
            
        }
        else
            resultado += '}';
        
        return resultado;
    }
    
    
}
