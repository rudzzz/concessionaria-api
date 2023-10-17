package dev.rudzzz.concessionaria.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "carro")
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Long id;

    @Column(name = "timestamp_cadastro")
    @Schema(hidden = true)
    private Long timestampCadastro;

    @JsonProperty("modelo_id")
    @Column(name = "modelo_id")
    private Long modelo_id;

    @ManyToOne
    @JoinColumn(name = "modelo_id", insertable=false, updatable=false)
    @Schema(hidden = true)
    private Modelo modelo;

    private String combustivel;
    private int ano;

    @JsonProperty("num_portas")
    @Column(name = "num_portas")
    private int numPortas;

    private String cor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    @Schema(hidden = true)
    public Long getModeloId() {
        return this.modelo_id;
    }

    public Long getTimestampCadastro() {
        return timestampCadastro;
    }

    public void setTimestampCadastro(Long timestampCadastro) {
        this.timestampCadastro = timestampCadastro;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
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
}