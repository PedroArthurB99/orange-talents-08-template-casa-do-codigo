package br.com.orange.casadocodigo.controller.validator;

import br.com.orange.casadocodigo.controller.exception.EstadoJaExistenteException;
import br.com.orange.casadocodigo.controller.form.EstadoForm;
import br.com.orange.casadocodigo.entity.Estado;
import br.com.orange.casadocodigo.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class EstadoUnicoPorPaisValidator implements ConstraintValidator<EstadoUnicoPorPaisConstraint, EstadoForm> {

    @Autowired
    private EstadoRepository repository;

    @Override
    public void initialize(EstadoUnicoPorPaisConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(EstadoForm value, ConstraintValidatorContext context) {
        Estado estado = this.repository.findByNomeAndPaisId(value.getNome(), value.getPaisId());
        if (Objects.nonNull(estado)) {
            throw new EstadoJaExistenteException(value);
        }
        return (!Objects.nonNull(estado));
    }
}
