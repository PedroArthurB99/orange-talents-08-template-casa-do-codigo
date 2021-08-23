package br.com.orange.casadocodigo.repository;

import br.com.orange.casadocodigo.entity.Autor;
import br.com.orange.casadocodigo.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    List<Categoria> findByNome(String nome);
}
