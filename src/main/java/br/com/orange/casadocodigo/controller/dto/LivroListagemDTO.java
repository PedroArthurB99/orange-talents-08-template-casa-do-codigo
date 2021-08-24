package br.com.orange.casadocodigo.controller.dto;

import br.com.orange.casadocodigo.entity.Livro;

import java.util.List;
import java.util.stream.Collectors;

public class LivroListagemDTO {

    private Long id;
    private String titulo;

    public LivroListagemDTO(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public static List<LivroListagemDTO> converterLista(List<Livro> livros) {
        List<LivroListagemDTO> listagem = livros.stream().map(livro -> new LivroListagemDTO(livro.getId(), livro.getTitulo())).collect(Collectors.toList());
        return listagem;
    }
}
