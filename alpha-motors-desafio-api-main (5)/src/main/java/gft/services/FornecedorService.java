package gft.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gft.entities.Fornecedor;
import gft.repositories.FornecedorRepository;

@Service
public class FornecedorService {

private final FornecedorRepository fornecedorRepository;
	
	public FornecedorService(FornecedorRepository fornecedorRepository) {
		this.fornecedorRepository = fornecedorRepository;
	}
	
public Fornecedor salvar(Fornecedor fornecedor) {
		
		return fornecedorRepository.save(fornecedor);
		
	}
	
	public Page<Fornecedor> listar(Pageable pageable){
		
		return fornecedorRepository.findAll(pageable);
		
	}

	public Fornecedor buscar(Long id) {
		Optional<Fornecedor> optional = fornecedorRepository.findById(id);
		
		return optional.orElseThrow(() -> new EntityNotFoundException("Fornecedor não encontrado") );
		
	}
	
	public Fornecedor atualizar(Fornecedor fornecedor, Long id) {
		
		Fornecedor fornecedorExistente = this.buscar(id);
		
		fornecedor.setId(fornecedorExistente.getId());
		
		return fornecedorRepository.save(fornecedor);
		
	}

	public void excluir(Long id) {
		Fornecedor fornecedorExistente = this.buscar(id);
		
		fornecedorRepository.delete(fornecedorExistente);
		
	}
	
	
}
