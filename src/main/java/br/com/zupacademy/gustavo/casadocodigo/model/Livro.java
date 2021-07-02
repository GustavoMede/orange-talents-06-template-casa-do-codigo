package br.com.zupacademy.gustavo.casadocodigo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;


@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull @NotBlank
    private String titulo;
    @NotNull @NotBlank
    private String subtitulo;
    @NotNull @NotBlank @Size(max = 500)
    private String resumo;
    private String sumario;
    @NotNull @Min(20)
    private Double preco;
    @Min(100)
    private Integer paginas;
    @NotNull @NotBlank
    private String isbn;
    @Future
    @JsonFormat(pattern = "yyyy/MM/dd", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull
    @ManyToOne
    private Autor autor;
    @NotNull
    @ManyToOne
    private Categoria categoria;

    public Livro(String titulo, String resumo, String sumario, Double preco, Integer paginas,
                 String isbn, LocalDate dataPublicacao, String subtitulo, Autor autor, Categoria categoria) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.autor = autor;
        this.categoria = categoria;
    }

    public Livro(){
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
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

    public Autor getAutor() {
        return autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
