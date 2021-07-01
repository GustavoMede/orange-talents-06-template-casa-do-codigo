package br.com.zupacademy.gustavo.casadocodigo.dto;

import br.com.zupacademy.gustavo.casadocodigo.model.Categoria;
import br.com.zupacademy.gustavo.casadocodigo.validator.CampoDuplicado;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CategoriaForm {

    @NotNull @NotBlank @CampoDuplicado(message = "O nome inserido já está cadastrado")
    private String nome;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CategoriaForm(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Categoria converter(CategoriaForm form){
        return new Categoria(this.nome);
    }
}
