package modeloqytetet;

public class TituloPropiedad {
    //Atributos de instancia
    private String nombre;
    private boolean hipotecada = false;
    private int alquilerBase;
    private double factorRevalorizacion;
    private int hipotecaBase;
    private int precioEdificar;
    
    //Atributos de referencia
    public Jugador propietario;
    private Casilla casilla;

    public TituloPropiedad(String nombre, int alquilerBase, 
            double factorRevalorizacion, int hipotecaBase, 
            int precioEdificar, Jugador propietario) {
        this.nombre = nombre;
        this.alquilerBase = alquilerBase;
        this.factorRevalorizacion = factorRevalorizacion;
        this.hipotecaBase = hipotecaBase;
        this.precioEdificar = precioEdificar;
        this.propietario = propietario;
    }

    void cobrarAlquiler (int coste){
        propietario.modificarSaldo(coste);
    }

    int getAlquilerBase() {
        return alquilerBase;
    }
        
    public Casilla getCasilla() {
        return casilla;
    }
    
    double getFactorRevalorizacion() {
        return factorRevalorizacion;
    }

    int getHipotecaBase() {
        return hipotecaBase;
    }

    boolean getHipotecada() {
        return hipotecada;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    int getPrecioEdificar() {
        return precioEdificar;
    }
    
    boolean propietarioEncarcelado(){
        return (propietario.getEncarcelado());
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
    
    @Override
    public String toString() {
        return "Título de propiedad: \n" + "Nombre: " + nombre + 
               "\n Hipotecada: " + hipotecada + 
               "\n Alquiler Base: " + alquilerBase + 
               "\n Factor Revalorizacion: " + factorRevalorizacion + 
               "\n Hipoteca Base: " + hipotecaBase + 
               "\n Precio Edificar: " + precioEdificar + "\n";
    }

    
}
