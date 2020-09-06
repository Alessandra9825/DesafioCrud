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


}
