package br.com.orange.casadocodigo.controller.form;

import br.com.orange.casadocodigo.controller.exception.ObjetoErroDTO;
import br.com.orange.casadocodigo.controller.exception.RegraNegocioException;
import br.com.orange.casadocodigo.controller.validator.CampoUnicoConstraint;
import br.com.orange.casadocodigo.entity.Cliente;
import br.com.orange.casadocodigo.entity.Estado;
import br.com.orange.casadocodigo.entity.Pais;
import br.com.orange.casadocodigo.repository.EstadoRepository;
import br.com.orange.casadocodigo.repository.PaisRepository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public class ClienteForm {

    @Email
    @NotBlank
    @CampoUnicoConstraint(modelClass = Cliente.class, campo = "email")
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    //criar validação CPF OU CNPJ
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    private Long paisId;

    //criar anotação para validar "se um pais tiver estado, precisa preencher esse campo"
    private Long estadoId;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public Cliente toEntity(EstadoRepository estadoRepository, PaisRepository paisRepository) {
        Cliente cliente;
        Optional<Pais> pais = paisRepository.findById(this.paisId);
        if (!pais.isPresent()) { throw new RegraNegocioException(new ObjetoErroDTO("paisId", "Não existe um país com esse id.")); }

        List<Estado> estados = estadoRepository.findByPaisId(this.paisId);

        if (!estados.isEmpty()) {
            if (this.estadoId == null) { throw new RegraNegocioException(new ObjetoErroDTO("estadoId", "O país " +
                    pais.get().getNome() + " tem um estado, por favor escolha um!")); }
            Optional<Estado> estado = estadoRepository.findById(this.estadoId);
            if (!estado.isPresent()) { throw new RegraNegocioException(new ObjetoErroDTO("estadoId", "Não existe um estado com esse id.")); }

            cliente = new Cliente(this.email, this.nome, this.sobrenome, this.documento, this.endereco,
                    this.complemento, this.cidade, pais.get(), estado.get(), this.telefone, this.cep);

        }
        else {
            cliente = new Cliente(this.email, this.nome, this.sobrenome, this.documento, this.endereco,
                    this.complemento, this.cidade, pais.get(), this.telefone, this.cep);
        }

        return cliente;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}
