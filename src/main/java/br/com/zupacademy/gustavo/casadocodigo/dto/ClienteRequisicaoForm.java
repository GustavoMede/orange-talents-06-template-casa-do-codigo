package br.com.zupacademy.gustavo.casadocodigo.dto;

import br.com.zupacademy.gustavo.casadocodigo.interfaces.Documento;
import br.com.zupacademy.gustavo.casadocodigo.model.Cliente;
import br.com.zupacademy.gustavo.casadocodigo.model.Estado;
import br.com.zupacademy.gustavo.casadocodigo.model.Pais;
import br.com.zupacademy.gustavo.casadocodigo.validator.CampoDuplicado;
import br.com.zupacademy.gustavo.casadocodigo.validator.PossuiEstados;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@PossuiEstados(domainClass = Estado.class)
public class ClienteRequisicaoForm {

    @NotBlank
    @Email
    @CampoDuplicado(domainClass = Cliente.class, fieldName = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @Enumerated(EnumType.STRING)
    private Documento documento;
    @CPF
    private String cpf;
    @CNPJ
    private String cnpj;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotBlank
    private String nomePais;
    private String nomeEstado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public ClienteRequisicaoForm(){
    }

    public ClienteRequisicaoForm(String email, String nome, String sobrenome, Documento documento,
                                 String cpf, String cnpj, String endereco, String complemento,
                                 String cidade, String nomePais, String nomeEstado, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.nomePais = nomePais;
        this.nomeEstado = nomeEstado;
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

    public Documento getDocumento() {
        return documento;
    }

    public String getCpf() {
        return cpf;
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

    public String getNomePais() {
        return nomePais;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}
