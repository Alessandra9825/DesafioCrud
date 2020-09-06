package MaquinaEstado;

import DesafioCrud.Comuns.Roupa;
import DesafioCrud.DAO.RoupaDAO;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EstadoConsoleConsultar extends MaquinaEstadoConsole{
    @Override
    public boolean Executa() {
        try
        {
            RoupaDAO dao = new RoupaDAO();
            int codigoItem;
            Scanner read = new Scanner(System.in);

            System.out.println("Digite o codigo do item que deseja consultar");
            codigoItem = read.nextInt();
            Roupa consultada = dao.consulta(codigoItem);
            System.out.println("Codigo: "+consultada.getCodigoItem());
            System.out.println("Data de Entrada: "+consultada.getDataEntrada());
            System.out.println("Local de Compra: "+consultada.getLocalCompra());
            System.out.println("Marca: "+consultada.getMarca());
            System.out.println("Descrição: "+consultada.getDescricao());
            System.out.println("Tipo: "+consultada.getTipo());
            System.out.println("Cor: "+consultada.getCor());
            System.out.println("Tamanho: "+consultada.getTamanho());
        }
        catch (Exception err)
        {
            Logger.getLogger(RoupaDAO.class.getName()).log(Level.SEVERE, null, err);
        }
        return true;
    }
}
