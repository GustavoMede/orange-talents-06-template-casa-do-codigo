package br.com.zupacademy.gustavo.casadocodigo.dto;

import br.com.zupacademy.gustavo.casadocodigo.model.Estado;
import br.com.zupacademy.gustavo.casadocodigo.validator.EstadoDuplicado;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EstadoDuplicado(domainClass = Estado.class)
public class EstadoForm {

    @NotBlank
    private String nomeEstado;
    @NotBlank
    private String nomePais;

    public EstadoForm(String nomeEstado, String nomePais) {
        this.nomeEstado = nomeEstado;
        this.nomePais = nomePais;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public String getNomePais() {
        return nomePais;
    }
}
