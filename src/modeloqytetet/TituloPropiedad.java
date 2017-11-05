package modeloqytetet;

public class TituloPropiedad {
    //Atributos de instancia
    private String nombre;
    private boolean hipotecada = false;
    private int alquilerBase;
    private double factorRevloracizacion;
    private int hipotecaBase;
    private int precioEdificar;
    //Atributos de referencia
    private Jugador propietario;
    private Casilla casilla;

    public TituloPropiedad(String nombre, int alquilerBase, 
            double factorRevloracizacion, int hipotecaBase, 
            int precioEdificar, Jugador propietario) {
        this.nombre = nombre;
        this.alquilerBase = alquilerBase;
        this.factorRevloracizacion = factorRevloracizacion;
        this.hipotecaBase = hipotecaBase;
        this.precioEdificar = precioEdificar;
        this.propietario = propietario;
    }

    void cobrarAlquiler (int coste){
        throw new UnsupportedOperationException("Sin implementar"); 
    }

    int getAlquilerBase() {
        return alquilerBase;
    }
        
    Casilla getCasilla() {
        return casilla;
    }
    
    double getFactorRevloracizacion() {
        return factorRevloracizacion;
    }

    int getHipotecaBase() {
        return hipotecaBase;
    }

    boolean getHipotecada() {
        return hipotecada;
    }
    
    String getNombre() {
        return nombre;
    }
    
    int getPrecioEdificar() {
        return precioEdificar;
    }
    
    boolean propietarioEncarcelado(){
        throw new UnsupportedOperationException("Sin implementar");
    }

    void setCasilla(Casilla casilla) {
        this.casilla = casilla;
    }

    void setHipotecada(boolean hipotecada) {
        this.hipotecada = hipotecada;
    }
    void setPropietario(Jugador propietario) {
        this.propietario = propietario;
    }
    
    boolean tengoPropietario(){
        boolean resultado;
        if(propietario != null)
            resultado = true;
        else
            resultado = false;
        
        return resultado;
    }
    
    int calcularValor() {
        int valor;
        
        //Valor inicial de casilla:
        valor = casilla.precioTotalComprar();
        
        if (hipotecada)
            valor -= hipotecaBase;
        
        return valor;
    }
    
    @Override
    public String toString() {
        return "TituloPropiedad{" + "nombre=" + nombre + ", hipotecada=" 
                + hipotecada + ", alquilerBase=" + alquilerBase 
                + ", factorRevloracizacion=" + factorRevloracizacion 
                + ", hipotecaBase=" + hipotecaBase + ", precioEdificar=" 
                + precioEdificar + '}';
    }

    
}
