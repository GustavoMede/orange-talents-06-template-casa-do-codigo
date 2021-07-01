package br.com.zupacademy.gustavo.casadocodigo.validator;

import br.com.zupacademy.gustavo.casadocodigo.model.Categoria;
import br.com.zupacademy.gustavo.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class NomeDuplicadoValidator implements ConstraintValidator<NomeDuplicado, String> {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void initialize(NomeDuplicado constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String nome, ConstraintValidatorContext constraintValidatorContext) {
        Optional<Categoria> categoria = categoriaRepository.findByNome(nome);
        return categoria.isEmpty();
    }
}
