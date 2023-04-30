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

import gft.dto.venda.ConsultaClienteFuncionarioVendaDTO;
import gft.dto.venda.ConsultaVendaDTO;
import gft.dto.venda.RegistroVendaDTO;
import gft.services.VendaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/venda")
@Api(tags = "Venda")
public class VendaController {

	@Autowired
	private VendaService vendaService;

	@ApiOperation(value = "Listar todas as vendas", nickname = "listarTodasAsVendas")
	@GetMapping
	public ResponseEntity<List<ConsultaVendaDTO>> listarTodasAsVendas() {
		return ResponseEntity.ok(vendaService.listarTodasAsVendas());
	}

	@ApiOperation(value = "Listar uma venda por código", nickname = "listarVendasPorCodigo")
	@GetMapping("/{id}")
	public ResponseEntity<ConsultaClienteFuncionarioVendaDTO> listarVendasPorCodigo(@PathVariable Long id) {
		return ResponseEntity.ok(vendaService.listarPorCodigoVenda(id));
	}

	@ApiOperation(value = "Listar todas as vendas de um cliente", nickname = "listarVendasPorCliente")
	@GetMapping("/cliente/{id}")
	public ResponseEntity<ConsultaClienteFuncionarioVendaDTO> listarVendasPorCliente(@PathVariable Long id) {
		return ResponseEntity.ok(vendaService.listaPorCliente(id));
	}

	@ApiOperation(value = "Listar todas as vendas de um funcionario", nickname = "listarVendasPorFuncionario")
	@GetMapping("/funcionario/{id}")
	public ResponseEntity<ConsultaClienteFuncionarioVendaDTO> listarVendasPorFuncionario(@PathVariable Long id) {
		return ResponseEntity.ok(vendaService.listaPorFuncionario(id));
	}

	@ApiOperation(value = "Registrar uma nova venda", nickname = "registrarVenda")
	@PostMapping("/salvar")
	public ResponseEntity<ConsultaClienteFuncionarioVendaDTO> salvar(@Valid @RequestBody RegistroVendaDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(vendaService.salvar(dto));
	}
	
	@ApiOperation(value = "Deletar uma venda", nickname = "deletarVenda")
	@DeleteMapping("/{codigoVenda}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long codigoVenda) {
		vendaService.deletar(codigoVenda);
	}
}
