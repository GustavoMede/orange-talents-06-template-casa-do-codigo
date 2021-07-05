package br.com.zupacademy.gustavo.casadocodigo.repository;

import br.com.zupacademy.gustavo.casadocodigo.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaisRepository extends JpaRepository<Pais, Long> {

    Pais findByNomePais(String nome);
}
