package br.com.orange.casadocodigo.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name="TB_AUTOR")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(max = 400, message = "A descrição não pode ter mais de 400 caracteres.")
    private String descricao;

    private LocalDateTime dataCadastro;

    @Deprecated
    public Autor() {}

    public Autor (String nome, String email, String descricao, LocalDateTime dataCadastro) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
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
