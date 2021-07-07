package br.com.zupacademy.gustavo.casadocodigo.repository;

import br.com.zupacademy.gustavo.casadocodigo.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

    Estado findByNomePaisAndNomeEstado(String nomePais, String nomeEstado);
    Estado findByNomePais(String nomePais);
    Optional<Estado> findByNomeEstadoAndNomePais(String nomeEstado, String nomePais);
}
