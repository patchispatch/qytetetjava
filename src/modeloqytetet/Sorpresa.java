package modeloqytetet;

public class Sorpresa {
    //Atributos de la clase:
    private String texto;
    private TipoSorpresa tipo;
    private int valor;
    
    //Constructor:
    Sorpresa(String texto, TipoSorpresa tipo, int valor) {
        this.texto = texto;
        this.tipo = tipo;
        this.valor = valor;
    }
   
    //Consultores:
    String getTexto() {
        return texto;
    }

    TipoSorpresa getTipo() {
        return tipo;
    }

    int getValor() {
        return valor;
    }

    //toString():
    @Override
    public String toString() {
        return "Sorpresa: \n" + 
               "Texto:" + texto + 
               "\n Tipo:" + tipo + 
               "\n Valor: " + valor + "\n";
    }
    
    
    
}
