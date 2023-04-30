CREATE TABLE tb_venda(
codigo BIGINT AUTO_INCREMENT PRIMARY KEY,
funcionario_id BIGINT NOT NULL,
cliente_id BIGINT NOT NULL,
data DATE NOT NULL,
valor_total DECIMAL(19,2) NOT NULL,
FOREIGN KEY (funcionario_id) REFERENCES tb_funcionario(id),
FOREIGN KEY (cliente_id) REFERENCES tb_cliente(id));

CREATE TABLE tb_item_venda(
codigo BIGINT AUTO_INCREMENT PRIMARY KEY,
codigo_venda BIGINT,
codigo_produto BIGINT,
codigo_veiculo BIGINT,
quantidade INT NOT NULL,
valor DECIMAL(19,2) NOT NULL,
FOREIGN KEY (codigo_venda) REFERENCES tb_venda(codigo),
FOREIGN KEY (codigo_produto) REFERENCES tb_produto(codigo),
FOREIGN KEY (codigo_veiculo) REFERENCES tb_veiculo(id));