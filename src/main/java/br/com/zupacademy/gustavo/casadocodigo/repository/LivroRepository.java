package br.com.zupacademy.gustavo.casadocodigo.repository;

import br.com.zupacademy.gustavo.casadocodigo.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
