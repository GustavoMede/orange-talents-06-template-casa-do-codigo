package br.com.zupacademy.gustavo.casadocodigo.controller;

import br.com.zupacademy.gustavo.casadocodigo.dto.PaisForm;
import br.com.zupacademy.gustavo.casadocodigo.model.Pais;
import br.com.zupacademy.gustavo.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody @Valid PaisForm form){
        Pais pais = new Pais(form.getNomePais());
        paisRepository.save(pais);

        return ResponseEntity.ok().build();
    }
}
