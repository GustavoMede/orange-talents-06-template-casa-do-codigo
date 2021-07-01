package br.com.zupacademy.gustavo.casadocodigo.dto;

import br.com.zupacademy.gustavo.casadocodigo.model.Autor;
import br.com.zupacademy.gustavo.casadocodigo.validator.CampoDuplicado;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AutorForm {

    @NotNull @NotBlank
    private String nome;
    @NotNull @NotBlank @Email @CampoDuplicado(message="O email informado já foi cadastrado.")
    private String email;
    @NotNull @NotBlank @Size(max = 400)
    private String descricao;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public AutorForm(String nome, String email, String descricao){
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor converter(AutorForm form) {
        return new Autor(this.nome, this.email, this.descricao);
    }
}
