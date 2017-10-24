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
        casillas.add(new Casilla(1,500,TipoCasilla.CALLE,new TituloPropiedad("AA",1, (float) 0.65,2,3, null)));
        casillas.add(new Casilla(2,200,TipoCasilla.CALLE,new TituloPropiedad("BB",1, (float) 0.75,2,3, null)));
        casillas.add(new Casilla(3,0,TipoCasilla.SORPRESA));
        casillas.add(new Casilla(4,350, TipoCasilla.CALLE,new TituloPropiedad("CC",1, (float) 0.7,2,3, null)));
        casillas.add(new Casilla(5,0,TipoCasilla.CARCEL));
        casillas.add(new Casilla(6,400, TipoCasilla.CALLE,new TituloPropiedad("DD",1,(float) 0.2,2,3, null)));
        casillas.add(new Casilla(7,425,TipoCasilla.CALLE,new TituloPropiedad("EE",1, (float) 0.2,2,3, null)));
        casillas.add(new Casilla(8,0,TipoCasilla.IMPUESTO));
        casillas.add(new Casilla(9,300, TipoCasilla.CALLE,new TituloPropiedad("FF",1, (float) 0.2,2,3, null)));
        casillas.add(new Casilla(10,0,TipoCasilla.PARKING));
        casillas.add(new Casilla(11,650,TipoCasilla.CALLE,new TituloPropiedad("GG",1, (float) 0.2,2,3, null)));
        casillas.add(new Casilla(12,540, TipoCasilla.CALLE,new TituloPropiedad("HH",1, (float) 0.2,2,3, null)));
        casillas.add(new Casilla(13,0, TipoCasilla.SORPRESA));
        casillas.add(new Casilla(14,700, TipoCasilla.CALLE,new TituloPropiedad("II",1, (float) 0.2,2,3, null)));
        casillas.add(new Casilla(15,0,TipoCasilla.JUEZ));
        casillas.add(new Casilla(16,250, TipoCasilla.CALLE,new TituloPropiedad("JJ",1, (float) 0.2,2,3,null)));
        casillas.add(new Casilla(17,725, TipoCasilla.CALLE, new TituloPropiedad("KK",1, (float) 0.2,2,3, null)));
        casillas.add(new Casilla(18,0, TipoCasilla.SORPRESA, new TituloPropiedad("LL",1, (float) 0.2,2,3, null)));
        casillas.add(new Casilla(19,800, TipoCasilla.CALLE, new TituloPropiedad("MM",1, (float) 0.2,2,3, null)));
        
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
