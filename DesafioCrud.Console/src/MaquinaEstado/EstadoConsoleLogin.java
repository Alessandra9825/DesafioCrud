package MaquinaEstado;

import DesafioCrud.Business.Acesso;
import DesafioCrud.Comuns.Enuns.enumConsoleColors;
import DesafioCrud.Comuns.vos.Usuario;
import DesafioCrud.Console.Console;

import java.util.Scanner;

public class EstadoConsoleLogin extends MaquinaEstadoConsole {
    @Override
    public boolean Executa() {
        boolean saida = false;
        Acesso access = new Acesso();
        Scanner read = new Scanner(System.in);
        Usuario user = new Usuario();

        boolean login = false;
        int contador = 3;
        while( contador > 0 && !login)
        {
            try{
                if(contador != 3){
                    System.out.println();
                    System.out.println("Usuário ou senha inválidos - restam: " + contador + " Tentativas!");
                }

                System.out.println();
                System.out.println("Digite seu usuario:");
                user.setLogin(read.nextLine());

                System.out.println();
                System.out.println("Digite sua senha:");
                user.setSenha(read.nextLine());

                login = access.validaUsuario(user);
            }
            catch(Exception e){
                System.out.println();
                System.out.println(enumConsoleColors.RED + "Digite somente numeros na senha!" + enumConsoleColors.RESET);
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
