package DesafioCrud.Comuns;

public enum enumTamanho {

    PP( "PP"),
    P("P"),
    M("M"),
    G("G"),
    GG("GG"),
    XG("XG");

    private final String tamanho;

    enumTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getTamanho() {
        return tamanho;
    }
}
