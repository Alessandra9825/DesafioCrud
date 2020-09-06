package MaquinaEstado;

import DesafioCrud.DAO.RoupaDAO;

import java.util.Scanner;

public class EstadoConsoleDelete extends MaquinaEstadoConsole {
    @Override
    public boolean Executa()
    {
        RoupaDAO dao = new RoupaDAO();
        int aux;
        Scanner read = new Scanner(System.in);

        System.out.println("Degite codigo do item que deseja apagar");
        aux = read.nextInt();
        System.out.println(dao.delete(aux));

        return true;
    }
}
