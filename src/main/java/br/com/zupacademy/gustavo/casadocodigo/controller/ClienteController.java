package br.com.zupacademy.gustavo.casadocodigo.controller;

import br.com.zupacademy.gustavo.casadocodigo.dto.ClienteRequisicao;
import br.com.zupacademy.gustavo.casadocodigo.interfaces.Documento;
import br.com.zupacademy.gustavo.casadocodigo.model.Cliente;
import br.com.zupacademy.gustavo.casadocodigo.model.Estado;
import br.com.zupacademy.gustavo.casadocodigo.model.Pais;
import br.com.zupacademy.gustavo.casadocodigo.repository.ClienteRepository;
import br.com.zupacademy.gustavo.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.gustavo.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PaisRepository paisRepository;
    @Autowired
    private EstadoRepository estadoRepository;

    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody @Valid ClienteRequisicao request) {
        Documento documentoEscolhido = request.getDocumento();
        if (documentoEscolhido == Documento.CPF) {
            Pais pais = paisRepository.findByNomePais(request.getNomePais());
            Estado estado = estadoRepository.findByNomePaisAndNomeEstado(request.getNomePais(), request.getNomeEstado());

            Cliente cliente = new Cliente(request.getEmail(), request.getNome(),
                    request.getSobrenome(), request.getCpf(), request.getEndereco(),
                    request.getComplemento(), request.getCidade(), pais,
                    request.getTelefone(), request.getCep());

            cliente.setEstado(estado);

            clienteRepository.save(cliente);

            return ResponseEntity.ok(cliente.getId());
        }
        if (documentoEscolhido == Documento.CNPJ) {
            Pais pais = paisRepository.findByNomePais(request.getNomePais());
            Estado estado = estadoRepository.findByNomePaisAndNomeEstado(request.getNomePais(), request.getNomeEstado());

            Cliente cliente = new Cliente(request.getEmail(), request.getNome(),
                    request.getSobrenome(), request.getCnpj(), request.getEndereco(),
                    request.getComplemento(), request.getCidade(), pais,
                    request.getTelefone(), request.getCep());

            cliente.setEstado(estado);

            clienteRepository.save(cliente);

            return ResponseEntity.ok(cliente.getId());
        }
        return ResponseEntity.badRequest().build();
    }
}
