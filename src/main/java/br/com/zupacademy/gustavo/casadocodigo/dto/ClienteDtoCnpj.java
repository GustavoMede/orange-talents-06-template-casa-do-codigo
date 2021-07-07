package br.com.zupacademy.gustavo.casadocodigo.dto;

import br.com.zupacademy.gustavo.casadocodigo.model.Cliente;
import br.com.zupacademy.gustavo.casadocodigo.model.Estado;
import br.com.zupacademy.gustavo.casadocodigo.model.Pais;
import br.com.zupacademy.gustavo.casadocodigo.validator.CampoDuplicado;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class ClienteDtoCnpj{

    @NotBlank
    @Email
    @CampoDuplicado(domainClass = Cliente.class, fieldName = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @CNPJ @CampoDuplicado(domainClass = Cliente.class, fieldName = "cnpj")
    private String cnpj;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    private Pais pais;
    private Estado estado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public ClienteDtoCnpj(String email, String nome, String sobrenome, String cnpj, String endereco,
                          String complemento, String cidade, Pais pais, Estado estado, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public ClienteDtoCnpj(String email, String nome, String sobrenome, String cnpj, String endereco,
                          String complemento, String cidade, Pais pais, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}