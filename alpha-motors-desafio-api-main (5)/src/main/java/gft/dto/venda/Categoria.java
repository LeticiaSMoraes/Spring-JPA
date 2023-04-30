package gft.dto.venda;

public enum Categoria {
	
	PRODUTO(1),
	VEICULO(2);
	
	public int valorCategoria;
	Categoria(int valor){
		valorCategoria = valor;
	}
	
	public int getValorCategoria() {
		return valorCategoria;
	}

}
