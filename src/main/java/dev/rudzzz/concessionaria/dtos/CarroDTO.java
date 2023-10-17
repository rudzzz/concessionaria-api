package dev.rudzzz.concessionaria.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.DecimalFormat;

public class CarroDTO {
    private Long id;
    @JsonProperty("timestamp_cadastro")
    private Long timestampCadastro;

    @JsonProperty("modelo_id")
    private Long modeloId;
    private int ano;
    private String combustivel;

    @JsonProperty("num_portas")
    private int numPortas;
    private String cor;
    @JsonProperty("nome_modelo")
    private String nomeModelo;
    private Double valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTimestampCadastro() {
        return timestampCadastro;
    }

    public void setTimestampCadastro(Long timestampCadastro) {
        this.timestampCadastro = timestampCadastro;
    }

    public Long getModeloId() {
        return modeloId;
    }

    public void setModeloId(Long modeloId) {
        this.modeloId = modeloId;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public int getNumPortas() {
        return numPortas;
    }

    public void setNumPortas(int numPortas) {
        this.numPortas = numPortas;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getNomeModelo() {
        return nomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    public String getValor() {
        if (valor != null) {
            DecimalFormat df = new DecimalFormat("0,000");
            return df.format(valor);
        }
        return null;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
