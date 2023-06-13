package br.unipar.ex2;
import br.unipar.ex2.models.Clientes;
import javax.swing.JOptionPane;
/*
Crie um aplicativo de cadastro de clientes, 
deve-se armazenar o código, Nome, data de 
nascimento e cpf. Faça com que o usuário informe 
esses dados, o aplicativo deverá ordenar os 
clientes pelo código. Faça com que o aplicativo 
solicite ao usuário informar o código do cliente 
efetue uma pesquisa binária para localizar o 
cliente e exibir na tela os seus dados
*/
public class Ex2 {

    public static void main(String[] args) {   
        
        int qtdCadastro;
        String inputCadastro = JOptionPane.showInputDialog("Informe a quantidade de cadastros que deseja informar:");
        qtdCadastro = Integer.parseInt(inputCadastro);

        Clientes[] clientes = new Clientes[qtdCadastro];

        for(int i=0; i < qtdCadastro; i++){
            clientes[i] = new Clientes();
            
            String inputCodigo = JOptionPane.showInputDialog("Informe o código:");
            clientes[i].setCodigo(Integer.parseInt(inputCodigo));
            
            String inputNome = JOptionPane.showInputDialog("Informe o nome:");
            clientes[i].setNome(inputNome);
            
            String inputDtNascimento = JOptionPane.showInputDialog("Informe a data de nascimento:");
            clientes[i].setDtNascimento(inputDtNascimento);
            
            String inputCpf = JOptionPane.showInputDialog("Informe o cpf:");
            clientes[i].setCpf(inputCpf);

        }

        for(int i=0; i < qtdCadastro - 1; i++){
            int posMenor = i;
            for(int j=i+1; j < qtdCadastro; j++){
                if(clientes[j].getCodigo() < clientes[posMenor].getCodigo()){
                    posMenor = j;
                }
            }
            if(posMenor != i){
                int aux = clientes[i].getCodigo();
                clientes[i].setCodigo(clientes[posMenor].getCodigo());
                clientes[posMenor].setCodigo(aux);
            }
        }
   
        int numPesquisa;
        String inputPesquisa = JOptionPane.showInputDialog("Informe o código que deseja pesquisar:");
        numPesquisa = Integer.parseInt(inputPesquisa);
        
        System.out.println("Segue os dados do cliente:" + 
                clientes[pesquisaBinaria(numPesquisa, clientes)].toString()); 

    }
    
    public static int pesquisaBinaria(int numPesq, Clientes []cadastros){
        
        int esquerda, meio, direita;
        esquerda = 0;
        direita = cadastros.length - 1;
        
        while(esquerda <= direita){
            meio = (esquerda + direita)/ 2;
            if(numPesq == cadastros[meio].getCodigo()){
                return meio;
            }
            if(numPesq > cadastros[meio].getCodigo()){
                esquerda = meio + 1;
            }else{
                direita = meio - 1;
            }
            if(esquerda > direita){
                System.out.println("Código do cliente não encontrado.");
            }
        }       
        return -1;
    }
}
