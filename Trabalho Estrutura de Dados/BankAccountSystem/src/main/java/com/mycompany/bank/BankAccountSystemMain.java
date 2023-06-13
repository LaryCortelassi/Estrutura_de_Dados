import com.mycompany.bank.BankAccountSystem;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Laryssa Ferres 00239784
 * @author Beatriz Omori 00234624
 */
public class BankAccountSystemMain {
    private static BankAccountSystem[] contas;
    private static int numContas;
    private static Scanner scanner;

    public static void main(String[] args) {
        contas = new BankAccountSystem[20];
        numContas = 0;
        scanner = new Scanner(System.in);

        boolean sair = false;

        while (!sair) {
            System.out.println("\n=======< Sistema de Contas Bancárias >=======");
            System.out.println("1. Cadastro");
            System.out.println("2. Exibir contas bancárias ordenadas");
            System.out.println("3. Realizar depósito");
            System.out.println("4. Realizar saque");
            System.out.println("5. Calcular saldo bancário total");
            System.out.println("6. Verificar saldo negativo dos caloteiros");
            System.out.println("7. Verificar saldo da conta do cliente");
            System.out.println("8. Sair");
            System.out.print("Selecione uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    novaConta();
                    break;
                case 2:
                    exibirContasOrdenadas();
                    break;
                case 3:
                    Deposito();
                    break;
                case 4:
                    Saque();
                    break;
                case 5:
                    calcularSaldoTotal();
                    break;
                case 6:
                    verificarSaldoNegativo();
                    break;
                case 7:
                    verificarSaldoContaCliente();
                    break;
                case 8:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        System.out.println("Goodbye");
    }

    private static void novaConta() {
        System.out.print("\nNúmero da conta: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome do titular da conta: ");
        String nomeTitular = scanner.nextLine();
        System.out.print("Saldo inicial: R$");
        double saldoInicial = scanner.nextDouble();

        BankAccountSystem conta = new BankAccountSystem(nomeTitular, numeroConta, saldoInicial);
        contas[numContas] = conta;
        numContas++;

        System.out.println("\nRegistro efetuado com sucesso! Bem vindo(a)" +nomeTitular+ "!");
    }

    private static void exibirContasOrdenadas() {
        System.out.println("\n======< Exibir contas bancárias ordenadas >======");
        System.out.println("1. Por número da conta");
        System.out.println("2. Por saldo");
        System.out.print("Escolha o método para ordenação: ");
        int criterio = scanner.nextInt();

        BankAccountSystem[] contasOrdenadas = Arrays.copyOf(contas, numContas);
        switch (criterio) {
            case 1:
                Arrays.sort(contasOrdenadas, (c1, c2) -> c1.getNumeroConta() - c2.getNumeroConta());
                break;
            case 2:
                Arrays.sort(contasOrdenadas, (c1, c2) -> Double.compare(c1.getSaldo(), c2.getSaldo()));
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        System.out.println("\n=====================< Contas bancárias ordenadas >=====================");
        for (BankAccountSystem conta : contasOrdenadas) {
            System.out.println(conta);
        }
    }

    private static void Deposito() {
        System.out.print("\nInforme o número da conta ou o nome do titular da conta: ");
        String busca = scanner.next();
        boolean encontrada = false;

        for (int i = 0; i < numContas; i++) {
            BankAccountSystem conta = contas[i];
            if (String.valueOf(conta.getNumeroConta()).equals(busca) || conta.getNomeTitular().equalsIgnoreCase(busca)) {
                System.out.print("Valor do depósito: R$");
                double valor = scanner.nextDouble();
                conta.depositar(valor);
                System.out.println("\nOpaaa! O dinheiro já caiu na sua conta " +conta.getNomeTitular()+"!");
                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            System.out.println("Conta não encontrada... Mas não se preocupe, fique a vontade para se registrar! Rápido e fácil.");
        }
    }

    private static void Saque() {
        System.out.print("Informe o número da conta: ");
        int numeroConta = scanner.nextInt();
        boolean encontrada = false;

        int posicao = buscaBinariaContasOrdenadas(numeroConta);

        if (posicao >= 0) {
            BankAccountSystem conta = contas[posicao];
            System.out.print("Valor do saque: R$");
            double valor = scanner.nextDouble();

            conta.sacar(valor);
            System.out.println("\nSaque efetuado com sucesso!");

            encontrada = true;
        }

        if (!encontrada) {
            System.out.println("\nConta não encontrada... Mas não se preocupe, fique a vontade para se registrar! Rápido e fácil.");
        }
    }

    private static int buscaBinariaContasOrdenadas(int numeroConta) {
        int inicio = 0;
        int fim = numContas - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            BankAccountSystem conta = contas[meio];

            if (conta.getNumeroConta() == numeroConta) {
                return meio;
            } else if (conta.getNumeroConta() < numeroConta) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1;
    }

    private static void calcularSaldoTotal() {
        double saldoTotal = calcularSaldoTotalRecursivo(0);
        System.out.println("\nSaldo bancário total: R$" + saldoTotal);
    }

    private static double calcularSaldoTotalRecursivo(int indice) {
        if (indice == numContas) {
            return 0;
        }

        BankAccountSystem conta = contas[indice];
        return conta.getSaldo() + calcularSaldoTotalRecursivo(indice + 1);
    }
    
    private static void verificarSaldoNegativo() {
    System.out.println("\n======< Verificando contas com saldo negativo >======");
    boolean encontradas = false;

    for (int i = 0; i < numContas; i++) {
        BankAccountSystem conta = contas[i];
        if (conta.getSaldo() < 0) {
            System.out.println("\nA conta com saldo negativo pertence a: " + conta.getNomeTitular());
            System.out.println("Saldo atual: -R$" + Math.abs(conta.getSaldo()));
            encontradas = true;
        }
    }

    if (!encontradas) {
        System.out.println("\nNão foram encontradas contas com saldo negativo!!! Sem caloteiros até o momento :)");
    }
}
    
    private static void verificarSaldoContaCliente() {
        System.out.print("\nInforme o número da conta ou o nome do titular da conta: ");
       String busca = scanner.next();
       boolean encontrada = false;

       for (int i = 0; i < numContas; i++) {
           BankAccountSystem conta = contas[i];
           if (String.valueOf(conta.getNumeroConta()).equals(busca) || conta.getNomeTitular().equalsIgnoreCase(busca)) {
                System.out.println("\nSaldo da conta de " + conta.getNomeTitular() + ": R$" + conta.getSaldo());
              encontrada = true;
               break;
           }
       }

        if (!encontrada) {
          System.out.println("Conta não encontrada.");
       }
   }
}
