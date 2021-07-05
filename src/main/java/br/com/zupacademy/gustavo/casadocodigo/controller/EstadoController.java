package br.com.zupacademy.gustavo.casadocodigo.controller;

import br.com.zupacademy.gustavo.casadocodigo.dto.EstadoForm;
import br.com.zupacademy.gustavo.casadocodigo.model.Estado;
import br.com.zupacademy.gustavo.casadocodigo.model.Pais;
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
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody @Valid EstadoForm form){
        Pais pais = paisRepository.findByNomePais(form.getNomePais());
        if(pais == null){
            return ResponseEntity.badRequest().build();
        }

        Estado estado = new Estado(form.getNomeEstado(),form.getNomePais(), pais);
        estadoRepository.save(estado);

        return ResponseEntity.ok().build();
    }

}
