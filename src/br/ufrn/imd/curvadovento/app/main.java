package br.ufrn.imd.curvadovento.app;


import br.ufrn.imd.curvadovento.model.Item;
import br.ufrn.imd.curvadovento.model.Pedido;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pedido> pedidos = new ArrayList<>();
        int proximoNumeroPedido = 1;
        boolean executando = true;

        while (executando) {
            System.out.println("\n=-=-=-= Restaurante Curva do Vento =-=-=-=");
            System.out.println("1. Registrar Pedido");
            System.out.println("2. Remover Pedido");
            System.out.println("3. Listar Pedidos");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();

                    // novo objeto Pedido com o número sequencial
                    Pedido novoPedido = new Pedido(proximoNumeroPedido, nomeCliente);

                    String continuarAdicionando = "s";
                    while (continuarAdicionando.equalsIgnoreCase("s")) {
                        System.out.print("Digite o nome do item: ");
                        String nomeItem = scanner.nextLine();

                        System.out.print("Digite o preço do item: R$ ");
                        double precoItem = scanner.nextDouble();
                        scanner.nextLine();

                        Item novoItem = new Item(nomeItem, precoItem);
                        novoPedido.adicionarItem(novoItem);

                        System.out.print("Deseja adicionar outro item? (s/n): ");
                        continuarAdicionando = scanner.nextLine();
                    }

                    pedidos.add(novoPedido);
                    proximoNumeroPedido++;

                    System.out.println("\n===============================");
                    System.out.println(" Restaurante Curva do Vento ");
                    System.out.println("=================================");
                    System.out.println("Pedido N° " + novoPedido.getNumero());
                    System.out.println("Cliente: " + novoPedido.getNomeCliente());
                    System.out.println("----------------------------------------");
                    System.out.println("Itens:");
                    for (Item item : novoPedido.getItens()) {
                        System.out.printf("- %s: R$ %.2f\n", item.getNome(), item.getPreco());
                    }
                    System.out.println("----------------------------------------");
                    System.out.printf("Total: R$ %.2f\n", novoPedido.getValorTotal());
                    System.out.println("========================================");
                    System.out.println(" Obrigado pela preferência! :)");
                    System.out.println("========================================\n");

                    break;

                case 2:
                     System.out.println("\n-=-=-= Remover Pedido -=-=-=");
                    if (pedidos.isEmpty()) {
                        System.out.println("Não há pedidos para remover.");
                        break;
                    }

                    System.out.print("Digite o número do pedido que deseja remover: ");
                    int numeroParaRemover = scanner.nextInt();
                    scanner.nextLine();

                    Pedido pedidoParaRemover = null;
                    for (Pedido pedido : pedidos) {
                        if (pedido.getNumero() == numeroParaRemover) {
                            pedidoParaRemover = pedido;
                            break; // encontrou o pedido para de procurar
                        }
                    }

                    if (pedidoParaRemover != null) {
                        pedidos.remove(pedidoParaRemover); // remove o pedido
                        System.out.println("Pedido N° " + numeroParaRemover + " removido com sucesso!");
                    } else {
                        System.out.println("Erro: Pedido N° " + numeroParaRemover + " não encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("\n-=-=-= Lista de Pedidos =-=-=-");

                    if (pedidos.isEmpty()) {
                        System.out.println("Nenhum pedido registrado até o momento.");
                    } else {
                        for (Pedido pedido : pedidos) {
                            System.out.println("\n========================================");
                            System.out.println("Pedido N° " + pedido.getNumero());
                            System.out.println("Cliente: " + pedido.getNomeCliente());
                            System.out.println("----------------------------------------");
                            System.out.println("Itens:");
                            for (Item item : pedido.getItens()) {
                                System.out.printf("- %s: R$ %.2f\n", item.getNome(), item.getPreco());
                            }
                            System.out.println("----------------------------------------");
                            System.out.printf("Total do Pedido: R$ %.2f\n", pedido.getValorTotal());
                            System.out.println("========================================");
                        }
                    }

                    break;
                case 4:
                    executando = false;
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}