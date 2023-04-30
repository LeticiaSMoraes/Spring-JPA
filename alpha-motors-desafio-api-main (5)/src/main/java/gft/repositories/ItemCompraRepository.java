package gft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gft.entities.ItemCompra;

@Repository
public interface ItemCompraRepository extends JpaRepository<ItemCompra, Long>{
	
	List<ItemCompra> findByCompraCodigo(Long codigoCompra);


}
