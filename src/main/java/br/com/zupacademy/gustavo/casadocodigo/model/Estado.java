package br.com.zupacademy.gustavo.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @NotBlank
    private String nomeEstado;
    @NotNull @NotBlank
    private String nomePais;

    @NotNull
    @ManyToOne
    private Pais pais;

    public Estado(){
    }

    public Estado(String nome, String nomePais, Pais pais) {
        this.nomeEstado = nome;
        this.nomePais = nomePais;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public String getNomePais() {
        return nomePais;
    }
}
