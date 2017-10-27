package modeloqytetet;

import java.util.ArrayList;

public class Tablero {
    
    //Atributos:
    private int MAX_CASILLAS;
    private ArrayList<Casilla> casillas;
    private Casilla carcel;

    //Constructor:
    public Tablero() {
        Inicializar();
        MAX_CASILLAS = 20;
    }

    boolean esCasillaCarcel(int numeroCasilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    Casilla getCarcel() {
        return carcel;
    }
    
    Casilla obtenerCasillaNumero (int numeroCasilla){
        boolean encontrado = false;
        Casilla devolver = null;
        
        while (!encontrado) {
            for (Casilla c : casillas) {
                if(numeroCasilla == c.getNumeroCasilla()) {
                    devolver = c;
                    encontrado = true;
                }
            }
        }
        
        return devolver;
    }
    
    
    Casilla obtenerNuevaCasilla (Casilla casilla, int desplazamiento){
        throw new UnsupportedOperationException("Sin implementar");
    }

    
    //Casillas del tablero:
    private void Inicializar(){
        
        casillas = new ArrayList();
        
        casillas.add(new Casilla(0,0,TipoCasilla.SALIDA));
        casillas.add(new Casilla(1,500,TipoCasilla.CALLE,new TituloPropiedad("Troupe de los Edena Ruh",1, (float) 0.65,2,3, null)));
        casillas.add(new Casilla(2,200,TipoCasilla.CALLE,new TituloPropiedad("Tarbean",1, (float) 0.75,2,3, null)));
        casillas.add(new Casilla(3,0,TipoCasilla.SORPRESA));
        casillas.add(new Casilla(4,350, TipoCasilla.CALLE,new TituloPropiedad("El Eolio",1, (float) 0.7,2,3, null)));
        casillas.add(new Casilla(5,0,TipoCasilla.CARCEL));
        casillas.add(new Casilla(6,400, TipoCasilla.CALLE,new TituloPropiedad("Anker's",1,(float) 0.2,2,3, null)));
        casillas.add(new Casilla(7,425,TipoCasilla.CALLE,new TituloPropiedad("El Archivo",1, (float) 0.2,2,3, null)));
        casillas.add(new Casilla(8,0,TipoCasilla.IMPUESTO));
        casillas.add(new Casilla(9,300, TipoCasilla.CALLE,new TituloPropiedad("La Clínica",1, (float) 0.2,2,3, null)));
        casillas.add(new Casilla(10,0,TipoCasilla.PARKING));
        casillas.add(new Casilla(11,650,TipoCasilla.CALLE,new TituloPropiedad("La Factoría",1, (float) 0.2,2,3, null)));
        casillas.add(new Casilla(12,540, TipoCasilla.CALLE,new TituloPropiedad("La Subrealidad",1, (float) 0.2,2,3, null)));
        casillas.add(new Casilla(13,0, TipoCasilla.SORPRESA));
        casillas.add(new Casilla(14,700, TipoCasilla.CALLE,new TituloPropiedad("Ademre",1, (float) 0.2,2,3, null)));
        casillas.add(new Casilla(15,0,TipoCasilla.JUEZ));
        casillas.add(new Casilla(16,250, TipoCasilla.CALLE,new TituloPropiedad("Modeg",1, (float) 0.2,2,3,null)));
        casillas.add(new Casilla(17,725, TipoCasilla.CALLE, new TituloPropiedad("Trebon",1, (float) 0.2,2,3, null)));
        casillas.add(new Casilla(18,0, TipoCasilla.SORPRESA));
        casillas.add(new Casilla(19,800, TipoCasilla.CALLE, new TituloPropiedad("El mundo de los Fata",1, (float) 0.2,2,3, null)));
        
        carcel = casillas.get(5);
          
    }
    
    @Override
    public String toString() {
       String resultado = "Casillas del tablero: ";
       
       for(Casilla casi : casillas){
          
           resultado = resultado + casi.toString() + "\n"; 
       }
       
       resultado = resultado + "Cárcel: " + carcel.toString();
       
       return resultado;
    }
}
