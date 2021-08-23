package br.com.orange.casadocodigo.controller.form;

import br.com.orange.casadocodigo.entity.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class AutorForm {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(max = 400, message = "A descrição não pode ter mais de 400 caracteres.")
    private String descricao;

    public Autor toEntity() {
        Autor autor = new Autor(this.nome, this.email, this.descricao, LocalDateTime.now());
        return autor;
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
}
