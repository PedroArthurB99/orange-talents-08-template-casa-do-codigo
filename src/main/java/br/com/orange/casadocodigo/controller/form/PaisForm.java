package br.com.orange.casadocodigo.controller.form;

import br.com.orange.casadocodigo.controller.validator.CampoUnicoConstraint;
import br.com.orange.casadocodigo.entity.Pais;

import javax.validation.constraints.NotBlank;

public class PaisForm {

    @NotBlank
    @CampoUnicoConstraint(modelClass = Pais.class, campo = "nome")
    private String nome;

    public Pais toEntity() {
        Pais pais = new Pais(this.nome);
        return pais;
    }

    public String getNome() {
        return nome;
    }
}
