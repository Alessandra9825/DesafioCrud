package Repositorio;

import DesafioCrud.Comuns.Basis.Entidade;
import DesafioCrud.Comuns.Enuns.enumEntidade;

public abstract class Repositorio {
    public abstract Entidade seleciona(int id, enumEntidade entidade);
    public abstract Entidade localiza(String codigo, enumEntidade tipoEntidade);
}
