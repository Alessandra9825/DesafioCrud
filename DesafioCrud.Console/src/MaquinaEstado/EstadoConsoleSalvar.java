package MaquinaEstado;

import DesafioCrud.Business.RoupaNegocio;
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
            obj.setLocalCompra(read.next());

            System.out.println("Tipo:");
            obj.setTipo(read.next());

            System.out.println("Marca:");
            obj.setMarca(read.next());

            System.out.println("Descrição:");
            obj.setDescricao(read.next());

            obj.setCor(cor());
            obj.setTamanho(tamanho());

            obj.setValorCompra(valor("Informe o Valor da Compra:"));
            obj.setValorSugerido(new RoupaNegocio().ValorSugerido(obj.getValorCompra()));
            obj.setValorEtiqueta(valor("Informe o Valor da Etiqueta:"));
            obj.setValorMargem(new RoupaNegocio().valorMargem(obj.getValorCompra()));

            RoupaDAO dao = new RoupaDAO();
            reg = dao.salvar(obj);
            saida = !reg;

            if(!reg){
                System.out.println("Erro ao salvar produto!");
            }
            else{
                System.out.println("Cadastro realizado com sucesso!");
                Console.estadoConsole = enumEstadoConsole.HOME.getEstadoConsole();
            }
        }

        return saida;
    }

    private int codItem(){
        while(true){
            try{
                System.out.println("Codigo do Item:");
                return read.nextInt();
            }
            catch (Exception e){
                System.out.println("informe somente números no código!");
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
                System.out.println("Cor não conta no catálogo, digite novamente!");
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
                System.out.println("Tamanho não consta no catálogo, digite novamente!");
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
                System.out.println("Informe somente números com (,) ou (.)!");
            }
        }
    }
}