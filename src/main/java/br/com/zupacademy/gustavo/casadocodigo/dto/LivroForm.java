package br.com.zupacademy.gustavo.casadocodigo.dto;

import br.com.zupacademy.gustavo.casadocodigo.model.Livro;
import br.com.zupacademy.gustavo.casadocodigo.validator.CampoDuplicado;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.time.LocalDate;

public class LivroForm {

    private Long id;
    @NotBlank
    @CampoDuplicado(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;
    @NotBlank
    private String subtitulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    private String sumario;
    @NotNull
    @Min(20)
    private Double preco;
    @Min(100)
    private Integer paginas;
    @NotBlank
    @CampoDuplicado(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;
    @Future
    @JsonFormat(pattern = "yyyy/MM/dd", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;
    @NotNull
    private String nomeAutor;
    @NotNull
    private String nomeCategoria;

    public LivroForm(Long id, String titulo, String resumo, String sumario, Double preco, Integer paginas,
                     String isbn, LocalDate dataPublicacao, String nomeAutor, String nomeCategoria,
                     String subtitulo) {
        this.id = id;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.nomeAutor = nomeAutor;
        this.nomeCategoria = nomeCategoria;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
}
