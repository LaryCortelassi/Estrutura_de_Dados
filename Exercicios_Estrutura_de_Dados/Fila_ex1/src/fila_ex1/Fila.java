package fila_ex1;

/**
 *
 * @author Laryssa
 */
public class Fila {
    
    private String[]vetorSenha;
    private int frente;
    private int fim;
    private int qtdItens;

    public Fila(int tamanho) {
        vetorSenha = new String [tamanho];
        frente = 0;
        fim = -1;
        qtdItens = 0;
    }
    
    public void enqueue(String numero){
        if(fim == vetorSenha.length -1){
            fim = -1;
        }
        vetorSenha[++fim] = numero;
        qtdItens++;
    }

    public String dequeue(){
        String aux = vetorSenha[frente++];
        if(frente == vetorSenha.length){
            frente = 0;
        }
        qtdItens--;
        return aux;
    }
    
    public boolean isEmpty(){
        return qtdItens == 0;
    }
    
    public boolean isFull(){
        return qtdItens == vetorSenha.length;
    }
}
