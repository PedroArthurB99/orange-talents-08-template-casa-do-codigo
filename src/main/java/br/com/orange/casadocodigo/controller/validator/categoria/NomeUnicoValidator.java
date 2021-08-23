package br.com.orange.casadocodigo.controller.validator.categoria;

import br.com.orange.casadocodigo.entity.Categoria;
import br.com.orange.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class NomeUnicoValidator implements ConstraintValidator<NomeUnicoConstraint, String> {

    @Autowired
    private CategoriaRepository repository;

    @Override
    public void initialize(NomeUnicoConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        List<Categoria> list = repository.findByNome(value);
        return list.size()==0;
    }
}
