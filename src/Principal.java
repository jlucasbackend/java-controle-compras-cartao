import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Principal {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        String nomeProduto;
        double valorProduto;
        int opcao = 0;
        double limiteCartao = 0;
        double saldoCartao = 0;

        ArrayList<Compras> listaDeCompras = new ArrayList<>();

        System.out.println("""
                DIGITE O LIMITE DO CARTÃO: 
                """);
        limiteCartao = scanner.nextDouble();
        saldoCartao = limiteCartao;

        while (opcao != 3) {
            System.out.println("""
                    ESCOLHA UMA OPÇÃO:
                    1 - CONSULTAR SALDO
                    2 - REGISTRAR UMA COMPRA
                    3 - FINALIZAR COMPRAS
                    """);

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("---------CONSULTANDO SALDO ATUAL---------");
                    break;
                case 2:
                    System.out.println("---------REGISTRAR UMA COMPRA---------");
                    break;
                case 3:
                    System.out.println("---------FINALIZANDO COMPRAS---------");
                    break;
                default:
                    System.out.println("---------OPÇÃO INVALIDA! ESCOLHA NOVAMENTE ENTRE AS OPÇÕES DISPONIVEIS---------");
                    break;
            }

            if (opcao == 1) {
                System.out.println("SALDO ATUAL: " + saldoCartao);
                System.out.println("---------------------------");
            } else if (opcao == 2) {
                System.out.println("DIGITE O NOME DO PRODUTO: ");
                nomeProduto = scanner.nextLine();
                System.out.println("DIGITE O VALOR DO PRODUTO: ");
                valorProduto = scanner.nextDouble();
                if (saldoCartao >= valorProduto) {
                    Compras compra = new Compras(nomeProduto, valorProduto);
                    listaDeCompras.add(compra);
                    System.out.println("COMPRA REGISTRADA!");
                    System.out.println("---------------------------");
                    saldoCartao -= valorProduto;
                } else {
                    System.out.println("SALDO INSUFICIENTE! SALDO ATUAL: " + saldoCartao);
                    System.out.println("---------------------------");
                }
            } else if (opcao == 3) {
                System.out.println("LISTA DE COMPRAS REALIZADAS:");
                System.out.println();
                listaDeCompras.sort(Comparator.comparingDouble(Compras::getValorProduto));
                for (Compras item : listaDeCompras) {
                    System.out.println(item.getNomeProduto() + " - " + item.getValorProduto());
                }

                System.out.println("---------------------------");
                System.out.println("SALDO RESTANTE DO CARTAO: " + saldoCartao);
                System.out.println();
            } else {
                System.out.println("OPÇÃO INVALIDA! TENTE ALGUMA DAS ACIMA");
            }
        }
    }
}
