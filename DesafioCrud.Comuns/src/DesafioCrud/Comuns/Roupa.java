package DesafioCrud.Comuns;

import java.time.LocalDateTime;
import java.util.Date;

public class Roupa {
    private int codigoItem;
    private LocalDateTime dataEntrada;
    private String localCompra;
    private String tipo;
    private String marca;
    private String descricao;
    private enumCor cor;
    private enumTamanho tamanho;

    public int getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(int codigoItem) {
        this.codigoItem = codigoItem;
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getLocalCompra() {
        return localCompra;
    }

    public void setLocalCompra(String localCompra) {
        this.localCompra = localCompra;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public enumTamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(enumTamanho tamanho) {
        this.tamanho = tamanho;
    }

    public enumCor getCor() {
        return cor;
    }

    public void setCor(enumCor cor) {
        this.cor = cor;
    }
}
