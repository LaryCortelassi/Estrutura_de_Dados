package recursividade_ex1;

//Desenvolva um método que faça a soma de 0 a 50

public class Recursividade_ex1 {

    public static void main(String[] args) {
        
        int ini = 0;
        int fim = 50;
        System.out.println(somaNumeros(ini,fim));
        
    }
    
    public static int somaNumeros(int num1, int num2){
        
        int soma = 0;
        while(num1 <= num2){
            soma += num1;//soma o intervalo de números
            num1++;//incrementa até chegar no 50
        }
        return soma;
    }
}
