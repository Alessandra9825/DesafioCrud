package MaquinaEstado;

import DesafioCrud.Business.RoupaNegocio;
import DesafioCrud.Comuns.Roupa;
import DesafioCrud.Comuns.enumCor;
import DesafioCrud.Comuns.enumTamanho;
import DesafioCrud.DAO.RoupaDAO;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class EstadoConsoleSalvar extends MaquinaEstadoConsole{
    @Override
    public boolean Executa() {
        boolean saida = false;
        Roupa obj = new Roupa();
        Scanner read = new Scanner(System.in);

        System.out.println("Informe ");

        System.out.println("Codigo do Item");
        obj.setCodigoItem(read.nextInt());

        LocalDateTime atual = LocalDateTime.now();
        obj.setDataEntrada(atual);

        System.out.println("Local d compra");
        obj.setLocalCompra(read.next());

        System.out.println("Tipo");
        obj.setTipo(read.next());

        System.out.println("Marca");
        obj.setMarca(read.next());

        System.out.println("Descrição");
        obj.setDescricao(read.next());

        System.out.println("Escolha uma cor entre essas opções:");
        for ( enumCor t : enumCor.values())
        {
            System.out.println(t.getCor());
        }
        String aux = read.next();
        obj.setCor(enumCor.valueOf(aux.toUpperCase()));;

        System.out.println("Escolha uma cor entre essas opções:");
        for ( enumTamanho t : enumTamanho.values())
        {
            System.out.println(t.getTamanho());
        }
        aux = read.next();
        obj.setTamanho(enumTamanho.valueOf(aux.toUpperCase()));;


        RoupaDAO dao = new RoupaDAO();
        dao.salvar(obj);

        return true;
    }
}