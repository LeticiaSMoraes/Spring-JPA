package gft.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gft.dto.veiculo.BuscaPorModeloDTO;
import gft.dto.veiculo.ConsultaVeiculoDTO;
import gft.dto.veiculo.RegistroVeiculoDTO;
import gft.dto.veiculo.VeiculoMapper;
import gft.entities.Veiculo;
import gft.entities.enumVeiculo.Modelo;
import gft.services.VeiculoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Veiculo")
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
	
private final VeiculoService veiculoService;
	
	public VeiculoController(VeiculoService veiculoService) {
		this.veiculoService = veiculoService;
	}

	@ApiOperation(value = "Listar todos os veículos")
	@GetMapping
	public ResponseEntity<Page<ConsultaVeiculoDTO>> buscarTodosOsVeiculos(@PageableDefault Pageable pageable){
		
		return ResponseEntity.ok(veiculoService.listarTodosOsVeiculos(pageable).map(VeiculoMapper::fromEntity));		
			
		
	}
	
	@ApiOperation(value = "Salvar um novo veiculo")
	@PostMapping
	public ResponseEntity<ConsultaVeiculoDTO> salvar(@RequestBody RegistroVeiculoDTO dto){
		
		Veiculo veiculo = veiculoService.salvar(VeiculoMapper.fromDTO(dto));
		
		return ResponseEntity.ok(VeiculoMapper.fromEntity(veiculo));
		
	}
	
	@ApiOperation(value = "Listar um veiculo por Id")
	@GetMapping("{id}") 
	public ResponseEntity<ConsultaVeiculoDTO> buscar(@PathVariable Long id){

		Veiculo veiculo = veiculoService.buscar(id);
		
		return ResponseEntity.ok(VeiculoMapper.fromEntity(veiculo));
		
		
	}
	@ApiOperation(value = "Atualizar um veiculo cadastrado")
	@PutMapping("{id}")
	public ResponseEntity<ConsultaVeiculoDTO> alterar(@RequestBody RegistroVeiculoDTO dto,
			@PathVariable Long id){
		
		try {
		
			Veiculo veiculo = veiculoService.atualizar(VeiculoMapper.fromDTO(dto), id);
			
			return ResponseEntity.ok(VeiculoMapper.fromEntity(veiculo));
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}
	@ApiOperation(value = "Deletar um veiculo cadastrado")
	@DeleteMapping("{id}")
	public ResponseEntity<ConsultaVeiculoDTO> excluir(@PathVariable Long id){
		
		try {
			veiculoService.excluir(id);
			
			return ResponseEntity.ok().build();
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@ApiOperation(value = "ListarEstoque")
	@GetMapping("/estoque/{modelo}")
	 public ResponseEntity<List<BuscaPorModeloDTO>> buscarVeiculoPorModelo(@PathVariable Modelo modelo){
	        
	        return ResponseEntity.ok(veiculoService.listarVeiculo(modelo)
	                .stream().map(VeiculoMapper::fromEntityBusca).collect(Collectors.toList()));
	    
	    }

}
