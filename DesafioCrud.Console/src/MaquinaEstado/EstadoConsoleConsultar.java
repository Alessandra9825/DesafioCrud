package MaquinaEstado;

import DesafioCrud.Comuns.ConsoleColors;
import DesafioCrud.Comuns.Roupa;
import DesafioCrud.Console.Console;
import DesafioCrud.DAO.RoupaDAO;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EstadoConsoleConsultar extends MaquinaEstadoConsole{
    private Scanner read = new Scanner(System.in);

    @Override
    public boolean Executa() {
        RoupaDAO dao = new RoupaDAO();
        int codigoItem;
        boolean resp = false;
        boolean saida = false;

        while(!resp)
        {
            try
            {
                System.out.println("Digite o codigo do item que deseja consultar");
                codigoItem = read.nextInt();

                if(codigoItem <= 0){
                    resp = sairConsulta();
                }
                else{
                    Roupa consultada = dao.consulta(codigoItem);

                    if(Objects.nonNull(consultada)){
                        System.out.println("Codigo: "+consultada.getCodigoItem());
                        System.out.println("Data de Entrada: "+consultada.getDataEntrada());
                        System.out.println("Local de Compra: "+consultada.getLocalCompra());
                        System.out.println("Marca: "+consultada.getMarca());
                        System.out.println("Descrição: "+consultada.getDescricao());
                        System.out.println("Tipo: "+consultada.getTipo());
                        System.out.println("Cor: "+consultada.getCor());
                        System.out.println("Tamanho: "+consultada.getTamanho());
                        System.out.println("Valor de Compra: R$ " + String.format("%.2f", consultada.getValorCompra()));
                        System.out.println("Valor Sugerido: R$ "+ String.format("%.2f", consultada.getValorSugerido()));
                        System.out.println("Valor da Etiqueta: R$ "+ String.format("%.2f", consultada.getValorEtiqueta()));
                        System.out.println("Valor (margem 100%): R$ "+ String.format("%.2f", consultada.getValorMargem()));
                        System.out.println();
                    }
                    else{
                        System.out.println(ConsoleColors.BLUE + "Produto não consta no estoque!" + ConsoleColors.RESET);
                        System.out.println();
                    }

                    resp = sairConsulta();
                }
            }
            catch (Exception err)
            {
                System.out.println(ConsoleColors.RED + "Informe somente números!" + ConsoleColors.RESET);
                read.next();
            }
        }

        Console.estadoConsole = enumEstadoConsole.HOME.getEstadoConsole();
        return saida;
    }

    private boolean sairConsulta(){
        int resp = -1;
        while (true){
            try{
                System.out.println("Deseja realizar uma nova Consulta?");
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
                System.out.println(ConsoleColors.RED + "Informe 0 (Sair) ou 1 (Consultar)!" + ConsoleColors.RESET);
                read.next();
            }
        }
    }
}
