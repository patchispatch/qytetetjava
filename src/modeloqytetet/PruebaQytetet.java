/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

//Bibliotecas:
import java.util.ArrayList;

public class PruebaQytetet {
    
    //Atributos de la clase:
    private static ArrayList<Sorpresa> mazo = new ArrayList();
    
    //Inicializar sorpresa:
    private static void inicializarSorpresa() {
        mazo.add(new Sorpresa("Te hemos pillado con chanclas y calcetines. "
                + "Lo sentimos, ¡debes ir a la cárcel!", 
                TipoSorpresa.IRACASILLA, 9));
                
        mazo.add(new Sorpresa("un fan anónimo ha pagado tu fianza. Sales de la "
                + "cárcel", TipoSorpresa.SALIRCARCEL, 0));
    }
    
    //Main:
    public static void main(String[] args) {
        //Inicializamos el mazo y lo mostramos:
        inicializarSorpresa();
        
        //Mostramos el mazo con toString():
        for (Sorpresa sorpresa : mazo) {
            System.out.println("Sorpresa: " + sorpresa.toString());
        }
        
    }
    
}
