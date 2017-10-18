package modeloqytetet;

public class Dado {
    private static final Dado instance = new Dado();
    
    private Dado(){}

    public static Dado getInstance() {
        return instance;
    }
    
    int tirar(){
        int aleatorio;
        aleatorio = (int) (Math.random()*6+1);
        
        return(aleatorio);
    }
}
