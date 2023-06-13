package recursividade_ex2;

import javax.swing.JOptionPane;

/**
Desenvolva um método que o usuário informe um número e calcule o fatorial desse 
número.  n! = n*(n-1!)
 */

public class Recursividade_ex2 {

    public static void main(String[] args) {
        
        int num;
        String inputNum = JOptionPane.showInputDialog("Informe um número:");
        num = Integer.parseInt(inputNum);
        System.out.println(fatorialNumero(num));
    }
    
    public static int fatorialNumero(int numero){
        
        if(numero == 0 || numero == 1){
            return 1;
        }else{
            return numero * fatorialNumero(numero - 1);
        }
    }
}
