package br.com.orange.casadocodigo.controller.form;

import br.com.orange.casadocodigo.controller.validator.EstadoUnicoPorPaisConstraint;
import br.com.orange.casadocodigo.entity.Estado;
import br.com.orange.casadocodigo.entity.Pais;
import br.com.orange.casadocodigo.repository.PaisRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@EstadoUnicoPorPaisConstraint
public class EstadoForm {

    @NotBlank
    private String nome;

    @NotNull
    private Long paisId;

    public Estado toEntity(PaisRepository repository) {
        Optional<Pais> pais = repository.findById(paisId);
        if (!pais.isPresent()) throw new IllegalArgumentException();
        Estado estado = new Estado(this.nome, pais.get());
        return estado;
    }

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }
}
