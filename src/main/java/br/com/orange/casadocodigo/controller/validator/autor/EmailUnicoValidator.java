package br.com.orange.casadocodigo.controller.validator.autor;

import br.com.orange.casadocodigo.entity.Autor;
import br.com.orange.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class EmailUnicoValidator implements ConstraintValidator<EmailUnicoConstraint, String> {

    @Autowired
    private AutorRepository repository;

    @Override
    public void initialize(EmailUnicoConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        List<Autor> list = repository.findByEmail(value);
        return list.size()==0;
    }
}
