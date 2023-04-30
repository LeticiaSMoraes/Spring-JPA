package gft.dto.veiculo;

import gft.entities.Veiculo;

public class VeiculoMapper {
	
	public static Veiculo fromDTO(RegistroVeiculoDTO dto) {
		return new Veiculo(null, dto.getModelo(), dto.getAno(), dto.getCor(), dto.getDescricao(), dto.getQuantidade(), dto.getPrecoCusto(), null);
	}
	
	public static ConsultaVeiculoDTO fromEntity(Veiculo veiculo) {
		return new ConsultaVeiculoDTO(veiculo.getId(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getAno(), veiculo.getCor(), veiculo.getDescricao(), veiculo.getQuantidade(), veiculo.getPrecoCusto(), veiculo.getPrecoVenda());
	}

	public static BuscaPorModeloDTO fromEntityBusca(Veiculo veiculo) {
		return new BuscaPorModeloDTO(veiculo.getModelo(), veiculo.getQuantidade());
	}
}
