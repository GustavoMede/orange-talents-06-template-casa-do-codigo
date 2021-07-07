package br.com.zupacademy.gustavo.casadocodigo.validator;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CampoDuplicadoValidator implements ConstraintValidator<CampoDuplicado, Object> {

    @PersistenceContext
    private EntityManager entityManager;

    private String atributoDeDominio;

    private Class<?> classe;

    @Override
    public void initialize(CampoDuplicado constraintAnnotation) {
        atributoDeDominio = constraintAnnotation.fieldName();
        classe = constraintAnnotation.domainClass();
    }

    @Override
    public boolean isValid(Object objeto, ConstraintValidatorContext context) {
        System.out.println("Entrando na anotação");
        Query query = entityManager.createQuery("select 1 from " + classe.getName()+" where "+atributoDeDominio+"=:value");
        query.setParameter("value", objeto);
        List<?> lista = query.getResultList();
        System.out.println("printando o valor da lista");
        lista.forEach(System.out::println);
        Assert.state(lista.size() <= 1, "O "+atributoDeDominio+" digitado já foi cadastrado no sistema.");

        return lista.isEmpty();
    }
}


