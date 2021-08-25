package br.com.orange.casadocodigo.controller.validator;

import br.com.orange.casadocodigo.controller.form.EstadoForm;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target( { ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EstadoUnicoPorPaisValidator.class)
public @interface EstadoUnicoPorPaisConstraint {

    String message() default "Esse estado já existe neste país!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
