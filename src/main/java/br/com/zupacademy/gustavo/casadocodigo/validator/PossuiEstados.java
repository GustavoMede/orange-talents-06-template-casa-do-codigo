package br.com.zupacademy.gustavo.casadocodigo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PossuiEstadosValidator.class})
public @interface PossuiEstados {
    String message() default "Esse País possui estados, por favor, entre com algum estado existente.";

    Class<?> domainClass();

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default{};
}
