package br.com.orange.casadocodigo.controller;

import br.com.orange.casadocodigo.controller.dto.ClienteDTO;
import br.com.orange.casadocodigo.controller.form.ClienteForm;
import br.com.orange.casadocodigo.entity.Cliente;
import br.com.orange.casadocodigo.repository.ClienteRepository;
import br.com.orange.casadocodigo.repository.EstadoRepository;
import br.com.orange.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @PostMapping
    public ResponseEntity<ClienteDTO> cadastrar(@RequestBody @Valid ClienteForm form) {
        Cliente cliente = form.toEntity(this.estadoRepository, this.paisRepository);
        repository.save(cliente);
        return ResponseEntity.ok(new ClienteDTO(cliente));
    }
}
