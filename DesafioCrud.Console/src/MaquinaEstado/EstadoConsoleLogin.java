package MaquinaEstado;

import DesafioCrud.Business.Acesso;
import DesafioCrud.Console.Console;

import java.util.Scanner;

public class EstadoConsoleLogin extends MaquinaEstadoConsole {
    @Override
    public boolean Executa() {
        boolean saida = false;
        Acesso access = new Acesso();
        Scanner read = new Scanner(System.in);
        String password;
        String user;

        boolean login = false;
        int contador = 3;
        while( contador == 0 || !login)
        {
            if(contador != 3){
                System.out.println("Usuário ou senha inválidos - restam: " + contador + " Tentativas!");
                System.out.println();
            }

            System.out.println("Digite seu usuario:");
            user = read.next();

            System.out.println("Digite sua senha:");
            password = read.next();

            login = access.login(user, password);

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
