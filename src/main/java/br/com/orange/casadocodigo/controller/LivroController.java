package br.com.orange.casadocodigo.controller;

import br.com.orange.casadocodigo.controller.dto.LivroDTO;
import br.com.orange.casadocodigo.controller.dto.LivroListagemDTO;
import br.com.orange.casadocodigo.controller.form.LivroForm;
import br.com.orange.casadocodigo.entity.Livro;
import br.com.orange.casadocodigo.repository.AutorRepository;
import br.com.orange.casadocodigo.repository.CategoriaRepository;
import br.com.orange.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository repository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<LivroDTO> cadastrar(@RequestBody @Valid LivroForm form) {
        Livro livro = form.toEntity(autorRepository, categoriaRepository);
        this.repository.save(livro);
        return ResponseEntity.ok(new LivroDTO(livro));
    }

    @GetMapping
    @Transactional
    public ResponseEntity<List<LivroListagemDTO>> listarLivros() {
        List<Livro> livros = this.repository.findAll();
        List<LivroListagemDTO> listagem = LivroListagemDTO.converterLista(livros);
        return ResponseEntity.ok(listagem);
    }
}
