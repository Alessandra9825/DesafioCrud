package MaquinaEstado;

import DesafioCrud.Comuns.Enuns.enumConsoleColors;
import DesafioCrud.Console.Console;

import java.util.Scanner;

public class EstadoConsoleHome extends MaquinaEstadoConsole {
    @Override
    public boolean Executa() {
        boolean saida = false;
        Scanner read = new Scanner(System.in);

        try {
            System.out.println();
            System.out.println("Menu Principal!");
            System.out.println("Escolha uma opção:");
            System.out.println("0- Sair:");
            System.out.println("1- Inserir um produto:");
            System.out.println("2- Remover um produto:");
            System.out.println("3- Alterar um Produto:");
            System.out.println("4- Consultar um produtos:");
            int opcao = 9;

            while (opcao >= 5) {
                opcao = read.nextInt();
                switch (opcao) {
                    case 0:
                        Console.estadoConsole = enumEstadoConsole.BEM_VINDO.getEstadoConsole();
                        break;
                    case 1:
                        Console.estadoConsole = enumEstadoConsole.SALVAR.getEstadoConsole();
                        break;
                    case 2:
                        Console.estadoConsole = enumEstadoConsole.DELETE.getEstadoConsole();
                        break;
                    case 3:
                        Console.estadoConsole = enumEstadoConsole.ATUALIZAR.getEstadoConsole();
                        break;
                    case 4:
                        Console.estadoConsole = enumEstadoConsole.CONSULTAR.getEstadoConsole();
                        break;
                    default:
                        System.out.println();
                        System.out.println("Digite SOMENTE números entre 0 e 4");
                        read.nextLine();
                        break;
                }
            }
        }
        catch (Exception e){
            System.out.println(enumConsoleColors.RED + "Informe somente números!" + enumConsoleColors.RESET);
            read.nextLine();
        }

        return saida;
    }
}
