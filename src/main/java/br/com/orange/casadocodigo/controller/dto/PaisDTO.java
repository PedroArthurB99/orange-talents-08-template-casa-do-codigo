package br.com.orange.casadocodigo.controller.dto;

import br.com.orange.casadocodigo.entity.Pais;

public class PaisDTO {

    private Long id;
    private String nome;

    public PaisDTO(Pais pais) {
        this.id = pais.getId();
        this.nome = pais.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
