package Basis;

import DesafioCrud.Comuns.Basis.Entidade;

import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLDAO <E extends Entidade> extends DAO {
    public MySQLDAO(Class entityClass) {
        super(entityClass);
    }

    @Override
    public Entidade seleciona(int id) {
        return null;
    }

    @Override
    public Entidade localiza(String codigo) throws SQLException {
        return null;
    }

    @Override
    public ArrayList lista() throws SQLException {
        return null;
    }
}
