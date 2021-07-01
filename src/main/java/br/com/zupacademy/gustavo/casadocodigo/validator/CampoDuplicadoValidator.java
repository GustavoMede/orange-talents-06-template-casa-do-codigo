package br.com.zupacademy.gustavo.casadocodigo.validator;

import br.com.zupacademy.gustavo.casadocodigo.model.Autor;
import br.com.zupacademy.gustavo.casadocodigo.model.Categoria;
import br.com.zupacademy.gustavo.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.gustavo.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class CampoDuplicadoValidator implements ConstraintValidator<CampoDuplicado, String> {

    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void initialize(CampoDuplicado constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {
        Optional<Autor> autor = autorRepository.findByEmail(s);
        Optional<Categoria> categoria = categoriaRepository.findByNome(s);
        if(autor.isPresent()){
            return false;
        }else return categoria.isEmpty();
    }
}


