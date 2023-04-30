package gft.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import gft.dto.produto.ConsultaProdutoDTO;
import gft.entities.Produto;
import gft.exception.RegraNegocioException;
import gft.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	private final ProdutoRepository produtoRepository;

	// uma boa prática mehlor que autowired
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public Produto salvarProduto(Produto produto) {
		BigDecimal valorCusto = produto.getCaracteristicas().getPrecoCusto();
		BigDecimal total;
		if (produto.getCaracteristicas().getPrecoCusto() != null) {
			BigDecimal valorLucro = new BigDecimal(1.20);

			total = valorCusto.multiply(valorLucro);

			produto.getCaracteristicas().setPrecoVenda(total);

		}
		return this.produtoRepository.save(produto);
	}

	public List<Produto> listarTodosOsProdutos() {

		return produtoRepository.findAll();
	}

	public Produto buscarProduto(Long id) {

		Optional<Produto> optional = produtoRepository.findById(id);

		if (optional.isEmpty()) {
			throw new RegraNegocioException(String.format("Produto de código %s não existe", id));
		}
		return optional.get();
	}

	public Produto atualizarProduto(Produto produto, Long id) {

		Produto produtoOriginal = this.buscarProduto(id);

		produto.setId(produtoOriginal.getId());

		return produtoRepository.save(produto);
	}

	public void excluirProduto(Long id) {
		Produto produtoOriginal = this.buscarProduto(id);

		produtoRepository.delete(produtoOriginal);
	}

	// o metodo espera uma lista
	public List<Produto> listarProduto(String nome) {

		return produtoRepository.findByNomeContains(nome);
	}

}
