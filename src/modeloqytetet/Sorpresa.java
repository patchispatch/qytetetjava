/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

/**
 *
 * @author patchispatch
 */
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
        return "Sorpresa{" + "texto=" + texto + ", tipo=" + tipo + ", valor=" + 
                valor + '}';
    }
    
    
    
}
