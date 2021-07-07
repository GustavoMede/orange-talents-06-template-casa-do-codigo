package br.com.zupacademy.gustavo.casadocodigo.repository;

import br.com.zupacademy.gustavo.casadocodigo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
