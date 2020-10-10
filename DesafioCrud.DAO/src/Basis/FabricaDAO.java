package Basis;

import DesafioCrud.Comuns.Enuns.enumEntidade;
import DesafioCrud.Comuns.Enuns.enumRepositorio;
import DesafioCrud.Comuns.vos.Roupa;
import DesafioCrud.DAO.MySQL.RoupaMySQLDAO;
import DesafioCrud.DAO.MySQL.UsuarioMySQLDAO;
import DesafioCrud.DAO.Texto.RoupaTextoDAO;
import DesafioCrud.DAO.Texto.UsuarioTextoDAO;

public class FabricaDAO {

    public static DAO fabrica(enumEntidade entidade, enumRepositorio repositorio){
        switch (repositorio){
            case TEXTO:
                return montaDAOTexto(entidade);
            case MYSQL:
                return montaDAOMySQL(entidade);
            default:
                return null;
        }
    }

    public static DAO montaDAOTexto(enumEntidade entidade){
        DAO retorno;
        switch (entidade){
            case USUARIO:
                retorno = new UsuarioTextoDAO();
                break;
            case ROUPA:
                retorno = new RoupaTextoDAO();
                break;
            default:
                retorno = null;
        }

        return retorno;
    }

    public static DAO montaDAOMySQL(enumEntidade entidade){
        DAO retorno;
        switch (entidade){
            case USUARIO:
                retorno = new UsuarioMySQLDAO();
                break;
            case ROUPA:
                retorno = new RoupaMySQLDAO();
                break;
            default:
                retorno = null;
        }

        return retorno;
    }

}
