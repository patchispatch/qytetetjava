
package interfaztextualqytetet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import modeloqytetet.*;


public class ControladorQytetet {

    private static final Scanner in = new Scanner (System.in);
    public Qytetet juego;
    public Jugador jugador;
    public Casilla casilla;
    public VistaTextualQytetet vista;

    public ControladorQytetet() {
        this.vista = new VistaTextualQytetet();
    }
    
    public void inicializacionJuego(){
        juego = Qytetet.getInstance();
        ArrayList<String> nombres = vista.obtenerNombreJugadores();
        juego.inicializarJuego(nombres);
        jugador = juego.getJugadorActual();
        casilla = jugador.getCasillaActual();
        vista.mostrar(juego.toString());
        System.out.println("==== Jugador que comienza la partida: ");
        vista.mostrar(jugador.toString());
    }
    
    public void desarrolloJuego(){
        String lectura;
        do{
            System.out.println("Pulsa ENTER para seguir");
            lectura = in.nextLine();  //lectura de teclado
            if(jugador.getEncarcelado()){
                vista.mostrar(jugador.toString());
                int metodo = vista.menuSalirCarcel();
                if (metodo == 0)
                juego.intentarSalirCarcel(MetodoSalirCarcel.TIRANDODADO);
                else
                    juego.intentarSalirCarcel(MetodoSalirCarcel.PAGANDOLIBERTAD);
                
            }
            if(!jugador.getEncarcelado()){
                System.out.println("Jugando.");
                boolean noTienePropietario = juego.jugar();
                casilla = jugador.getCasillaActual();
                
                vista.mostrar(jugador.toString());
                System.out.println("Ha jugado. \n\n");
                
                if(!jugador.bancarrota()){
                    System.out.println("No está en bancarrota. \n");
                    
                    if(!jugador.getEncarcelado()){
                        System.out.println("No está encarcelado. \n");
                        System.out.println(casilla.getTipo());
                        if(casilla.getTipo() == TipoCasilla.CALLE){
                            System.out.println("Es una calle. \n");
                            boolean opcion = vista.elegirQuieroComprar();
                            
                            if(opcion){
                                boolean comprado = juego.comprarTituloPropiedad();
                                if (comprado)
                                    System.out.println("Comprado.\n");
                                else
                                    System.out.println("No se ha podido comprar la propiedad.\n");
                            }
                        }
                        else if(casilla.getTipo() == TipoCasilla.SORPRESA){
                            System.out.println("Es una sorpresa. \n");
                            noTienePropietario = juego.aplicarSorpresa();
                            vista.mostrar(jugador.toString());
                            
                            if(!jugador.getEncarcelado() && !jugador.bancarrota()
                                    && casilla.getTipo() == TipoCasilla.CALLE &&
                                    noTienePropietario){
                                boolean opcion = vista.elegirQuieroComprar();
                                if(opcion){
                                    juego.comprarTituloPropiedad();
                                    vista.mostrar(jugador.toString());
                                }
                            }
                        }
                        
                        if(!jugador.getEncarcelado() && !jugador.bancarrota() && 
                                jugador.tengoPropiedades()){
                            int opcion;
                            do{
                                opcion = vista.menuGestionInmobiliaria();
                                
                                if(opcion!=0){
                                    vista.mostrar(jugador.toString());
                                    System.out.println("Elige la propiedad: \n");
                                    ArrayList<TituloPropiedad> propiedades = jugador.obtenerPropiedades();
                                    int secCasilla = vista.menuElegirPropiedad(jugador.getPropiedades());
                                    Casilla casillaElegida = propiedades.get(secCasilla).getCasilla();
                                    boolean res;
                                    switch(opcion){
                                        case 1:
                                               res = juego.edificarCasa(casillaElegida);
                                               if(res){
                                                   System.out.println("Se ha edificado una casa. \n");
                                               }
                                               else{
                                                   System.out.println("No se ha podido edificar la casa. \n");
                                               }
                                               break;
                                        case 2:
                                               res = juego.edificarHotel(casillaElegida);
                                               if(res){
                                                   System.out.println("Se ha edificado un hotel. \n");
                                               }
                                               else{
                                                   System.out.println("No se ha podido edificar el hotel. \n");
                                               }
                                               break;
                                        case 3:
                                               res = juego.venderPropiedad(casillaElegida);
                                               if (res){
                                                   System.out.println("Se ha vendido la propiedad correctamente. \n");
                                               }
                                               else{
                                                   System.out.println("No se ha podido vender la propiedad. \n");
                                               }
                                               break;
                                        case 4:
                                               res = juego.hipotecarPropiedad(casillaElegida);
                                               if (res){
                                                   System.out.println("Se ha hipotecado la propiedad con éxito. \n");
                                               }
                                               else{
                                                   System.out.println("No se ha podido hipotecar la propiedad. \n");
                                               }
                                               break;
                                        case 5:
                                               res = juego.cancelarHipoteca(casillaElegida);
                                                if (res){
                                                    System.out.println("Se ha cancelado la hipoteca con éxito. \n");
                                                }
                                                else{
                                                    System.out.println("No se ha podido cancelar la hipoteca. \n");
                                                }
                                    }
                                }
                            } while (opcion !=0);
                        }
                    }
                }
            }
            
            if(!jugador.bancarrota()){
                System.out.println("Cambiando de jugador:");
                juego.siguienteJugador();
                jugador = juego.getJugadorActual();
            }
            else{
                System.out.println("Fin de la partida. \n");
                HashMap<String, Integer> lista_ranking = juego.obtenerRanking();
                System.out.println(lista_ranking);
            }
        }while(!jugador.bancarrota());
    }
    public Casilla elegirPropiedad(ArrayList<Casilla> propiedades){ 
// este metodo toma una lista de propiedades y genera una lista de strings, con el numero y nombre de las propiedades
// luego llama a la vista para que el usuario pueda elegir.
        vista.mostrar("\tCasilla\tTitulo");
        int seleccion;
        ArrayList<String> listaPropiedades= new ArrayList();
        for ( Casilla casilla: propiedades) {
                listaPropiedades.add( "\t"+casilla.getNumeroCasilla()+"\t"+casilla.getTitulo().getNombre()); 
        }
        seleccion=vista.menuElegirPropiedad(listaPropiedades);  
        return propiedades.get(seleccion);
    }
    public static void main(String[] args) {
        ControladorQytetet controlador = new ControladorQytetet();
        controlador.inicializacionJuego();
        controlador.desarrolloJuego();
    }

}
