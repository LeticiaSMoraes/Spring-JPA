package gft.controllers;

import gft.dto.veiculo.ConsultaVeiculoDTO;
import gft.dto.veiculo.RegistroVeiculoDTO;
import gft.entities.Veiculo;

public class VeiculoMapper {
	
	public static Veiculo fromDTO(RegistroVeiculoDTO dto) {
		return new Veiculo(null, dto.getMarca(), dto.getModelo(), dto.getAno(), dto.getCor(), dto.getDescricao(), 0, null, null);
	}
	
	public static ConsultaVeiculoDTO fromEntity(Veiculo veiculo) {
		return new ConsultaVeiculoDTO(veiculo.getId(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getAno(), veiculo.getCor(), veiculo.getDescricao(), veiculo.getQuantidade(), null, veiculo.getPrecoVenda());
	}

}
