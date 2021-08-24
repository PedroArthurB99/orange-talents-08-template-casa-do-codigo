package br.com.orange.casadocodigo.controller.dto;

import br.com.orange.casadocodigo.entity.Livro;

import java.time.LocalDate;

public class LivroDTO {

    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private Double preco;
    private Integer paginas;
    private String isbn;
    private LocalDate dataPublicacao;
    private Long categoriaId;
    private Long autorId;

    public LivroDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.paginas = livro.getPaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao();
        this.categoriaId = livro.getCategoria().getId();
        this.autorId = livro.getAutor().getId();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public Long getAutorId() {
        return autorId;
    }
}
