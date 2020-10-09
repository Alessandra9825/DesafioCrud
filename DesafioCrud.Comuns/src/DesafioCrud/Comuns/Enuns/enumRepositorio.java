package DesafioCrud.Comuns.Enuns;

public enum enumRepositorio {
    MYSQL("MySQL"),

    TEXTO("texto");

    private String descricao;

    enumRepositorio(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
