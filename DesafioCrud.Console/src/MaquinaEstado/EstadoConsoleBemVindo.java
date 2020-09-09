package MaquinaEstado;
import DesafioCrud.Console.Console;

import java.util.Scanner;

public class EstadoConsoleBemVindo extends MaquinaEstadoConsole{

    @Override
    public boolean Executa() {
        System.out.println("Seja Bem Vindo !");
        System.out.println();
        System.out.println("Escolha uma opção:");
        System.out.println("0 - Sair");
        System.out.println("1 - Login");

        Scanner scan = new Scanner(System.in);
        int opcao = -1;

        while(true){
            try{
                opcao = scan.nextInt();
                switch(opcao)
                {
                    case 0:
                        return true;
                    case 1:
                        Console.estadoConsole = enumEstadoConsole.LOGIN.getEstadoConsole();
                        return false;
                    default:
                        System.out.println("Escolha uma opção entre 0 e 1:");
                        break;
                }
            }
            catch (Exception e){
                System.out.println("Digite somente números entre 0 e 1:");
                scan.next();
            }
        }
    }
}
