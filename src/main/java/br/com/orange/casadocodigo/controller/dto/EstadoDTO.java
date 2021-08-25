package br.com.orange.casadocodigo.controller.dto;

import br.com.orange.casadocodigo.entity.Estado;

public class EstadoDTO {

    private Long id;
    private String nome;
    private Long paisId;

    public EstadoDTO(Estado estado) {
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.paisId = estado.getPais().getId();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }
}
