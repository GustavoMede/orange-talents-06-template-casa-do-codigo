package br.com.zupacademy.gustavo.casadocodigo.repository;

import br.com.zupacademy.gustavo.casadocodigo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    Optional<Autor> findByEmail(String email);

    Autor findByNome(String nome);
}
