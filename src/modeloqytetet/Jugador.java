package modeloqytetet;

import java.util.ArrayList;

class Jugador {
    private boolean encarcelado=false;
    private String nombre;
    private int saldo=7500;
    
    private Sorpresa cartaLibertad = null;
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
        boolean resultado;
        
        if(propiedades.size() > 0)
            resultado = true;
        
        else
            resultado = false;
        
        return resultado;
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
        saldo += cantidad;
    }

    int obtenerCapital(){
        int capital = 0;
        ArrayList<Casilla> casillas = new ArrayList();
        
        for(TituloPropiedad t : propiedades) {
            casillas.add(t.getCasilla());
        }
        
        for(Casilla c : casillas) {
            int v_propiedad = 0;
            
            v_propiedad += c.getCoste() + ((c.getNumCasas() + c.getNumHoteles())
                        * c.getPrecioEdificar());
            
            capital += v_propiedad;
        }
        
        return capital;
    }
    
    ArrayList<TituloPropiedad> obtenerPropiedadesHipotecadas(boolean hipotecada){
        
        ArrayList<TituloPropiedad> resultado = new ArrayList();
        
        for(TituloPropiedad t : propiedades) {
            if(t.getHipotecada() == hipotecada) {
                resultado.add(t);
            }
        }
        
        return resultado;
    }
    
    void pagarCobrarPorCasaYHotel(int cantidad){
        throw new UnsupportedOperationException("Sin implementar");
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
        boolean resultado = false;
        
        if(this.esDeMiPropiedad(casilla)) {
            if(!casilla.estaHipotecada())
                resultado = true;
        }
        
        return resultado;
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
        
        boolean resultado = false;
        
        if(cartaLibertad != null)
            resultado = true;
        
        return resultado;
    }
    
    void venderPropiedad(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private int cuantasCasasHotelesTengo(){
        return propiedades.size();
    }
    
    private void eliminarDeMisPropiedades(Casilla casilla){
        for (TituloPropiedad t : propiedades) {
            if(t == casilla.getTitulo())
                propiedades.remove(t);
        }
    }
    
    private boolean esDeMiPropiedad(Casilla casilla){
        boolean resultado = false;
        
        for(TituloPropiedad t : propiedades){
            if(t == casilla.getTitulo())
                resultado = true;
        }
        
        return resultado;
    }
    
    private boolean tengoSaldo(int cantidad){
        boolean resultado;
        
        if(saldo >= cantidad)
            resultado = true;
        else
            resultado = false;
        
        return resultado;
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
