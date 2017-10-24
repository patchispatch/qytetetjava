package modeloqytetet;

import java.util.ArrayList;

class Jugador {
    private boolean encarcelado=false;
    private String nombre;
    private int saldo=7500;
    
    private Sorpresa cartaLibertad=null;
    private Casilla casillaActual=null;
    private ArrayList<TituloPropiedad> propiedades = new ArrayList();
    
    //Constructor
    public Jugador(String nombre){
        this.nombre = nombre;
    }

    public Casilla getCasillaActual() {
        return casillaActual;
    }

    public boolean getEncarcelado() {
        return encarcelado;
    }
    
    public boolean tengoPropiedades(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean actualizarPosicion(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean comprarTitulo(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    Sorpresa devolverCartaLibertad(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void irACarcel(Casilla casilla){
        
    }
    
    void modificarSaldo (int cantidad){
        
    }

    int obtenerCapital(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    TituloPropiedad obtenerPropiedadesHipotecadas(boolean hipotecada){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void pagarCobrarPorCasaYHotel(int cantidad){
        
    }
    
    boolean pagarLibertad(int cantidad){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean puedoEdificarCasa(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean puedoEdificarHotel(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean puedoPagarHipoteca(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean puedoVenderPropiedad(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }

    void setCartaLibertad(Sorpresa cartaLibertad) {
        this.cartaLibertad = cartaLibertad;
    }

    void setCasillaActual(Casilla casillaActual) {
        this.casillaActual = casillaActual;
    }

    void setEncarcelado(boolean encarcelado) {
        this.encarcelado = encarcelado;
    }
    
    boolean tengoCartaLibertad(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void venderPropiedad(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private int cuantasCasasHotelesTengo(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private void eliminarDeMisPropiedades(Casilla casilla){
        
    }
    
    private boolean esDeMiPropiedad(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private boolean tengoSaldo(int cantidad){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    @Override
    public String toString() {
        String resultado = "Jugador{" + "encarcelado=" + encarcelado + ", nombre=" 
                + nombre + ", saldo=" + saldo + ", cartaLibertad=" 
                + cartaLibertad + ", casillaActual=" + casillaActual 
                + ", propiedades=";
                for(TituloPropiedad prop:propiedades){
                    resultado += prop.toString() + "\n"; 
                }
                 resultado += '}';
        return resultado;
    }
    
    
    
}
