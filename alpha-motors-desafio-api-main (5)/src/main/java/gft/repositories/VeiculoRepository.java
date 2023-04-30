package gft.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gft.entities.Veiculo;
import gft.entities.enumVeiculo.Modelo;



@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
	Page<Veiculo> findAll(Pageable pageable);
	
	List<Veiculo> findByModelo(Modelo modelo);
	/*@Query(value = " select * from veiculo v where v.nome like '%:nome%' ", nativeQuery = true)
    List<Veiculo> encontrarPorNome( @Param("nome") String nome );*/

//    @Query(" delete from Veiculo v where v.nome =:nome ")
//    @Modifying
//    void deleteByNome(String nome);
//
//    boolean existsByNome(String nome);
//
//    @Query(value= " select v from Veiculo v left join fetch v.pedidos where v.id = :id  ", nativeQuery = true)
//    Veiculo findVeiculoFetchProdutos( @Param("id") Long id );

}
