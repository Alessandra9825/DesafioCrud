package MaquinaEstado;

import DesafioCrud.Business.Acesso;
import DesafioCrud.Comuns.ConsoleColors;
import DesafioCrud.Console.Console;

import java.util.Scanner;

public class EstadoConsoleLogin extends MaquinaEstadoConsole {
    @Override
    public boolean Executa() {
        boolean saida = false;
        Acesso access = new Acesso();
        Scanner read = new Scanner(System.in);
        int password;
        String user;

        boolean login = false;
        int contador = 3;
        while( contador > 0 && !login)
        {
            try{
                if(contador != 3){
                    System.out.println("Usuário ou senha inválidos - restam: " + contador + " Tentativas!");
                }

                System.out.println();
                System.out.println("Digite seu usuario:");
                user = read.next();

                System.out.println();
                System.out.println("Digite sua senha:");
                password = read.nextInt();

                login = access.login(user, password);
            }
            catch(Exception e){
                System.out.println();
                System.out.println(ConsoleColors.RED + "Digite somente numeros na senha!" + ConsoleColors.RESET);
                read.next();
            }

            contador--;
        }

        if(login)
            Console.estadoConsole = enumEstadoConsole.HOME.getEstadoConsole();
        else if(contador == 0){
            System.out.println();
            System.out.println("Usuário não conseguiu logar. Saindo....");
            saida = true;
        }


        return saida;
    }
}
