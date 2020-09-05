package MaquinaEstado;

import java.util.Scanner;

public class EstadoConsoleHome extends MaquinaEstadoConsole {
    @Override
    public boolean Executa() {
        boolean saida = false;
        Scanner read = new Scanner(System.in);

        System.out.println("Escolha uma opção:");
        System.out.println("1- Inserir produto:");
        System.out.println("2- Remover produto:");
        System.out.println("3- Alterar Produto:");
        System.out.println("4- Consultar produtos:");
        int opcao = read.nextInt();

        while (opcao != 0){
            switch (opcao){
                case 0:
                    saida = true;
                    break;
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("Four");
                    break;
                default:
                    System.out.println("Digite SOMENTE números entre 1 e 4");
                    break;
            }
        }

        return saida;
    }
}
