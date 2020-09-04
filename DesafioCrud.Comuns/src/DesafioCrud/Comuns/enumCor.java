package DesafioCrud.Comuns;

public enum enumCor {

    AZUL("Azul"),
    VERDE("Verde"),
    AMARELO("Amarelo"),
    VERMELHO("Vermelho"),
    MARROM("Marrom"),
    ROSA("Rosa"),
    PRETO("Preto"),
    BRANCO("Branco"),
    MAGENTA("Magenta"),
    ROXO("Roxo");

    private final String cor;

    enumCor(String cor) {
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }
}
