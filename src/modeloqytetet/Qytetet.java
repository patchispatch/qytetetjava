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
    
    private void inicializarCartasSorpresa(){
        
        mazo = new ArrayList();
        
        //Pagar-cobrar:
        
        //Pagar:
        mazo.add(new Sorpresa("Recuerdas que tienes una deuda pendiente con "
                + "Devi. Pierdes 500 dineros.", TipoSorpresa.PAGARCOBRAR,-500));
        
        //Cobrar:
        mazo.add(new Sorpresa("Convences a los profesores de la Unversidad "
                + "para matricularte por... ¡-500 dineros! Los guardas "
                + "en tu bolsa.", TipoSorpresa.PAGARCOBRAR,500));
        
        
        //Ir a casilla:
        
        //Parking:
        mazo.add(new Sorpresa("Te sientes cansado y te apetece tomar algo, "
                + "así que te diriges a la posada Roca de Guía", 
                TipoSorpresa.IRACASILLA,10));
        
        //Casilla aleatoria:
        mazo.add(new Sorpresa("Llamas al viento sin querer y sales despedido. "
                + "¡Caes en una casilla aleatoria!", 
                TipoSorpresa.IRACASILLA, 0));
        
        //Cárcel:
        mazo.add(new Sorpresa("Has quebrantado la Ley del Hierro. "
                + "Debes ir a la cárcel.", TipoSorpresa.IRACASILLA, 
                tablero.getCarcel().getNumeroCasilla()));
        
        
        //Pagar-cobrar por casa y hotel:
        
        //Pagar:
        mazo.add(new Sorpresa("Ambrose ha mandado quemar tus propiedades. "
                + "La reparación asciende a 100 dineros por cada una.", 
                TipoSorpresa.PORCASAHOTEL, -100));
        
        //Cobrar:
        mazo.add(new Sorpresa("Parece que el negocio de las posadas te va "
                + "bien. ¡Ganas 100 dineros por cada una de tus propiedades!", 
                TipoSorpresa.PORCASAHOTEL, 100));
        
        
        //Pagar-cobrar por cada jugador:
        
        //Pagar:
        mazo.add(new Sorpresa("Pagar 100 dineros a cada jugador es del "
                + "Lethani.", TipoSorpresa.PORJUGADOR, -100));
        
        //Cobrar:
        mazo.add(new Sorpresa("Convences al resto de jugadores de que eres un "
                + "noble y, para tu sorpresa, ¡cada uno te da 100 dineros!", 
                TipoSorpresa.PORJUGADOR, 100));
        
        
        
        //Salir de la cárcel:
        
        mazo.add(new Sorpresa("Aburrido en tu celda, decides ponerte a cantar. "
                + "A los guardias les ha gustado, ¡y te dejan salir!",
                TipoSorpresa.SALIRCARCEL, 0));
        
        
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
    
    

