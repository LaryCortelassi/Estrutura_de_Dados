
package recursividade_ex3;

import javax.swing.JOptionPane;

/**
 Desenvolva um método que mostre a seguência Fibonacci de um número.
 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55..
 */

public class Recursividade_ex3 {

    public static void main(String[] args) {
        
        int num;
        
        String inputNum = JOptionPane.showInputDialog("Informe um número:");
        num = Integer.parseInt(inputNum);
        
        for (int i = 0; i <= num; i++) {
            System.out.print(sequenciaFibonacci(i) + "\n");
        }
        
    }
    
    public static int sequenciaFibonacci(int numero){
        
        if(numero <= 1){
            return numero;
        }else{
            return sequenciaFibonacci(numero-1) + sequenciaFibonacci(numero-2);
        }  
    }   
}
