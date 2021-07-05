package br.com.zupacademy.gustavo.casadocodigo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EstadoDuplicadoValidator.class})
public @interface EstadoDuplicado {

    String message() default "Esse Estado já foi cadastrado no País selecionado.";

    String fieldName1();

    String fieldName2();

    Class<?> domainClass();

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default{};
}
