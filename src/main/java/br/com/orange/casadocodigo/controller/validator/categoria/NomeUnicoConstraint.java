package br.com.orange.casadocodigo.controller.validator.categoria;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NomeUnicoValidator.class)
public @interface NomeUnicoConstraint {

    String message() default "Esse nome já está cadastrado no sistema!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
