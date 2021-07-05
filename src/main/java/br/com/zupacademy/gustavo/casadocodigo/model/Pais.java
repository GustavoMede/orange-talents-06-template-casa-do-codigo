package br.com.zupacademy.gustavo.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull @NotBlank
    private String nomePais;

    public Pais(){
    }

    public Pais(String nome) {
        this.nomePais = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNomePais() {
        return nomePais;
    }
}
