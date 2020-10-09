package Basis;

import DesafioCrud.Comuns.Enuns.enumEntidade;
import DesafioCrud.Comuns.Enuns.enumRepositorio;
import DesafioCrud.DAO.RoupaTextoDAO;
import DesafioCrud.DAO.UsuarioTextoDAO;

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
                retorno = null;
            case ROUPA:
                retorno = null;
            default:
                retorno = null;
        }

        return retorno;
    }

}
