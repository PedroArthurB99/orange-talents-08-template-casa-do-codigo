package br.com.orange.casadocodigo.repository;

import br.com.orange.casadocodigo.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    Estado findByNomeAndPaisId(String estado, Long paisId);

    List<Estado> findByPaisId(Long paisId);
}
