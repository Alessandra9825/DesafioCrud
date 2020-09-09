package MaquinaEstado;

import DesafioCrud.Business.RoupaNegocio;
import DesafioCrud.Comuns.ConsoleColors;
import DesafioCrud.Comuns.Roupa;
import DesafioCrud.Comuns.enumCor;
import DesafioCrud.Comuns.enumTamanho;
import DesafioCrud.Console.Console;
import DesafioCrud.DAO.RoupaDAO;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class EstadoConsoleConsultar extends MaquinaEstadoConsole{
    private Scanner read = new Scanner(System.in);

    @Override
    public boolean Executa() {
        int opcao = -1;
        boolean resp = false;
        boolean saida = false;

        while(!resp)
        {
            try
            {
                System.out.println();
                System.out.println("Digite a opção de consulta desejada: ");
                System.out.println("0 - Sair");
                System.out.println("1 - Consulta por ID");
                System.out.println("2 - Consulta por Cor");
                System.out.println("3 - Consulta por Tamanho");
                opcao = read.nextInt();

                switch (opcao){
                    case 0:
                        resp = true;
                        break;
                    case 1:
                        consultarID();
                        break;
                    case 2:
                        consultarCor();
                        break;
                    case 3:
                        consultaTamanho();
                        break;
                    default:
                        System.out.println();
                        System.out.println("Digite SOMENTE números entre 0 e 3");
                        read.next();
                        break;
                }
            }
            catch (Exception err)
            {
                System.out.println();
                System.out.println(ConsoleColors.RED + "Informe somente números!" + ConsoleColors.RESET);
                read.next();
            }
        }

        Console.estadoConsole = enumEstadoConsole.HOME.getEstadoConsole();
        return saida;
    }

    private void mostraObjeto(Roupa obj){
        System.out.println();
        System.out.println("Codigo: "+ obj.getCodigoItem());
        System.out.println("Data de Entrada: " + obj.getDataEntrada());
        System.out.println("Local de Compra: "+ obj.getLocalCompra());
        System.out.println("Marca: "+ obj.getMarca());
        System.out.println("Descrição: "+ obj.getDescricao());
        System.out.println("Tipo: "+ obj.getTipo());
        System.out.println("Cor: "+ obj.getCor());
        System.out.println("Tamanho: "+ obj.getTamanho());
        System.out.println("Valor de Compra: R$ " + String.format("%.2f", obj.getValorCompra()));
        System.out.println("Valor Sugerido: R$ "+ String.format("%.2f", obj.getValorSugerido()));
        System.out.println("Valor da Etiqueta: R$ "+ String.format("%.2f", obj.getValorEtiqueta()));
        System.out.println("Valor (margem 100%): R$ "+ String.format("%.2f", obj.getValorMargem()));
        System.out.println();
    }

    private void consultarID(){
        RoupaNegocio neg = new RoupaNegocio();
        Roupa obj = new Roupa();
        int codigoItem;
        boolean resp = false;
        while(!resp)
        {
            try
            {
                System.out.println();
                System.out.println("Digite o codigo do item que deseja consultar");
                codigoItem = read.nextInt();

                if(codigoItem <= 0){
                    System.out.println();
                    System.out.println(ConsoleColors.RED + "Nenhum id é menor ou igual a zero!" + ConsoleColors.RESET);
                    resp = sairConsulta();
                }
                else{
                    obj = neg.consultaID(codigoItem);
                }

                if(Objects.nonNull(obj)){
                    mostraObjeto(obj);
                }
                else{
                    System.out.println();
                    System.out.println(ConsoleColors.BLUE + "Nenhum produto encontrado!" + ConsoleColors.RESET);
                }

                resp = sairConsulta();
            }
            catch (Exception err)
            {
                System.out.println();
                System.out.println(ConsoleColors.RED + "Informe somente números!" + ConsoleColors.RESET);
                read.next();
            }
        }
    }

    private void consultarCor(){
        RoupaNegocio neg = new RoupaNegocio();
        ArrayList<Roupa> lista = new ArrayList<Roupa>();
        enumCor cor = null;
        boolean resp = false;
        while(!resp)
        {
            try
            {
                cor = neg.cor(read);
                if(Objects.isNull(cor)){
                    //Ja possui um tratamento no metodo;
                    resp = sairConsulta();
                }
                else{
                   lista = neg.consultaCor(cor);
                    if(!lista.isEmpty()){
                        System.out.println();
                        System.out.println(ConsoleColors.BLUE + "\tRoupas da cor: " + cor.getCor() + ConsoleColors.RESET);
                        for(Roupa obj : lista){
                            mostraObjeto(obj);
                        }
                    }
                    else{
                        System.out.println();
                        System.out.println(ConsoleColors.BLUE + "Nenhuma referência encontrada no estoque!" + ConsoleColors.RESET);
                    }
                    resp = sairConsulta();
                }
            }
            catch (Exception err)
            {
                System.out.println();
                System.out.println(ConsoleColors.RED + "Informe somente números!" + ConsoleColors.RESET);
                read.next();
            }
        }
    }

    private void consultaTamanho(){
        RoupaNegocio neg = new RoupaNegocio();
        ArrayList<Roupa> lista = new ArrayList<Roupa>();
        enumTamanho tamanho = null;
        boolean resp = false;
        while(!resp)
        {
            try
            {
                tamanho = neg.tamanho(read);
                if(Objects.isNull(tamanho)){
                    //Ja possui um tratamento no metodo;
                    resp = sairConsulta();
                }
                else{
                   lista = neg.consultaTamanho(tamanho);
                    if(!lista.isEmpty()){
                        System.out.println();
                        System.out.println(ConsoleColors.BLUE + "\tRoupas do tamanho: " + tamanho.getTamanho() + ConsoleColors.RESET);
                        for(Roupa obj : lista){
                            mostraObjeto(obj);
                        }
                    }
                    else{
                        System.out.println();
                        System.out.println(ConsoleColors.BLUE + "Nenhuma referência encontrada no estoque!" + ConsoleColors.RESET);
                    }
                    resp = sairConsulta();
                }
            }
            catch (Exception err)
            {
                System.out.println();
                System.out.println(ConsoleColors.RED + "Informe somente números!" + ConsoleColors.RESET);
                read.next();
            }
        }
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
