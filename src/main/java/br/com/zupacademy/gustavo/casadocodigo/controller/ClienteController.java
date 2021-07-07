package br.com.zupacademy.gustavo.casadocodigo.controller;

import br.com.zupacademy.gustavo.casadocodigo.dto.ClienteDtoCnpj;
import br.com.zupacademy.gustavo.casadocodigo.dto.ClienteDtoCpf;
import br.com.zupacademy.gustavo.casadocodigo.dto.ClienteRequisicaoForm;
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
import java.util.Optional;

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
    public ResponseEntity<?> cadastra(@RequestBody @Valid ClienteRequisicaoForm form) {
        Documento documentoEscolhido = form.getDocumento();
        if (documentoEscolhido == Documento.CPF) {
            Pais pais = paisRepository.findByNomePais(form.getNomePais());
            Estado estado = estadoRepository.findByNomePaisAndNomeEstado(form.getNomePais(), form.getNomeEstado());

            ClienteDtoCpf clienteDtoCpf = new ClienteDtoCpf(form.getEmail(), form.getNome(),
                    form.getSobrenome(), form.getCpf(), form.getEndereco(), form.getComplemento(),
                    form.getCidade(), pais, estado, form.getTelefone(), form.getCep());

            Cliente cliente = new Cliente(clienteDtoCpf.getEmail(), clienteDtoCpf.getNome(),
                    clienteDtoCpf.getSobrenome(), clienteDtoCpf.getCpf(), clienteDtoCpf.getEndereco(),
                    clienteDtoCpf.getComplemento(), clienteDtoCpf.getCidade(), clienteDtoCpf.getPais(),
                    clienteDtoCpf.getTelefone(), clienteDtoCpf.getCep());

            cliente.setEstado(estado);

            clienteRepository.save(cliente);

            return ResponseEntity.ok(cliente.getId());
        }
        if (documentoEscolhido == Documento.CNPJ) {
            Pais pais = paisRepository.findByNomePais(form.getNomePais());
            Estado estado = estadoRepository.findByNomePaisAndNomeEstado(form.getNomePais(), form.getNomeEstado());

            //Caso o país possuir estados é necessário entrar com um estado
            ClienteDtoCnpj clienteDtoCnpj = new ClienteDtoCnpj(form.getEmail(), form.getNome(),
                    form.getSobrenome(), form.getCnpj(), form.getEndereco(), form.getComplemento(),
                    form.getCidade(), pais, estado, form.getTelefone(), form.getCep());

            Cliente cliente = new Cliente(clienteDtoCnpj.getEmail(), clienteDtoCnpj.getNome(),
                    clienteDtoCnpj.getSobrenome(), clienteDtoCnpj.getCnpj(), clienteDtoCnpj.getEndereco(),
                    clienteDtoCnpj.getComplemento(), clienteDtoCnpj.getCidade(), clienteDtoCnpj.getPais(),
                    clienteDtoCnpj.getTelefone(), clienteDtoCnpj.getCep());

            clienteRepository.save(cliente);

            return ResponseEntity.ok(cliente.getId());
        }
        return ResponseEntity.badRequest().build();
    }
}
