package MaquinaEstado;

import DesafioCrud.Comuns.Roupa;
import DesafioCrud.Comuns.enumCor;
import DesafioCrud.Comuns.enumTamanho;
import DesafioCrud.DAO.RoupaDAO;
import java.util.Scanner;

public class EstadoConsoleAtualizar extends MaquinaEstadoConsole {
    @Override
    public boolean Executa() {
        RoupaDAO dao = new RoupaDAO();
        Scanner read = new Scanner(System.in);
        int codigoItem;

        System.out.println("Digite o codigo do item a ser alterado: ");
        codigoItem = read.nextInt();

        Roupa consultada = dao.consulta(codigoItem);

        System.out.println("O que deseja alterar?");

        System.out.println("1- Local da compra");
        System.out.println("2- Tipo");
        System.out.println("3- Marca");
        System.out.println("4- Descrição");
        System.out.println("5- Cor");
        System.out.println("6- Tamanho");

        int opcao = read.nextInt();
        String aux;

        switch (opcao)
        {
            case 1:
                System.out.println("Local d compra");
                consultada.setLocalCompra(read.next());
                break;
            case 2:
                System.out.println("Tipo");
                consultada.setTipo(read.next());
                break;
            case 3:
                System.out.println("Marca");
                consultada.setMarca(read.next());
                break;
            case 4 :
                System.out.println("Descrição");
                consultada.setDescricao(read.next());
                break;
            case 5 :
                System.out.println("Escolha uma cor entre essas opções:");
                for ( enumCor t : enumCor.values())
                {
                    System.out.println(t.getCor());
                }
                aux = read.next();
                consultada.setCor(enumCor.valueOf(aux.toUpperCase()));
                break;
            case 6:
                System.out.println("Escolha uma cor entre essas opções:");
                for ( enumTamanho t : enumTamanho.values())
                {
                    System.out.println(t.getTamanho());
                }
                aux = read.next();
                consultada.setTamanho(enumTamanho.valueOf(aux.toUpperCase()));
                break;
            default:
                System.out.println("A opção selecionada não existe");

        }
       System.out.println( dao.alterar(consultada));

        return true;
    }
}
