package br.com.orange.casadocodigo.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_LIVRO")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    private String sumario;

    @NotNull
    @Min(20)
    private Double preco;

    @NotNull
    @Min(100)
    private Integer paginas;

    @NotBlank
    private String isbn;

    private LocalDate dataPublicacao;

    @ManyToOne
    @NotNull
    private Categoria categoria;

    @ManyToOne
    @NotNull
    private Autor autor;

    @Deprecated
    public Livro() {}


    public Livro(String titulo, String resumo, Double preco, Integer paginas, String isbn, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Livro(String titulo, String resumo, Double preco, Integer paginas, String isbn, Categoria categoria, Autor autor, String sumario, LocalDate dataPublicacao) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.categoria = categoria;
        this.autor = autor;
        this.sumario = sumario;
        this.dataPublicacao = dataPublicacao;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
}
