package br.com.zupacademy.gustavo.casadocodigo.validator;

import br.com.zupacademy.gustavo.casadocodigo.dto.EstadoForm;
import br.com.zupacademy.gustavo.casadocodigo.model.Estado;
import br.com.zupacademy.gustavo.casadocodigo.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class EstadoDuplicadoValidator implements ConstraintValidator<EstadoDuplicado, Object> {

    @Autowired
    private EstadoRepository estadoRepository;

    private String nomeEstado;

    private String nomePais;

    private Class<?> classe;

    @Override
    public void initialize(EstadoDuplicado constraintAnnotation) {
        nomeEstado = constraintAnnotation.fieldName1();
        nomePais = constraintAnnotation.fieldName2();
        classe = constraintAnnotation.domainClass();
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
