package gft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gft.entities.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long>{
	
	List<Venda> findByClienteId(Long idCliente);
	
	List<Venda> findByFuncionarioId(Long idFuncionario);

}
