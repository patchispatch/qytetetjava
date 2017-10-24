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

    public TituloPropiedad(String nombre, int alquilerBase, double factorRevloracizacion, int hipotecaBase, int precioEdificar) {
        this.nombre = nombre;
        this.alquilerBase = alquilerBase;
        this.factorRevloracizacion = factorRevloracizacion;
        this.hipotecaBase = hipotecaBase;
        this.precioEdificar = precioEdificar;
    }

    void cobrarAlquiler (int coste){
        
    }

    int getAlquilerBase() {
        return alquilerBase;
    }

    double getFactorRevloracizacion() {
        return factorRevloracizacion;
    }

    int getHipotecaBase() {
        return hipotecaBase;
    }

    boolean isHipotecada() {
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
        throw new UnsupportedOperationException("Sin implementar");
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
