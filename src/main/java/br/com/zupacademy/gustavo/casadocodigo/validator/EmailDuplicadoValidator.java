package br.com.zupacademy.gustavo.casadocodigo.validator;

import br.com.zupacademy.gustavo.casadocodigo.model.Autor;
import br.com.zupacademy.gustavo.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class EmailDuplicadoValidator implements ConstraintValidator<EmailDuplicado, String> {

    @Autowired
    AutorRepository autorRepository;

    @Override
    public void initialize(EmailDuplicado constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        Optional<Autor> autor = autorRepository.findByEmail(email);
        return autor.isEmpty();
    }
}


