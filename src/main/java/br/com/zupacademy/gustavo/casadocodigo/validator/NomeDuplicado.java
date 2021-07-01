package br.com.zupacademy.gustavo.casadocodigo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {NomeDuplicadoValidator.class})
public @interface NomeDuplicado {

    String message();

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default{};
}
