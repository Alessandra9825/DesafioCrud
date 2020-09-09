package MaquinaEstado;

import DesafioCrud.Business.RoupaNegocio;
import DesafioCrud.Comuns.ConsoleColors;
import DesafioCrud.Console.Console;
import DesafioCrud.DAO.RoupaDAO;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class EstadoConsoleDelete extends MaquinaEstadoConsole {
    private Scanner read = new Scanner(System.in);

    @Override
    public boolean Executa()
    {
        RoupaNegocio neg = new RoupaNegocio();
        int id = -1;
        boolean resp = false;
        boolean saida = false;
        boolean delete = false;

        while(!resp){
            try{
                System.out.println();
                System.out.println("Informe o Id do produto:");
                id = read.nextInt();

                if(id <= 0){
                    System.out.println();
                    System.out.println(ConsoleColors.RED + "Não existe ID's menores do que zero!" + ConsoleColors.RESET);
                    resp = sairDelete();
                }

                resp = sairDelete();
            }
            catch (Exception e){
                System.out.println();
                System.out.println(ConsoleColors.RED + "Informe somenete números no ID!" + ConsoleColors.RESET);
                read.next();
            }
        }

        Console.estadoConsole = enumEstadoConsole.HOME.getEstadoConsole();
        return saida;
    }

    private boolean sairDelete(){
        int resp = -1;
        while (true){
            try{
                System.out.println();
                System.out.println("Deseja tentar uma nova exclusão?");
                System.out.println("0 - Não");
                System.out.println("1 - Sim");
                resp = read.nextInt();

                if(resp == 0)
                    return true;
                else if (resp == 1)
                    return false;
                else
                    System.out.println(ConsoleColors.RED + "Informe somente 0 ou 1!" + ConsoleColors.RESET);
            }
            catch (Exception e)
            {
                System.out.println();
                System.out.println(ConsoleColors.RED + "Informe 0 (Sair) ou 1 (nova Exclusão)!" + ConsoleColors.RESET);
                read.next();
            }
        }
    }
}
