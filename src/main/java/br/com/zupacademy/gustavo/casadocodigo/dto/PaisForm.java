package br.com.zupacademy.gustavo.casadocodigo.dto;

import br.com.zupacademy.gustavo.casadocodigo.model.Pais;
import br.com.zupacademy.gustavo.casadocodigo.validator.CampoDuplicado;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;

public class PaisForm {

    @NotBlank @CampoDuplicado(domainClass = Pais.class, fieldName = "nomePais")
    private String nomePais;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public PaisForm(String nome) {
        this.nomePais = nome;
    }

    public String getNomePais() {
        return nomePais;
    }
}
