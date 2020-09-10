package DesafioCrud.Business;
import DesafioCrud.Comuns.ConsoleColors;
import DesafioCrud.Comuns.Roupa;
import DesafioCrud.Comuns.enumCor;
import DesafioCrud.Comuns.enumTamanho;
import DesafioCrud.DAO.RoupaDAO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class RoupaNegocio {
    public boolean salvar (Roupa roupa){
        RoupaDAO dao = new RoupaDAO();
        boolean correto = true;

        correto = validaObjeto(roupa, true);

        if(correto){
            dao.salvar(roupa);
        }

        return correto;
    }

    public boolean delete(int id){
        RoupaDAO dao = new RoupaDAO();
        boolean resp = false;

        Roupa consultada = dao.consulta(id);

        if(consultada != null)
            resp = dao.delete(consultada);

        if(resp){
            System.out.println(ConsoleColors.YELLOW + "Produto excluido com sucesso!" + ConsoleColors.RESET);
            return true;
        }else{
            System.out.println("Produto não consta no Estoque!");
            return false;
        }
    }

    public boolean alterar (Roupa object){
        RoupaDAO dao = new RoupaDAO();
        boolean obj = validaObjeto(object, false);

        if(obj){
            dao.alterar(object);
            return true;
        }
        else{
            return false;
        }
    }

    public Roupa consultaID(int codigoItem) {
        RoupaDAO dao = new RoupaDAO();

        Roupa consultada = dao.consulta(codigoItem);
        if(Objects.nonNull(consultada)){
            System.out.println();
            System.out.println(ConsoleColors.BLUE + "\tRoupas Cadastradas" + ConsoleColors.RESET);
            return consultada;
        }
        else{
            System.out.println(ConsoleColors.BLUE + "Produto não consta no estoque!" + ConsoleColors.RESET);
            System.out.println();
            return null;
        }
    }

    public ArrayList<Roupa> consultaCor(enumCor cor) {
        RoupaDAO dao = new RoupaDAO();
        ArrayList<Roupa> consulta = dao.consultaCor(cor);
        return consulta;
    }

    public ArrayList<Roupa> consultaTamanho(enumTamanho tamanho){
        RoupaDAO dao = new RoupaDAO();
        ArrayList<Roupa> consulta = dao.consultaTamanho(tamanho);
        return consulta;
    }

    public double valorMargem(double valorCompra){
        return valorCompra * 2;
    }

    public double ValorSugerido(double valorCompra) {
        System.out.println("Valor Sugerido - R$: " + String.format("%.2f", (valorCompra * 1.3)));
        return valorCompra * 1.3;
    }

    public boolean validaObjeto(Roupa obj, boolean salvar){
        RoupaDAO dao = new RoupaDAO();
        List<String> erros = new ArrayList<String>();

        if(obj.getLocalCompra().isEmpty()){
            erros.add("Local da Compra não informado!");
        }

        if(obj.getTipo().isEmpty()){
            erros.add("Tipo não informado!");
        }

        if(obj.getMarca().isEmpty()){
            erros.add("Marca não informada!");
        }

        if(obj.getDescricao().isEmpty()){
            erros.add("Descrição está em branco, informe uam descrição!");
        }

        if(salvar && Objects.nonNull(dao.consulta(obj.getCodigoItem()))){
            erros.add("Produto com ID existente!");
        }

        if(erros.size() > 0){
            System.out.println();
            System.out.println(ConsoleColors.RED + "Erros ao cadastrar novo produto!" + ConsoleColors.RESET);
            for(String e : erros){
                System.out.println(e);
            }
            System.out.println();
            return false;
        }
        else
            return true;
    }

    public enumCor cor(Scanner read){
        while(true){
            try{
                System.out.println();
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

    public enumTamanho tamanho(Scanner read){
        while(true){
            try{
                System.out.println();
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
}
