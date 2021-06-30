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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @NotBlank @Column(nullable = false)
    private String nome;
    @NotNull @NotBlank @Email @Column(nullable = false)
    private String email;
    @NotNull @NotBlank @Size(max = 400) @Column(length = 400)
    private String descricao;
    private LocalDateTime dataRegistro = LocalDateTime.now();

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }
}
