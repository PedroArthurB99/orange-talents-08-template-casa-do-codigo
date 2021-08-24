package br.com.orange.casadocodigo.controller.form;

import br.com.orange.casadocodigo.controller.validator.CampoUnicoConstraint;
import br.com.orange.casadocodigo.entity.Autor;
import br.com.orange.casadocodigo.entity.Categoria;
import br.com.orange.casadocodigo.entity.Livro;
import br.com.orange.casadocodigo.repository.AutorRepository;
import br.com.orange.casadocodigo.repository.CategoriaRepository;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Optional;

public class LivroForm {

    @NotBlank
    @CampoUnicoConstraint(modelClass = Livro.class, campo = "titulo")
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
    @CampoUnicoConstraint(modelClass = Livro.class, campo = "isbn")
    private String isbn;

    @Future
    private LocalDate dataPublicacao;

    @NotNull
    private Long categoriaId;

    @NotNull
    private Long autorId;

    public Livro toEntity(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        Optional<Autor> autor = autorRepository.findById(autorId);
        Optional<Categoria> categoria = categoriaRepository.findById(categoriaId);

        if (!autor.isPresent() || !categoria.isPresent()) throw new IllegalArgumentException();
        Livro livro = new Livro(this.titulo, this.resumo, this.preco, this.paginas, this.isbn, categoria.get(), autor.get(), this.sumario, this.dataPublicacao);
        return livro;
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
