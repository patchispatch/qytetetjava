package modeloqytetet;

import java.util.List;
//import java.util.logging.Logger;
import java.util.ArrayList;

public class Qytetet {
    //Las constantes en java son "final"
    private static final Qytetet instance = new Qytetet();
    
    //El constructor privado asegura que no se puede instanciar desde otras clases
    private Qytetet(){}     
    
    public static Qytetet getInstance(){
        return instance;
    }
    
    public static final int MAX_JUGADORES = 4;
    static final int MAX_CARTAS = 10;
    static final int MAX_CASILLAS = 20;
    static final int PRECIO_LIBERTAD = 200;
    static final int SALDO_SALIDA = 1000;
    
    //Atributos de referencia:
    private Sorpresa cartaActual=null;
    private Jugador jugadorActual = null;
    private ArrayList<Jugador> jugadores;
    private Tablero tablero;
    private Dado dado = Dado.getInstance();
    private ArrayList<Sorpresa> mazo;
    
    
    public boolean aplicarSorpresa(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean cancelarHipoteca(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean comprarTituloPropiedad(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean edificarCasa(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean edificarHotel(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public Sorpresa getCartaActual() {
        return cartaActual;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Dado getDado() {
        return dado;
    }

    public ArrayList<Sorpresa> getMazo() {
        return mazo;
    }

    
    public Jugador getJugadorActual() {
        return jugadorActual;
    }
    
    public boolean hipotecarPropiedad(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public void inicializarJuego(String nombres){
        
    }
    
    public boolean intentarSalirCarcel(MetodoSalirCarcel metodo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean jugar(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public List obtenerRanking(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public Casilla propiedadesHipotecadasJugador(boolean hipotecadas){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public void setJugador(int i){
        jugadorActual = jugadores.get(i);
    }
    
    public Jugador siguienteJugador() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean venderPropiedad(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private void encarcelarJugador(){
        
    }
    //Implementar
    private void inicializarCartasSorpresa(){
        
        mazo = new ArrayList();
        
        mazo.add(new Sorpresa("Te hemos pillado con chanclas y calcetines. "
                 + "Lo sentimos, ¡debes ir a la cárcel!",
                TipoSorpresa.IRACASILLA, 9));
        mazo.add(new Sorpresa("un fan anónimo ha pagado tu fianza. Sales de la "
                 + "cárcel", TipoSorpresa.SALIRCARCEL, 0));
 
    }
    
    private void inicializarJugadores(ArrayList<String> nombres){
        
        jugadores = new ArrayList();
        int i = 0;
        
        while (i < nombres.size()) {
            Jugador jugador = new Jugador (nombres.get(i));
            
            jugador.setCasillaActual(tablero.obtenerCasillaNumero(0));
            
            jugadores.add(jugador);
            
            i++;
        }
    }
    
    public void inicializarJuego(ArrayList<String> nombres) {
        inicializarTablero();
        inicializarCartasSorpresa();
        inicializarJugadores(nombres);
    }
    
    private void inicializarTablero(){
        tablero = new Tablero();
    }
    
    private void salidaJugadores(){
        
    }
    
    //ToString:
    @Override
    public String toString(){
        
        String cadena;
        
        cadena = "Tablero: " + tablero.toString() + "\n"  
                + "Jugadores: ";
                            
        for(Jugador j : jugadores) {
            cadena = cadena + j.toString() + "\n";
        }
        
        if(jugadorActual != null && cartaActual != null) {
            cadena = cadena + "Jugador actual: " + jugadorActual.toString() +
                     "\n" + "Carta actual: " + cartaActual.toString() + "\n";
        }
        cadena = cadena + "Mazo: ";
        
        for(Sorpresa s : mazo) {
            
            cadena = cadena + s.toString() + "\n";
        }
        
        return (cadena);
    }                      
}
    
    

