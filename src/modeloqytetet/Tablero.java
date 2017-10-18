/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

import java.util.ArrayList;

/**
 *
 * @author veronica
 */
public class Tablero {
    private ArrayList<Casilla> casillas = new ArrayList();
    private Casilla carcel;

    public Tablero() {
        Inicializar();
    }

    boolean esCasillaCarcel(int numeroCasilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    Casilla getCarcel() {
        return carcel;
    }
    
    Casilla obtenerCasillaNumero (int numeroCasilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    Casilla obtenerNuevaCasilla (Casilla casilla, int desplazamiento){
        throw new UnsupportedOperationException("Sin implementar");
    }

    
    // primera salida, segnda calle, tercera sorpresa, cuarta calle, quinta carcel
    private void Inicializar(){
        casillas.add(new Casilla(0,0,TipoCasilla.SALIDA));
        casillas.add(new Casilla(1,500,TipoCasilla.CALLE,new TituloPropiedad("AA",1, (float) 0.1,2,3)));
        casillas.add(new Casilla(5,0,TipoCasilla.SORPRESA));
        casillas.add(new Casilla(11,1000,TipoCasilla.CALLE,new TituloPropiedad("BB",1, (float) 0.2,2,3)));
        casillas.add(new Casilla(4,0,TipoCasilla.CARCEL));
        carcel = casillas.get(4);
          
    }
    
    @Override
    public String toString() {
       String resultado = "";
       for(Casilla casi:casillas){
          resultado += casi.toString() + "\n"; 
       }
       return resultado;
    }
}
