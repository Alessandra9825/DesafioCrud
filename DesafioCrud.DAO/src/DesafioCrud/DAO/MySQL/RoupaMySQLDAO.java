package DesafioCrud.DAO.MySQL;

import Basis.MySQLDAO;
import DesafioCrud.Comuns.Basis.Entidade;
import DesafioCrud.Comuns.Enuns.enumCor;
import DesafioCrud.Comuns.Enuns.enumTamanho;
import DesafioCrud.Comuns.vos.Roupa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RoupaMySQLDAO <E extends Entidade> extends MySQLDAO {
    public RoupaMySQLDAO() {
        super(Roupa.class);
        setTabela("tbRoupa");
    }

    @Override
    protected Entidade preencheEntidade(ResultSet rs) {
        Roupa entidade = new Roupa();
        try{
            entidade.setCodigoItem(rs.getInt("codigoItem"));
            entidade.setDataEntrada(LocalDateTime.parse(rs.getString("dataEntrada")));
            entidade.setLocalCompra(rs.getString("localCompra"));
            entidade.setTipo(rs.getString("tipo"));
            entidade.setMarca(rs.getString("marca"));
            entidade.setDescricao(rs.getString("descricao"));
            entidade.setCor(enumCor.valueOf(rs.getString("cor")));
            entidade.setTamanho(enumTamanho.valueOf(rs.getString("tamanho")));
            entidade.setValorCompra(Double.parseDouble(rs.getString("valorCompra")));
            entidade.setValorSugerido(Double.parseDouble(rs.getString("valorEtiqueta")));
            entidade.setValorEtiqueta(Double.parseDouble(rs.getString("valorMargem")));
            entidade.setValorMargem(Double.parseDouble(rs.getString("valorSugerido")));
        }
        catch (SQLException ex){
            Logger.getLogger(UsuarioMySQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (E)entidade;
    }

}
