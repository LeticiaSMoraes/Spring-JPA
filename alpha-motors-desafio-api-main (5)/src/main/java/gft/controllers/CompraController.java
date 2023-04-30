package gft.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import gft.dto.compra.ConsultaCompraDTO;
import gft.dto.compra.ConsultaFornecedorCompraDTO;
import gft.dto.compra.RegistroCompraDTO;
import gft.services.CompraService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/compra")
@Api(tags = "Compra")
public class CompraController {
	
	@Autowired
	private CompraService compraService;
	
	@GetMapping
	@ApiOperation(value = "Listar todas as compras", nickname = "listarTodasAsCompras")
	public ResponseEntity<List<ConsultaCompraDTO>> listarTodasAsCompras() {
		return ResponseEntity.ok(compraService.listarTodasAsCompras());
	}
	
	@GetMapping("/fornecedor/{idFornecedor}")
	@ApiOperation(value = "Listar todas as compras de um fornecedor", nickname = "listarComprasPorFornecedor")
	public ResponseEntity<ConsultaFornecedorCompraDTO> listarPorFornecedor(@PathVariable Long idFornecedor){
		return ResponseEntity.ok(compraService.listarComprasPorFornecedor(idFornecedor));
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Listar uma compra por código", nickname = "listarComprasPorCodigo")
	public ResponseEntity<ConsultaFornecedorCompraDTO> listarPorCodigo(@PathVariable Long id){
		return ResponseEntity.ok(compraService.listarPorCodigo(id));
	}
	
	@PostMapping("/salvar")
	@ApiOperation(value = "Registrar uma nova compra", nickname = "registrarCompra")
	public ResponseEntity<ConsultaCompraDTO> salvar(@Valid @RequestBody RegistroCompraDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(compraService.salvar(dto));
	}
	
	@DeleteMapping("/deletar/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Deletar uma compra", nickname = "deletarCompra")
	public void deletar(@PathVariable Long id) {
		compraService.deletar(id);
	}



}
