package DesafioCrud.Business;
import DesafioCrud.Comuns.Roupa;
import DesafioCrud.DAO.RoupaDAO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RoupaNegocio {

    public void Salvar (Roupa roupa){
        RoupaDAO dao = new RoupaDAO();
        //fazer a validacao (regra de negocio)
        dao.salvar(roupa);
    }

    public double valorMargem(double valorCompra){
        return valorCompra * 2;
    }
    public double ValorSugerido(double valorCompra) {
        System.out.println("Valor Sugerido - R$: " + String.format("%.2f", (valorCompra * 1.3)));
        return valorCompra * 1.3;
    }
}
