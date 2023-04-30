package gft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gft.entities.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long>{
	
	List<Compra> findByFornecedorId(Long idFornecedor);

}
