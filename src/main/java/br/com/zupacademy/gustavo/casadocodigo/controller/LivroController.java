package br.com.zupacademy.gustavo.casadocodigo.controller;

import br.com.zupacademy.gustavo.casadocodigo.dto.DetalhesLivro;
import br.com.zupacademy.gustavo.casadocodigo.dto.LivroForm;
import br.com.zupacademy.gustavo.casadocodigo.model.Autor;
import br.com.zupacademy.gustavo.casadocodigo.model.Categoria;
import br.com.zupacademy.gustavo.casadocodigo.model.Livro;
import br.com.zupacademy.gustavo.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.gustavo.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.gustavo.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<?> cadastro(@RequestBody @Valid LivroForm form){
        Autor autor = autorRepository.findByNome(form.getNomeAutor());
        Categoria categoria = categoriaRepository.findByNome(form.getNomeCategoria());

        Livro livro = new Livro(form.getTitulo(), form.getResumo(), form.getSumario(), form.getPreco(),
                form.getPaginas(), form.getIsbn(), form.getDataPublicacao(), autor, categoria);

        livroRepository.save(livro);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/lista")
    public Page<DetalhesLivro> listaLivros(@PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 10)Pageable paginacao){

        Page<Livro> livros = livroRepository.findAll(paginacao);

        return DetalhesLivro.converter(livros);
    }
}
