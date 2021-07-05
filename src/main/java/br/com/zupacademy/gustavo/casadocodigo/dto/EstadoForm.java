package br.com.zupacademy.gustavo.casadocodigo.dto;

import br.com.zupacademy.gustavo.casadocodigo.model.Estado;
import br.com.zupacademy.gustavo.casadocodigo.validator.EstadoDuplicado;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EstadoDuplicado(domainClass = Estado.class, fieldName1 = "nomeEstado", fieldName2 = "nomePais")
public class EstadoForm {

    @NotNull @NotBlank
    private String nomeEstado;
    @NotNull @NotBlank
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
