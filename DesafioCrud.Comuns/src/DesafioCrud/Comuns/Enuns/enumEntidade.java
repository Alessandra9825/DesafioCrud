package DesafioCrud.Comuns.Enuns;

public enum enumEntidade {

    USUARIO("usuario"),

    ROUPA("roupa");

    private String descricao;

    enumEntidade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
