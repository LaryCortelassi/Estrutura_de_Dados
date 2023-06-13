package fila_ex1;

import javax.swing.JOptionPane;

public class Fila_ex1 {

    public static void main(String[] args) {
        
        Fila fila = new Fila(20);
        int opcao;
        do{
            String inputMenu = JOptionPane.showInputDialog("1 - Adicionar paciente \n2 - Chamar próximo paciente");
            opcao = Integer.parseInt(inputMenu);
            
            switch(opcao){
                case 1 -> {
                    String inputPaciente = JOptionPane.showInputDialog("Informe o nome do paciente");
                    fila.enqueue(inputPaciente);
                }
                case 2 -> {
                    System.out.println("Próximo paciente: " + fila.dequeue());
                }
                default -> System.out.print("Opção inválida.");
            }   
        }while(!fila.isFull());
    } 
}
