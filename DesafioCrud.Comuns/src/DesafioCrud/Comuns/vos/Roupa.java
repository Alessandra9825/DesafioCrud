package DesafioCrud.Comuns.vos;

import DesafioCrud.Comuns.Annotations.CampoNoBanco;
import DesafioCrud.Comuns.Basis.Entidade;
import DesafioCrud.Comuns.Enuns.enumCor;
import DesafioCrud.Comuns.Enuns.enumTamanho;

import java.time.LocalDateTime;

public class Roupa extends Entidade {

    @CampoNoBanco(nome = "codigoItem", chave = true)
    private int codigoItem;

    @CampoNoBanco(nome = "dataEntrada", chave = false)
    private LocalDateTime dataEntrada;

    @CampoNoBanco(nome = "localCompra", chave = false)
    private String localCompra;

    @CampoNoBanco(nome = "tipo", chave = false)
    private String tipo;

    @CampoNoBanco(nome = "marca", chave = false)
    private String marca;

    @CampoNoBanco(nome = "descricao", chave = false)
    private String descricao;

    @CampoNoBanco(nome = "cor", chave = false)
    private enumCor cor;

    @CampoNoBanco(nome = "tamanho", chave = false)
    private enumTamanho tamanho;

    @CampoNoBanco(nome = "valorCompra", chave = false)
    private double valorCompra;

    @CampoNoBanco(nome = "valorEtiqueta", chave = false)
    private double valorEtiqueta;

    @CampoNoBanco(nome = "valorMargem", chave = false)
    private double valorMargem;

    @CampoNoBanco(nome = "valorSugerido", chave = false)
    private double valorSugerido;


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

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double getValorEtiqueta() {
        return valorEtiqueta;
    }

    public void setValorEtiqueta(double valorEtiqueta) {
        this.valorEtiqueta = valorEtiqueta;
    }

    public double getValorMargem() {
        return valorMargem;
    }

    public void setValorMargem(double valorMargem) {
        this.valorMargem = valorMargem;
    }

    public double getValorSugerido() {
        return valorSugerido;
    }

    public void setValorSugerido(double valorSugerido) {
        this.valorSugerido = valorSugerido;
    }
}
