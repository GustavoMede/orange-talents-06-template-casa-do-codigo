package br.com.zupacademy.gustavo.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank @Column(nullable = false)
    private String nome;
    @NotBlank @Email
    @Column(nullable = false)
    private String email;
    @NotBlank @Size(max = 400) @Column(length = 400)
    private String descricao;
    @NotNull @Column(updatable = false)
    private LocalDateTime dataRegistro = LocalDateTime.now();

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public Autor(){

    }

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }
}
