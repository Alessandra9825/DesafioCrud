package DesafioCrud.Business;
import DesafioCrud.Comuns.Enuns.enumConsoleColors;
import DesafioCrud.Comuns.vos.Roupa;
import DesafioCrud.Comuns.Enuns.enumCor;
import DesafioCrud.Comuns.Enuns.enumTamanho;
import DesafioCrud.DAO.RoupaTextoDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class RoupaNegocio {
    public boolean salvar (Roupa roupa){
        RoupaTextoDAO dao = new RoupaTextoDAO();
        boolean correto = true;

        correto = validaObjeto(roupa, true);

        if(correto){
            dao.salvar(roupa);
        }

        return correto;
    }

    public boolean delete(int id){
        RoupaTextoDAO dao = new RoupaTextoDAO();
        boolean resp = false;

        Roupa consultada = (Roupa)dao.seleciona(id);

        if(consultada != null)
            resp = dao.delete(consultada);

        if(resp){
            System.out.println(enumConsoleColors.YELLOW + "Produto excluido com sucesso!" + enumConsoleColors.RESET);
            return true;
        }else{
            System.out.println("Produto não consta no Estoque!");
            return false;
        }
    }

    public boolean alterar (Roupa object){
        RoupaTextoDAO dao = new RoupaTextoDAO();
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
        RoupaTextoDAO dao = new RoupaTextoDAO();

        Roupa consultada = (Roupa)dao.seleciona(codigoItem);
        if(Objects.nonNull(consultada)){
            System.out.println();
            System.out.println(enumConsoleColors.BLUE + "\tRoupas Cadastradas" + enumConsoleColors.RESET);
            return consultada;
        }
        else{
            System.out.println(enumConsoleColors.BLUE + "Produto não consta no estoque!" + enumConsoleColors.RESET);
            System.out.println();
            return null;
        }
    }

    public ArrayList<Roupa> consultaCor(enumCor cor) throws SQLException {
        RoupaTextoDAO dao = new RoupaTextoDAO();
        ArrayList<Roupa> consulta = dao.consultaCor(cor);
        return consulta;
    }

    public ArrayList<Roupa> consultaTamanho(enumTamanho tamanho) throws SQLException {
        RoupaTextoDAO dao = new RoupaTextoDAO();
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
        RoupaTextoDAO dao = new RoupaTextoDAO();
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

        if(salvar && Objects.nonNull((dao.seleciona(obj.getCodigoItem())))){
            erros.add("Produto com ID existente!");
        }

        if(erros.size() > 0){
            System.out.println();
            System.out.println(enumConsoleColors.RED + "Erros!" + enumConsoleColors.RESET);
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
                System.out.println(enumConsoleColors.RED + "Cor não conta no catálogo, digite novamente!" + enumConsoleColors.RESET);
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
                System.out.println(enumConsoleColors.RED + "Tamanho não consta no catálogo, digite novamente!" + enumConsoleColors.RESET);
            }
        }
    }
}
