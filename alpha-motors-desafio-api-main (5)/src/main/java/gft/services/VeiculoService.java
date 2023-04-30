package gft.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gft.entities.Veiculo;
import gft.entities.enumVeiculo.Modelo;
import gft.repositories.VeiculoRepository;

@Service
public class VeiculoService {

	private final VeiculoRepository veiculoRepository;

	public VeiculoService(VeiculoRepository veiculoRepository) {
		this.veiculoRepository = veiculoRepository;
	}

	public Veiculo salvar(Veiculo veiculo) {
		BigDecimal valorCusto = veiculo.getPrecoCusto();
		BigDecimal total;

		if (veiculo.getPrecoCusto() != null) {

			BigDecimal valorLucro = new BigDecimal(1.20);

			total = valorCusto.multiply(valorLucro);

			veiculo.setPrecoVenda(total);
		}
		return veiculoRepository.save(veiculo);

	}

	public Page<Veiculo> listarTodosOsVeiculos(Pageable pageable) {

		return veiculoRepository.findAll(pageable);

	}

	public Veiculo buscar(Long id) {
		Optional<Veiculo> optional = veiculoRepository.findById(id);

		return optional.orElseThrow(() -> new EntityNotFoundException("Veiculo não encontrado"));

	}

	public Veiculo atualizar(Veiculo veiculo, Long id) {

		Veiculo veiculoOriginal = this.buscar(id);

		veiculo.setId(veiculoOriginal.getId());

		return veiculoRepository.save(veiculo);

	}

	public void excluir(Long id) {
		Veiculo veiculoOriginal = this.buscar(id);

		veiculoRepository.delete(veiculoOriginal);

	}

	public List<Veiculo> listarVeiculo(Modelo modelo) {

		return veiculoRepository.findByModelo(modelo);
	}

}
