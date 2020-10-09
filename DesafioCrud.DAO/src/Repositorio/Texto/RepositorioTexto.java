package Repositorio.Texto;

import Basis.DAO;
import Basis.FabricaDAO;
import DesafioCrud.Comuns.Basis.Entidade;
import DesafioCrud.Comuns.Enuns.enumEntidade;
import DesafioCrud.Comuns.Enuns.enumRepositorio;
import Repositorio.MySQL.RepositorioMySQL;
import Repositorio.Repositorio;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RepositorioTexto extends Repositorio {
    @Override
    public Entidade seleciona(int id, enumEntidade tipoEntidade) {
        DAO dao = FabricaDAO.fabrica(tipoEntidade, enumRepositorio.TEXTO);
        Entidade entidade = dao.seleciona(id);
        return entidade;
    }

    @Override
    public Entidade localiza(String codigo, enumEntidade tipoEntidade) {
        DAO dao = FabricaDAO.fabrica(tipoEntidade, enumRepositorio.TEXTO);
        Entidade entidade = null;
        try{
            entidade = dao.localiza(codigo);
        } catch (SQLException e){
            Logger.getLogger(RepositorioMySQL.class.getName()).log(Level.SEVERE, null, e);
        }

        return entidade;
    }
}
