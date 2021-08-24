package br.com.orange.casadocodigo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="TB_CATEGORIA")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @Deprecated
    public Categoria () {}

    public Categoria (String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }


}
