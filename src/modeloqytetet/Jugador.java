package modeloqytetet;

import java.util.ArrayList;

public class Jugador {
    protected boolean encarcelado=false;
    protected String nombre;
    protected int saldo=7500;

    protected Sorpresa cartaLibertad = null;
    protected Casilla casillaActual=null;
    protected ArrayList<TituloPropiedad> propiedades = new ArrayList();
    
    final int factorEspeculador;
    
    //Constructor
    protected Jugador(String name){
        nombre = name;
        factorEspeculador = 1;
    }
    
    protected Jugador(Jugador jugador) {
        encarcelado = jugador.encarcelado;
        nombre = jugador.nombre;
        saldo = jugador.saldo;
        cartaLibertad = jugador.cartaLibertad;
        casillaActual = jugador.casillaActual;
        propiedades = jugador.propiedades;
        factorEspeculador = jugador.factorEspeculador;
    }
    
    public String getNombre() {
        return nombre;
    }

    public ArrayList<String> getPropiedades() {
        ArrayList<String> propied = new ArrayList();
        for (TituloPropiedad prop: propiedades){
            propied.add(prop.toString());
        }
        return propied;
    }
    
    public ArrayList<TituloPropiedad> obtenerPropiedades() {
        return propiedades;
    }
    
    int getFactorEspeculador() {
        return factorEspeculador;
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
    
    protected boolean actualizarPosicion(Casilla casilla){
        if (casilla.getNumeroCasilla()< casillaActual.getNumeroCasilla()){
            modificarSaldo(Qytetet.getSALDO_SALIDA());
        }
        boolean tienePropietario = false;
        setCasillaActual(casilla);
        if (casilla.soyEdificable()){
            if (casilla.tengoPropietario()){
                tienePropietario =  true;
                if(!encarcelado){
                    int costeAlquiler = casilla.cobrarAlquiler();
                    modificarSaldo(-costeAlquiler);
                }
            
            }
        }
        else if (casilla.getTipo() == TipoCasilla.IMPUESTO){
                int coste = casilla.getCoste();
                pagarImpuestos(coste);
        }
                    
        return tienePropietario;        
    }
    
    boolean comprarTitulo(){
 
        boolean puedoComprar = false;
        if(casillaActual.soyEdificable() && !casillaActual.tengoPropietario()
                && (casillaActual.getCoste() <= saldo)){
            int costeCompra = casillaActual.getCoste();
            TituloPropiedad titulo = casillaActual.asignarPropietario(this);
            propiedades.add(titulo);
            modificarSaldo(-costeCompra);
            puedoComprar=true;
        }
        return puedoComprar;
    }
    
    Sorpresa devolverCartaLibertad(){
        Sorpresa carta = cartaLibertad;
        cartaLibertad = null;
        return carta;
    }
    
    void irACarcel(Casilla casilla){
        setCasillaActual(casilla);
        setEncarcelado(true);        
    }
    
    void modificarSaldo (int cantidad){
        saldo += cantidad;
    }

    int obtenerCapital(){
        int capital = saldo;
        
        for(TituloPropiedad t : propiedades) {
            int v_prop = 0;
            
            v_prop += t.getCasilla().getCoste() + (this.cuantasCasasHotelesTengo()
                    * t.getPrecioEdificar());
            
            if(t.getHipotecada())
                v_prop -= t.getHipotecaBase();
            
            capital += v_prop;
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
    
    protected void pagarImpuestos(int cantidad) {
        modificarSaldo(-cantidad);
    }
    
    void pagarCobrarPorCasaYHotel(int cantidad){
        int numeroTotal = cuantasCasasHotelesTengo();
        modificarSaldo(numeroTotal*cantidad);
    }
    
    boolean pagarLibertad(int cantidad){
        boolean puedoPagar = false;
        if (tengoSaldo(cantidad)){
            modificarSaldo(cantidad);
            puedoPagar = true;
        }
        return puedoPagar;
    }
    
    boolean puedoEdificarCasa(Casilla casilla){
        boolean esMia = esDeMiPropiedad(casilla);
        if(esMia){
            int costeEdificarCasa = casilla.getPrecioEdificar();
            boolean tengoSaldo = tengoSaldo(costeEdificarCasa);
            return tengoSaldo;
        }
        return esMia;
    }
    
    boolean puedoEdificarHotel(Casilla casilla){
        boolean esMia = esDeMiPropiedad(casilla);
        if(esMia){
            int costeEdificarHotel = casilla.getPrecioEdificar();
            boolean tengoSaldo = tengoSaldo(costeEdificarHotel);
            return tengoSaldo;
        }
        return esMia;
    }
    boolean puedoHipotecar(Casilla casilla){
        boolean esMia = esDeMiPropiedad(casilla);
        return esMia;
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
        int precioVenta = casilla.venderTitulo();
        modificarSaldo(precioVenta);
        eliminarDeMisPropiedades(casilla);
    }
    
    private int cuantasCasasHotelesTengo(){
        int prop = 0;
        
        for(TituloPropiedad t : propiedades) {
            prop += t.getCasilla().getNumCasas() + t.getCasilla().getNumHoteles();
        }
        
        return prop;
    }
    
    private void eliminarDeMisPropiedades(Casilla casilla){
        ArrayList <TituloPropiedad> titulo = new ArrayList();
        
        for(int i = 0; i < propiedades.size(); i++)
            if(propiedades.get(i).getCasilla() != casilla)
                titulo.add(propiedades.get(i));
        propiedades.clear();
        for(int i = 0; i < titulo.size(); i++)
            propiedades.add(titulo.get(i));
            
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
        
        //Cambiar "Jugador" por this.getClass().getSimpleName();
        String resultado = "Jugador{" + " nombre=" + nombre + ", encarcelado=" 
                + encarcelado +", saldo=" + saldo + ", cartaLibertad=" 
                + cartaLibertad + ", casillaActual=" + casillaActual 
                + ", propiedades=";
                for(TituloPropiedad prop:propiedades){
                    resultado += prop.toString() + "\n"; 
                }
                 resultado += '}';
        return resultado;
    }
    
    public boolean bancarrota(){
        if (saldo <= 0)
            return true;
        else
            return false;
    }
    
    protected Especulador convertirme(int fianza) {
        Especulador converso = new Especulador(this, fianza);
        
        return converso;
    }
    
}
