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

public class RoupaNegocio {
    //salvar - validar se id ja existe
    //salvar - validar campos vazios, valores com letras etc
    //delete - validar se existe id

    public boolean salvar (Roupa roupa){
        RoupaDAO dao = new RoupaDAO();
        boolean correto = true;

        //fazer a validacao (regra de negocio)
        correto = validaObjeto(roupa);

        if(correto){
            dao.salvar(roupa);
        }

        return correto;
    }

    private int codigoItem;

    public double valorMargem(double valorCompra){
        return valorCompra * 2;
    }

    public double ValorSugerido(double valorCompra) {
        System.out.println("Valor Sugerido - R$: " + String.format("%.2f", (valorCompra * 1.3)));
        return valorCompra * 1.3;
    }

    public boolean validaObjeto(Roupa obj)
    {
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

        if(Objects.nonNull(dao.consulta(obj.getCodigoItem()))){
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
}
