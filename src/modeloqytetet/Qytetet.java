package modeloqytetet;

import java.util.List;
//import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.HashMap;
import GUIQytetet.Dado;

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
    private ArrayList<Sorpresa> mazo;
    
    
    public boolean aplicarSorpresa(){
        boolean tienePropietario=false;
        if (cartaActual.getTipo() == TipoSorpresa.PAGARCOBRAR){
            jugadorActual.modificarSaldo(cartaActual.getValor());
        }
        else if (cartaActual.getTipo() == TipoSorpresa.IRACASILLA){
            int numeroCasilla = cartaActual.getValor();
           boolean esCarcel = tablero.esCasillaCarcel(numeroCasilla);
           if(esCarcel){
               encarcelarJugador();
           }
           else{
               Casilla nuevaCasilla = tablero.obtenerCasillaNumero(numeroCasilla);
               jugadorActual.actualizarPosicion(nuevaCasilla);
           }
        }
        else if (cartaActual.getTipo() == TipoSorpresa.PORCASAHOTEL){
            int cantidad = cartaActual.getValor();
            jugadorActual.pagarCobrarPorCasaYHotel(cantidad);
        }
        else if (cartaActual.getTipo() == TipoSorpresa.PORJUGADOR){
            for(Jugador jugador : jugadores){
                siguienteJugador();
                if(jugador != jugadorActual){
                    jugador.modificarSaldo(cartaActual.getValor());
                    jugadorActual.modificarSaldo(-cartaActual.getValor());
                }
                
            
            }
        }
        
        if(cartaActual.getTipo() == TipoSorpresa.SALIRCARCEL){
            jugadorActual.setCartaLibertad(cartaActual);
            mazo.add(cartaActual);
        }
        
        if(cartaActual.getTipo() == TipoSorpresa.CONVERTIRME) {
            jugadores.remove(jugadorActual);
            jugadorActual = jugadorActual.convertirme(cartaActual.getValor());
            jugadores.add(jugadorActual);
        }
        return tienePropietario;
    }
    
    public boolean cancelarHipoteca(Casilla casilla){
        boolean puedoDeshipotecar = false;
        
        if (((Calle)casilla).estaHipotecada()){
            if(jugadorActual.puedoPagarHipoteca((Calle)casilla)) {
                jugadorActual.modificarSaldo(-((Calle)casilla).cancelarHipoteca());
            }
            
            puedoDeshipotecar = true;
        }
        
        return puedoDeshipotecar;
    }
    
    public boolean comprarTituloPropiedad(){  
        return jugadorActual.comprarTitulo();
    }

    public static int getSALDO_SALIDA() {
        return SALDO_SALIDA;
    }
    
    public boolean edificarCasa(Casilla casilla){
        
        boolean puedoEdificar = false;
        
        if(casilla.soyEdificable()){
            
            boolean sePuedeEdificar = ((Calle)casilla).sePuedeEdificarCasa(jugadorActual.getFactorEspeculador());
            
            if(sePuedeEdificar){
                puedoEdificar = jugadorActual.puedoEdificarCasa((Calle)casilla);
                        
                if(puedoEdificar){
                    
                    int costeEdificarCasa = ((Calle)casilla).edificarCasa();
                    jugadorActual.modificarSaldo(-costeEdificarCasa);
                }
            }
            
        }
        
        return puedoEdificar;
    }
    
    public boolean edificarHotel(Casilla casilla){
        
        boolean puedoEdificar = false;
        
        if(casilla.soyEdificable()){
            
            boolean sePuedeEdificar = ((Calle)casilla).sePuedeEdificarHotel(jugadorActual.getFactorEspeculador());
            
            if(sePuedeEdificar){
                puedoEdificar = jugadorActual.puedoEdificarHotel((Calle)casilla);
                
                if(puedoEdificar){
                    int costeEdificarHotel = ((Calle)casilla).edificarHotel();
                    jugadorActual.modificarSaldo(-costeEdificarHotel);
                }
            }
            
        }
        
        return puedoEdificar;
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

    public ArrayList<Sorpresa> getMazo() {
        return mazo;
    }

    
    public Jugador getJugadorActual() {
        return jugadorActual;
    }
    
    public boolean hipotecarPropiedad(Casilla casilla){
        
        if(casilla.soyEdificable()){
            
            boolean sePuedeHipotecar = !((Calle)casilla).estaHipotecada();
            
            if(sePuedeHipotecar){
                boolean puedoHipotecar = jugadorActual.puedoHipotecar((Calle)casilla);
                
                if(puedoHipotecar){
                    int cantidadRecibida = ((Calle)casilla).hipotecar();
                    jugadorActual.modificarSaldo(cantidadRecibida);
                }
            }
            return true;
        }
       
        return false;
    }
    
    public boolean intentarSalirCarcel(MetodoSalirCarcel metodo){
        boolean libre = false;
       
       if (metodo == MetodoSalirCarcel.TIRANDODADO){
           Dado dado = GUIQytetet.Dado.getInstance();
           int valor = dado.nextNumber();
           if (valor > 5){
               libre = true;
           }
       }
       else if (metodo == MetodoSalirCarcel.PAGANDOLIBERTAD){
             boolean tengoSaldo = jugadorActual.pagarLibertad(-PRECIO_LIBERTAD);
             libre = true;
        
       }
       if(libre){
           jugadorActual.setEncarcelado(false);
       }
       return libre;
    }
    
    public boolean jugar(){
        
        Dado dado = GUIQytetet.Dado.getInstance();
        int valorDado = dado.nextNumber();
        Casilla casillaPosicion = jugadorActual.getCasillaActual();
        Casilla nuevaCasilla = tablero.obtenerNuevaCasilla(casillaPosicion, valorDado);
        boolean tienePropietario = jugadorActual.actualizarPosicion(nuevaCasilla);
    
        if(!nuevaCasilla.soyEdificable()){
            
            OtraCasilla casilla = (OtraCasilla) nuevaCasilla;
            
            if(casilla.getTipo()==TipoCasilla.JUEZ){
                encarcelarJugador();
            }
            
            else if(casilla.getTipo()==TipoCasilla.SORPRESA){
                cartaActual = mazo.get(0);
            }
        }
        return tienePropietario;
    }
    
    //Si hay dos jugadore scon el mismo nombre, se machacan.
    //Array de String "Jugador: capital".
    public ArrayList<String> obtenerRanking(){
        
        ArrayList<String> ranking = new ArrayList();
        
         String cadena = "";
        
        for (Jugador jugador: jugadores) {
            
            cadena += "Nombre del jugador: ";
            cadena += jugador.getNombre();
            cadena += ". Capital: ";
            cadena += String.valueOf(jugador.obtenerCapital());
            cadena += ".";
                 
            ranking.add(cadena);
        }
        
        return ranking;
    }
    
    public ArrayList<Casilla> propiedadesHipotecadasJugador(boolean hipotecadas){
        
        ArrayList<TituloPropiedad> titulos;
        ArrayList<Casilla> casillas = new ArrayList();
        
        titulos = jugadorActual.obtenerPropiedadesHipotecadas(hipotecadas);
        
        for(TituloPropiedad t : titulos) {
            casillas.add(t.getCasilla());
        }
        
        return casillas;
    }
    
    public void setJugador(int i){
        jugadorActual = jugadores.get(i);
    }
    
    public void siguienteJugador() {
        
        //Comprobamos la posición de jugadorActual en jugadores:
        int n_actual = 0;
        while (jugadores.get(n_actual) != jugadorActual) {
            ++n_actual;
        }
        
        //Ahora, actualizamos la posición con el nuevo jugadorActual;
        n_actual += 1;
        n_actual %= jugadores.size();
        
        //Actualizamos el nuevo jugadorActual:
        jugadorActual = jugadores.get(n_actual);
    }
    
    public boolean venderPropiedad(Casilla casilla){
       boolean puedoVender = false;
        if (casilla.soyEdificable()){
           puedoVender = jugadorActual.puedoVenderPropiedad(casilla);
           if(puedoVender){
               jugadorActual.venderPropiedad(casilla);
           }
        }
        return(puedoVender);
    }
    
    private void encarcelarJugador(){
        if(! jugadorActual.tengoCartaLibertad()){
            Casilla casilla = tablero.getCarcel();
            jugadorActual.irACarcel(casilla);
        }
        else{
            Sorpresa carta = jugadorActual.devolverCartaLibertad();
            mazo.add(carta);
        }
        
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
        
        
        //Convertirse en especulador:
        
        mazo.add(new Sorpresa("Te obsequiamos con el caramillo de plata del Eolio. "
                + "¡Ahora eres un especulador!", TipoSorpresa.CONVERTIRME, 3000));
        
        mazo.add(new Sorpresa("Un noble te escuchó tocar anoche, y le encantó tanto "
                + "que te ha ofrecido su mecenazgo. ¡Ahora eres un especulador!",
                TipoSorpresa.CONVERTIRME, 5000));
        
        
        //Barajamos las cartas
        Collections.shuffle(mazo);
    }
    
      private void inicializarJugadores(ArrayList<String> nombres){
        
        jugadores = new ArrayList();
        int i = 0;
        
        while (i < nombres.size()) {
            Jugador jugador = new Jugador(nombres.get(i));
            
            jugadores.add(jugador);
            
            i++;
        }
        
    }
    
    public void inicializarJuego(ArrayList<String> nombres) {
        
        this.inicializarJugadores(nombres);
        this.inicializarTablero();
        this.inicializarCartasSorpresa();
        this.salidaJugadores();
        
    }
    
    private void inicializarTablero(){
        tablero = new Tablero();
    }
    
    private void salidaJugadores(){
        
        for (Jugador j : jugadores) {
            j.setCasillaActual(tablero.obtenerCasillaNumero(0));
        }
        
        int aleatorio;
        aleatorio = (int) (Math.random()*jugadores.size());
        
        jugadorActual = jugadores.get(aleatorio);
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
    
    

