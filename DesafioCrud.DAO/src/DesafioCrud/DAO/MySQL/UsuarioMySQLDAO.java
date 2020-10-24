package DesafioCrud.DAO.MySQL;

import Basis.MySQLDAO;
import DesafioCrud.Comuns.Basis.Entidade;
import DesafioCrud.Comuns.vos.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioMySQLDAO <E extends Entidade> extends MySQLDAO {
    public UsuarioMySQLDAO() {
        super(Usuario.class);
        setTabela("tbUsuario");
    }

    @Override
    protected Entidade preencheEntidade(ResultSet rs) {
        Usuario entidade = new Usuario();
        try{
            while(rs.next()){
                entidade.setLogin(rs.getString("Login"));
                entidade.setSenha(rs.getString("Senha"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioMySQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (E)entidade;
    }

    @Override
    public Entidade seleciona(int id) {
        return null;
    }
}
