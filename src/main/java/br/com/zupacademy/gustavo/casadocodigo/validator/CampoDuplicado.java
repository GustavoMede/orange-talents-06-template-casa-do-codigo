package br.com.zupacademy.gustavo.casadocodigo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {CampoDuplicadoValidator.class})
public @interface CampoDuplicado {

    String message() default "O valor do campo já foi cadastrado";

    String fieldName();

    Class<?> domainClass();

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default{};
}
