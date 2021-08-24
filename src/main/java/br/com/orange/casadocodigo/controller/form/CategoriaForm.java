package br.com.orange.casadocodigo.controller.form;

import br.com.orange.casadocodigo.controller.validator.CampoUnicoConstraint;
import br.com.orange.casadocodigo.entity.Categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    @NotBlank
    @CampoUnicoConstraint(modelClass = Categoria.class, campo = "nome")
    private String nome;

    public Categoria toEntity() {
        Categoria categoria = new Categoria(nome);
        return categoria;
    }

    public String getNome() {
        return nome;
    }

}
