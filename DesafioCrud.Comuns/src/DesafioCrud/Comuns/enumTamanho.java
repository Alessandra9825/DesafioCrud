package DesafioCrud.Comuns;

public enum enumTamanho {

    PP("Muito pequeno"),
    P("Pequeno"),
    M("Médio"),
    G("Grande"),
    GG("Extra Grande"),
    XG("Super Grande");

    private final String tamanho;

    enumTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return tamanho;
    }
}
