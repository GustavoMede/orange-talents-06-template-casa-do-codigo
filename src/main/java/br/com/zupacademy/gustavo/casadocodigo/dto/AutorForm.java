package br.com.zupacademy.gustavo.casadocodigo.dto;

import br.com.zupacademy.gustavo.casadocodigo.model.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AutorForm {

    @NotNull @NotBlank
    private String nome;
    @NotNull @NotBlank @Email
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

    public Autor converter(AutorForm form) {
        return new Autor(form.getNome(), form.getEmail(), form.getDescricao());
    }
}
