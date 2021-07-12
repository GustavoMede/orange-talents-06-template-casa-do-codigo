package br.com.zupacademy.gustavo.casadocodigo.validator;

import br.com.zupacademy.gustavo.casadocodigo.dto.EstadoForm;
import br.com.zupacademy.gustavo.casadocodigo.model.Estado;
import br.com.zupacademy.gustavo.casadocodigo.model.Pais;
import br.com.zupacademy.gustavo.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.gustavo.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class EstadoDuplicadoValidator implements ConstraintValidator<EstadoDuplicado, Object> {

    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private PaisRepository paisRepository;

    private String message2;

    @Override
    public void initialize(EstadoDuplicado constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        EstadoForm objeto = (EstadoForm) object;
        String nomeEstado = objeto.getNomeEstado();
        String nomePais = objeto.getNomePais();

        Optional<Estado> estado = estadoRepository.findByNomeEstadoAndNomePais(nomeEstado, nomePais);
        return estado.isEmpty();

    }
}
