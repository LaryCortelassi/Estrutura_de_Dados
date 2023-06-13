package br.unipar.ex1;

import javax.swing.JOptionPane;
/*
Desenvolva um programa que solicite ao usuário para informar a quantidade de 
números que irá cadastrar, após solicite para informar os mesmos.  
Nesse aplicativo deverá ter um menu para selecionar o tipo de pesquisa que 
deseja fazer, linear ou binária. 
Para efetuar a pesquisa solicite qual número a ser pesquisado, 
coloque-os em ordem crescente 
e faça a pesquisa seleciona e exiba para o usuário o resultado.
*/
public class Ex1 {

    public static void main(String[] args) {
        
        int n;
        String input = JOptionPane.showInputDialog("Informe a quantidade de cadastros:");
        n = Integer.parseInt(input);
        
        int []vetor = new int[n];

        int i;
        
        for(i=0; i<n; i++){
            String inputVetor = JOptionPane.showInputDialog("Informe os números:");
            vetor[i] = Integer.parseInt(inputVetor); 
        }
        
        String tipoPesquisa = JOptionPane.showInputDialog("Deseja usar pesquisa liner(L) ou binária(B)?");
        
        int num;
        String numPesquisa = JOptionPane.showInputDialog("Informe o número para pesquisar:");
        num = Integer.parseInt(numPesquisa);
        
        for(i=0; i<vetor.length; i++){
            int menor = i;
            for(int j = i+1; j<vetor.length; j++){
                if(vetor[j] < vetor[menor]){
                    menor = j;
                }
            }
            if(menor != i){
                int aux = vetor[i];
                vetor[i] = vetor[menor];
                vetor[menor] = aux;
            }
        }
        for(i=0; i<vetor.length; i++){
            System.out.println(vetor[i] + "["+i+"]");
        }
        
        switch (tipoPesquisa.toUpperCase()) {
            case "L" -> System.out.println("O número selecionado " + num + " posição " + pesquisaLinear(num,vetor));
            case "B" -> System.out.println("Número selecionado "+ num + " posição " + pesquisaBinaria(num, vetor));
            default -> System.out.println("opção nao existe");
        }

    }
    
    public static int pesquisaLinear(int numPesq, int[]vet){
        for(int i=0; i<vet.length; i++){
            if(numPesq == vet[i]){
                return i;
            }
        }
        return -1;
    }
    
    public static int pesquisaBinaria(int numPesq, int[]vet){
        int esquerda, meio, direita;
        esquerda = 0;
        direita = vet.length -1;
        
        while(esquerda <= direita){
            meio = (esquerda + direita)/2;
            if(numPesq == vet[meio]){
                return meio;
            }
            if(numPesq > vet[meio]){
                esquerda = meio + 1;
            }else{
                direita = meio - 1;
            }
        }
        return -1;
    }
}
