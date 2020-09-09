package MaquinaEstado;

import DesafioCrud.Business.RoupaNegocio;
import DesafioCrud.Comuns.ConsoleColors;
import DesafioCrud.Comuns.Roupa;
import DesafioCrud.Comuns.enumCor;
import DesafioCrud.Comuns.enumTamanho;
import DesafioCrud.Console.Console;
import DesafioCrud.DAO.RoupaDAO;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class EstadoConsoleSalvar extends MaquinaEstadoConsole{
    private Scanner read = new Scanner(System.in);

    @Override
    public boolean Executa() {
        boolean reg = false;
        boolean saida = false;

        Roupa obj = new Roupa();
        Scanner read = new Scanner(System.in);

        while(!reg){
            System.out.println("Informe: ");
            obj.setCodigoItem(codItem());
            obj.setDataEntrada(LocalDateTime.now());

            System.out.println("Local da compra:");
            obj.setLocalCompra(read.nextLine());

            System.out.println("Tipo:");
            obj.setTipo(read.nextLine());

            System.out.println("Marca:");
            obj.setMarca(read.nextLine());

            System.out.println("Descrição:");
            obj.setDescricao(read.nextLine());

            obj.setCor(cor());
            obj.setTamanho(tamanho());

            obj.setValorCompra(valor("Informe o Valor da Compra:"));
            obj.setValorSugerido(new RoupaNegocio().ValorSugerido(obj.getValorCompra()));
            obj.setValorEtiqueta(valor("Informe o Valor da Etiqueta:"));
            obj.setValorMargem(new RoupaNegocio().valorMargem(obj.getValorCompra()));

            RoupaNegocio business = new RoupaNegocio();
            reg = business.salvar(obj);

            if(reg){
                System.out.println(ConsoleColors.YELLOW + "Cadastro realizado com sucesso!" + ConsoleColors.RESET);
            }
            else
            {
                reg = !recadastrar();
            }

            saida = !reg;
        }

        Console.estadoConsole = enumEstadoConsole.HOME.getEstadoConsole();
        return saida;
    }

    private boolean recadastrar(){
        int resp = -1;
        while (true){
            try{
                System.out.println("Deseja Reiniciar o Cadastro?");
                System.out.println("0 - Não");
                System.out.println("1 - Sim");
                resp = read.nextInt();

                if(resp == 0)
                    return false;
                else if (resp == 1)
                    return true;
                else
                    System.out.println(ConsoleColors.RED + "Informe somente 0 ou 1!" + ConsoleColors.RESET);
            }
            catch (Exception e)
            {
                System.out.println(ConsoleColors.RED + "Informe 0 (sair) ou 1 (recadastrar)!" + ConsoleColors.RESET);
                read.next();
            }
        }
    }

    private int codItem(){
        while(true){
            try{
                System.out.println("Codigo do Item:");
                return read.nextInt();
            }
            catch (Exception e){
                System.out.println(ConsoleColors.RED + "informe somente números no código!" + ConsoleColors.RESET);
                read.next();
            }
        }
    }

    private enumCor cor(){
        while(true){
            try{
                System.out.println("Escolha uma cor entre essas opções:");
                for ( enumCor t : enumCor.values())
                {
                    System.out.println(t.getCor());
                }
                return enumCor.valueOf(read.next().toUpperCase());
            }
            catch (Exception e){
                System.out.println(ConsoleColors.RED + "Cor não conta no catálogo, digite novamente!" + ConsoleColors.RESET);
            }
        }
    }
    private enumTamanho tamanho(){
        while(true){
            try{
                System.out.println("Escolha uma cor entre essas opções:");
                for ( enumTamanho t : enumTamanho.values())
                {
                    System.out.println(t.getTamanho());
                }
                return enumTamanho.valueOf(read.next().toUpperCase());
            }
            catch (Exception e){
                System.out.println(ConsoleColors.RED + "Tamanho não consta no catálogo, digite novamente!" + ConsoleColors.RESET);
            }
        }
    }

    private double valor(String enunciado){
        while(true){
            try{
                System.out.println(enunciado);
                System.out.print("R$ ");
                return read.nextDouble();
            }
            catch (Exception e){
                System.out.println(ConsoleColors.RED + "Informe somente números com (,)" + ConsoleColors.RESET);
                read.next();
            }
        }
    }
}