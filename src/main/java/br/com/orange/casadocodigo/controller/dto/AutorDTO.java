package br.com.orange.casadocodigo.controller.dto;

import br.com.orange.casadocodigo.entity.Autor;
import java.time.LocalDateTime;

public class AutorDTO {

    private Long id;
    private String nome;
    private String email;
    private String descricao;
    private LocalDateTime dataCadastro;

    public AutorDTO (Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
        this.dataCadastro = autor.getDataCadastro();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }
}
