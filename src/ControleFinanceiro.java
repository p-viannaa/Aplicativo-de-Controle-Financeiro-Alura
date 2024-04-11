import java.util.Scanner;

public class ControleFinanceiro {
    public static void main(String[] args) {
        // Saldo inicial
        double saldoAtual = 5000;

        Scanner opcao = new Scanner(System.in);

        // Strings padrões para a interface da aplicação
        String cabecalho = """
                *********************************************
                Dados iniciais do cliente:

                Nome:           Pedro Vianna
                Tipo conta:     Corrente
                Saldo inicial:  R$ %.2f
                *********************************************
                """.formatted(saldoAtual);

        String atendimento = """
                Operações

                1- Consultar saldos
                2- Receber valor
                3- Transferir valor
                4- Sair

                Digite a opção desejada:\
                """;

        // Inicialização da aplicação
        System.out.println(cabecalho);
        System.out.println(atendimento);
        int servico = opcao.nextInt();

        while (servico != 4) {
            if (servico == 1) {
                System.out.println("O saldo atual é R$ %.2f\n".formatted(saldoAtual));
                System.out.println(atendimento);
                servico = opcao.nextInt();
            } else if (servico == 2) {
                System.out.println("Informe o valor a receber:");
                double deposito = opcao.nextDouble();
                saldoAtual += deposito;
                System.out.println("Saldo atualizado R$ %.2f\n".formatted(saldoAtual));
                System.out.println(atendimento);
                servico = opcao.nextInt();
            } else if (servico == 3) {
                System.out.println("Informe o valor que deseja transferir:");
                double saque = opcao.nextDouble();
                if (saque > saldoAtual) {
                    System.out.println("Não há saldo suficiente para essa transferência\n");
                    System.out.println(atendimento);
                    servico = opcao.nextInt();
                } else {
                    saldoAtual -= saque;
                    System.out.println("Saldo atualizado R$ %.2f\n".formatted(saldoAtual));
                    System.out.println(atendimento);
                    servico = opcao.nextInt();
                }
            } else {
                System.out.println("Opcão inválida\n");
                System.out.println(atendimento);
                servico = opcao.nextInt();
            }
        }

        System.out.println("\nObrigado pela preferência");
        opcao.close();
    }
}
