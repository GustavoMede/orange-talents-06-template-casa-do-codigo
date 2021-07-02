package br.com.zupacademy.gustavo.casadocodigo.dto;

import br.com.zupacademy.gustavo.casadocodigo.model.Livro;
import org.springframework.data.domain.Page;

public class DetalhesLivro {

    private Long id;
    private String nome;

    public DetalhesLivro(Livro livro) {
        this.id = livro.getId();
        this.nome = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public static Page<DetalhesLivro> converter(Page<Livro> livros) {
        return livros.map(DetalhesLivro::new);
    }
}
