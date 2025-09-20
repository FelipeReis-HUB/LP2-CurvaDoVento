package br.ufrn.imd.curvadovento.app;


import br.ufrn.imd.curvadovento.model.Pedido;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pedido> pedidos = new ArrayList<>();
        int proximoNumeroPedido;
        boolean executando = true;

        while (executando) {
            System.out.println("\n--- Restaurante Curva do Vento ---");
            System.out.println("1. Registrar Pedido");
            System.out.println("2. Remover Pedido");
            System.out.println("3. Listar Pedidos");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Opção 1 selecionada: Registrar Pedido");
                    break;
                case 2:
                    System.out.println("Opção 2 selecionada: Remover Pedido");
                    break;
                case 3:
                    System.out.println("Opção 3 selecionada: Listar Pedidos");
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