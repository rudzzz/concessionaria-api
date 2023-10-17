package dev.rudzzz.concessionaria.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "modelo")
@JsonIgnoreProperties({"marca"})
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Long id;

    @JsonProperty("marca_id")
    @Column(name = "marca_id")
    private Long marcaId;

    @ManyToOne()
    @JoinColumn(name = "marca_id", insertable = false, updatable = false)
    private Marca marca;

    private String nome;

    @Column(name = "valor_fipe")
    @JsonProperty("valor_fipe")
    private double valorFipe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMarca() {
        return marcaId;
    }

    public void setMarca(Long marcaId) {
        this.marcaId = marcaId;
    }

    public Long getMarcaId() {
        return this.marcaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorFipe() {
        return valorFipe;
    }

    public void setValorFipe(double valorFipe) {
        this.valorFipe = valorFipe;
    }
}
