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
        boolean resultado;
        
        if (numeroCasilla == carcel.getNumeroCasilla())
            resultado = true;
        
        else 
            resultado = false;
        
        return resultado;
    }
    
    Casilla getCarcel() {
        return carcel;
    }
    
    public Casilla obtenerCasillaNumero (int numeroCasilla){
        /*
        
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
        */
        
        Casilla devolver = casillas.get(numeroCasilla);
        
        return devolver;
    }
    
    
    Casilla obtenerNuevaCasilla (Casilla casilla, int desplazamiento){
        
        int num_actual = casilla.getNumeroCasilla();
        
        int num_nueva = (num_actual + desplazamiento) % 20;
        
        Casilla resultado = this.obtenerCasillaNumero(num_nueva);
        
        return resultado;
        
    }

    
    //Casillas del tablero:
    private void Inicializar(){
        
        casillas = new ArrayList();
        
        casillas.add(new OtraCasilla(0,0,TipoCasilla.SALIDA));
        casillas.add(new Calle(1,500,new TituloPropiedad("Calle Richard Widmark",150, (float) 0.65,280,250, null)));
        casillas.add(new Calle(2,200,new TituloPropiedad("El piso",100, (float) 0.75,125,75, null)));
        casillas.add(new OtraCasilla(3,0,TipoCasilla.SORPRESA));
        casillas.add(new Calle(4,350,new TituloPropiedad("La ETSIIT",150, (float) 0.7,185,175, null)));
        casillas.add(new OtraCasilla(5,0,TipoCasilla.CARCEL));
        casillas.add(new Calle(6,400,new TituloPropiedad("Calle OFFICIALSakurai",180,(float) 0.8,240,200, null)));
        casillas.add(new Calle(7,425,new TituloPropiedad("Calle Hacktoberfest",195, (float) 0.7,220,210, null)));
        casillas.add(new OtraCasilla(8,500,TipoCasilla.IMPUESTO));
        casillas.add(new Calle(9,300,new TituloPropiedad("El centro de salud de Pepe que no le gusta",100, (float) 0.65,120,110, null)));
        casillas.add(new OtraCasilla(10,0,TipoCasilla.PARKING));
        casillas.add(new Calle(11,650,new TituloPropiedad("El piso de Alberto con bolsas de basura en la entrada",200, (float) 0.9,320,280, null)));
        casillas.add(new Calle(12,540,new TituloPropiedad("Centro comercial Neptuno",180, (float) 0.75,240,210, null)));
        casillas.add(new OtraCasilla(13,0, TipoCasilla.SORPRESA));
        casillas.add(new Calle(14,700,new TituloPropiedad("Hotel Perro",300, (float) 0.8,350,310, null)));
        casillas.add(new OtraCasilla(15,0,TipoCasilla.JUEZ));
        casillas.add(new Calle(16,250,new TituloPropiedad("La casa de Nier y Yonah",120, (float) 0.65,170,150,null)));
        casillas.add(new Calle(17,725,new TituloPropiedad("El mundo de tarzan de KH1",300, (float) 0.9,320,310, null)));
        casillas.add(new OtraCasilla(18,0, TipoCasilla.SORPRESA));
        casillas.add(new Calle(19,800,new TituloPropiedad("Como sea que se llame el mundo de FFXIII",380, (float) 0.8,420,400, null)));
        
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
