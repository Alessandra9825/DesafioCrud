package MaquinaEstado;

import DesafioCrud.Business.RoupaNegocio;
import DesafioCrud.Comuns.Enuns.enumConsoleColors;
import DesafioCrud.Comuns.vos.Roupa;
import DesafioCrud.Console.Console;

import java.time.LocalDateTime;
import java.util.Scanner;

public class EstadoConsoleSalvar extends MaquinaEstadoConsole{
    private Scanner read = new Scanner(System.in);

    @Override
    public boolean Executa() {
        boolean reg = false;
        boolean saida = false;

        Roupa obj = new Roupa();
        RoupaNegocio neg = new RoupaNegocio();
        Scanner read = new Scanner(System.in);

        while(!reg){
            System.out.println();
            System.out.println("Informe: ");
            obj.setCodigoItem(codItem());
            obj.setDataEntrada(LocalDateTime.now());

            System.out.println();
            System.out.println("Local da compra:");
            obj.setLocalCompra(read.nextLine());

            System.out.println();
            System.out.println("Tipo:");
            obj.setTipo(read.nextLine());

            System.out.println();
            System.out.println("Marca:");
            obj.setMarca(read.nextLine());

            System.out.println();
            System.out.println("Descrição:");
            obj.setDescricao(read.nextLine());

            obj.setCor(neg.cor(read));
            obj.setTamanho(neg.tamanho(read));

            System.out.println();
            obj.setValorCompra(valor("Informe o Valor da Compra:"));
            obj.setValorSugerido(neg.ValorSugerido(obj.getValorCompra()));

            System.out.println();
            obj.setValorEtiqueta(valor("Informe o Valor da Etiqueta:"));
            obj.setValorMargem(neg.valorMargem(obj.getValorCompra()));

            RoupaNegocio business = new RoupaNegocio();
            reg = business.salvar(obj);

            if(reg){
                System.out.println();
                System.out.println(enumConsoleColors.YELLOW + "Cadastro realizado com sucesso!" + enumConsoleColors.RESET);
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
                    System.out.println(enumConsoleColors.RED + "Informe somente 0 ou 1!" + enumConsoleColors.RESET);
            }
            catch (Exception e)
            {
                System.out.println(enumConsoleColors.RED + "Informe 0 (sair) ou 1 (recadastrar)!" + enumConsoleColors.RESET);
                read.nextLine();
            }
        }
    }

    private int codItem(){
        int id = -1;
        while(true){
            try{
                System.out.println();
                System.out.println("Codigo do Item:");
                id =  read.nextInt();
                read.nextLine();

                if(id <= 0)
                    System.out.println(enumConsoleColors.RED + "informe códigos maiores que 0!" + enumConsoleColors.RESET);
                else
                    return id;
            }
            catch (Exception e){
                System.out.println(enumConsoleColors.RED + "informe somente números no código!" + enumConsoleColors.RESET);
                read.nextLine();
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
                System.out.println(enumConsoleColors.RED + "Informe somente números com (,)" + enumConsoleColors.RESET);
                read.nextLine();
            }
        }
    }
}