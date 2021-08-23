package br.com.orange.casadocodigo.controller.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailUnicoValidator.class)
public @interface EmailUnicoConstraint {

    String message() default "Esse email já está cadastrado no sistema!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
