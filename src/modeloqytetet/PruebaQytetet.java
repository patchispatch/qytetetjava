package modeloqytetet;

//Bibliotecas:
import java.util.ArrayList;

public class PruebaQytetet {
/*   
    //Atributos de la clase:
    private static ArrayList<Sorpresa> mazo = new ArrayList();
    private static Tablero tablero = new Tablero();
    
    
    //Inicializar sorpresa:
    private static void inicializarSorpresa() {
        mazo.add(new Sorpresa("Te hemos pillado con chanclas y calcetines. "
                 + "Lo sentimos, ¡debes ir a la cárcel!",
                TipoSorpresa.IRACASILLA, tablero.getCarcel().getNumeroCasilla()));
        
        mazo.add(new Sorpresa("un fan anónimo ha pagado tu fianza. Sales de la "
                + "cárcel", TipoSorpresa.SALIRCARCEL,0));
    }
    
    //Devuelve un ArrayList con objetos Sorpresa:
    private static ArrayList<Sorpresa> valenMasCero()  {
        
        ArrayList<Sorpresa> mascero = new ArrayList();
        for(Sorpresa sorpresa : mazo) {
            if (sorpresa.getValor() > 0)
                mascero.add(sorpresa);
        }
        
        return mascero;
    }
    
    private static ArrayList<Sorpresa> irCasilla() {
        ArrayList<Sorpresa> ircasilla = new ArrayList();
        
        for(Sorpresa sorpresa : mazo) {
            if (sorpresa.getTipo() == TipoSorpresa.IRACASILLA)
                ircasilla.add(sorpresa);
        }
        
        return ircasilla;
    }
    
    private static ArrayList<Sorpresa> mostrarCartaTipo(TipoSorpresa t) {
        ArrayList<Sorpresa> mostrar = new ArrayList();
        for(Sorpresa sorpresa : mazo) {
            if(sorpresa.getTipo() == t)
                mostrar.add(sorpresa);
        }
        
        return mostrar;
    }
    */
    
    //Main:
    public static void main(String[] args) {
        
        /*
        //Inicializamos el mazo y lo mostramos:
        inicializarSorpresa();
        
        //Mostramos el mazo con toString():
        for (Sorpresa sorpresa : mazo) {
            System.out.println("Sorpresa: " + sorpresa.toString());
        }
        
        //Mostramos todas las sorpresas con valor mayor que cero:
        System.out.println("Mayores que cero: " + valenMasCero().toString());

        //Mostramos las sorpresas de tipo IRACASILLA:
        System.out.println("Tipo IRACASILLA: " + irCasilla().toString());
        
        //Mostramos las sorpesas del tipo especificado:
        System.out.println("Tipo" + mostrarCartaTipo(TipoSorpresa.IRACASILLA).toString());
        
        */
        
        
        Qytetet qytetet = Qytetet.getInstance();
        
        //Jugadores (provisional):
        ArrayList<String> nombres = new ArrayList();
        
        nombres.add("MJ");
        nombres.add("Pepe");
        nombres.add("Laura");
        nombres.add("Juan");
        
        //Inicializamos el juego:
        qytetet.inicializarJuego(nombres);
        
        
        //Mostramos el tablero
        System.out.println("Tablero: \n");
        qytetet.getTablero();
        
        //Tiramos el dado y mostramos el valor:
        System.out.println("Dado: \n");
        System.out.println(qytetet.getDado().tirar());
        
        //Mostramos qytetet:
        System.out.println(qytetet.toString());
        
    }
}