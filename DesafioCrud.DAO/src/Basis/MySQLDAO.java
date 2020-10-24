package Basis;

import DesafioCrud.Comuns.Basis.Entidade;
import DesafioCrud.Comuns.Annotations.CampoNoBanco;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;

public class MySQLDAO <E extends Entidade> extends DAO {

    private final String stringConexao = "jdbc:sqlserver://localhost:1433;databaseName=DesafioCRUD;";
    private final String usuario = "sa";
    private final String senha = "123456";
    private String tabela;

    public MySQLDAO(Class entityClass) {
        super(entityClass);
    }

    protected void setTabela(String tabela){
        this.tabela = tabela;
    }

    protected E preencheEntidade(ResultSet rs) {
        //To change body of generated methods, choose Tools | Templates.
        throw new UnsupportedOperationException("Implementar na classe filha.");
    }

    @Override
    public Entidade seleciona(int id) {
        return null;
    }

    @Override
    public Entidade localiza(String codigo) throws SQLException {
        E entidade = null;
        try(Connection conexao = DriverManager.getConnection(stringConexao, usuario, senha)){
            String SQL = getLocalizaCommand();
            try(PreparedStatement statement = conexao.prepareStatement(SQL)){
                statement.setString(1, codigo);
                try(ResultSet rs = statement.executeQuery()){
                    entidade = preencheEntidade(rs);
                }
            }
        }
        return entidade;
    }

    protected String getLocalizaCommand(){
        String campos = "";
        String chave = "";
        for(Field campo : entityClass.getDeclaredFields()) {
            if (campo.isAnnotationPresent(CampoNoBanco.class)) {
                CampoNoBanco anotacao = campo.getAnnotation(CampoNoBanco.class);
                if (anotacao.chave())
                    chave = anotacao.nome();
                campos += anotacao.nome() + ",";
            }
        }
        if(campos.length() > 0)
            campos = campos.substring(0, campos.length()-1);
        return "select " + campos + " from " + tabela + " where " + chave + " = ?";
    }

    protected String getListaCommand() {
        return "select * from " + tabela;
    }

    @Override
    public ArrayList lista() throws SQLException {
        ArrayList<E> entidades = new ArrayList();
        try (Connection conexao = DriverManager.getConnection(stringConexao, usuario, senha)) {
            System.out.println("Banco conectado!");
            // ? => binding
            String SQL = getListaCommand();
            try (PreparedStatement stmt = conexao.prepareStatement(SQL)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()){
                        E entidade = preencheEntidade(rs);
                        entidades.add(entidade);
                    }
                }
            }
        }
        return entidades;
    }

    @Override
    public boolean salvar(Entidade entidade) throws SQLException {
        try(Connection conexao = DriverManager.getConnection(stringConexao, usuario, senha)){
            String SQL = getInsertCommand(entidade);
            try(PreparedStatement stmt = getInsertStatement(entidade, conexao.prepareStatement(SQL))){
                stmt.executeQuery();
            }
        }
        return false;
    }

    protected String getInsertCommand(Entidade entidade) {
        //To change body of generated methods, choose Tools | Templates.
        throw new UnsupportedOperationException("Implementar na classe filha.");
    }

    protected PreparedStatement getInsertStatement(Entidade entidade, PreparedStatement stmt) throws SQLException {
        //To change body of generated methods, choose Tools | Templates.
        throw new UnsupportedOperationException("Implementar na classe filha.");
    }
}

