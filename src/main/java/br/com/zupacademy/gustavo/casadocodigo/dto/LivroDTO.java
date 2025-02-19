package br.com.zupacademy.gustavo.casadocodigo.dto;

import br.com.zupacademy.gustavo.casadocodigo.model.Autor;
import br.com.zupacademy.gustavo.casadocodigo.model.Categoria;
import br.com.zupacademy.gustavo.casadocodigo.model.Livro;
import br.com.zupacademy.gustavo.casadocodigo.validator.CampoDuplicado;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.domain.Page;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.time.LocalDate;

public class LivroDTO {

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
    private Autor autor;
    @NotNull
    private Categoria categoria;

    public LivroDTO(Livro livro){
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.paginas = livro.getPaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao();
        this.subtitulo = livro.getSubtitulo();
        this.autor = livro.getAutor();
        this.categoria = livro.getCategoria();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public static Page<LivroDTO> converter(Page<Livro> livros) {
        return livros.map(LivroDTO::new);
    }
}
