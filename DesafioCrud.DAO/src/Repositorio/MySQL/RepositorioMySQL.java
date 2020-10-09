package Repositorio.MySQL;

import DesafioCrud.Comuns.Basis.Entidade;
import DesafioCrud.Comuns.Enuns.enumEntidade;
import Repositorio.Repositorio;

public class RepositorioMySQL extends Repositorio {
    @Override
    public Entidade seleciona(int id, enumEntidade entidade) {
        return null;
    }

    @Override
    public Entidade localiza(String codigo, enumEntidade tipoEntidade) {
        return null;
    }
}
