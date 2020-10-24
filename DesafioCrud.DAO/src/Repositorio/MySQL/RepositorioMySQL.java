package Repositorio.MySQL;

import Basis.DAO;
import Basis.FabricaDAO;
import DesafioCrud.Comuns.Basis.Entidade;
import DesafioCrud.Comuns.Enuns.enumEntidade;
import DesafioCrud.Comuns.Enuns.enumRepositorio;
import Repositorio.Repositorio;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RepositorioMySQL extends Repositorio {
    @Override
    public Entidade seleciona(int id, enumEntidade tipoEntidade) {
        DAO dao = FabricaDAO.fabrica(tipoEntidade, enumRepositorio.MYSQL);
        Entidade entidade = dao.seleciona(id);
        return entidade;
    }

    @Override
    public Entidade localiza(String codigo, enumEntidade tipoEntidade) {
        DAO dao = FabricaDAO.fabrica(tipoEntidade, enumRepositorio.MYSQL);
        Entidade entidade = null;
        try{
            entidade = dao.localiza(codigo);
        } catch (SQLException e){
            Logger.getLogger(RepositorioMySQL.class.getName()).log(Level.SEVERE, null, e);
        }

        return entidade;
    }

    @Override
    public boolean salvar(Entidade entidade, enumEntidade tipoEntidade)  {
        DAO dao = FabricaDAO.fabrica(tipoEntidade, enumRepositorio.MYSQL);
        boolean salvado = false;

        try {
            salvado = dao.salvar(entidade);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return salvado;
    }
}
