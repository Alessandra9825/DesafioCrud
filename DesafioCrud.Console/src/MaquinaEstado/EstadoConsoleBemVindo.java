package MaquinaEstado;
import DesafioCrud.Console.Console;

import java.util.Scanner;

public class EstadoConsoleBemVindo extends MaquinaEstadoConsole{

    @Override
    public boolean Executa() {
        boolean saida = false;

        System.out.println("Seja Bem Vindo !");
        System.out.println();
        System.out.println("Escolha uma opção:");
        System.out.println("0 - Sair");
        System.out.println("1 - Login");

        Scanner scan = new Scanner(System.in);
        int opcao = scan.nextInt();

        switch(opcao)
        {
            case 0:
                saida = true;
                break;
            case 1:
                Console.estadoConsole = enumEstadoConsole.LOGIN.getEstadoConsole();
                break;
        }

        return saida;
    }
}
