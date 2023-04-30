CREATE TABLE tb_compra(
codigo BIGINT AUTO_INCREMENT PRIMARY KEY,
funcionario_id BIGINT NOT NULL,
fornecedor_id BIGINT NOT NULL,
data DATE NOT NULL,
valor_total DECIMAL(19,2) NOT NULL,
FOREIGN KEY (funcionario_id) REFERENCES tb_funcionario(id),
FOREIGN KEY (fornecedor_id) REFERENCES tb_fornecedor(id));

CREATE TABLE tb_item_compra(
codigo BIGINT AUTO_INCREMENT PRIMARY KEY,
codigo_compra BIGINT NOT NULL,
codigo_produto BIGINT NOT NULL,
quantidade INT NOT NULL,
valor DECIMAL(19,2) NOT NULL,
FOREIGN KEY (codigo_compra) REFERENCES tb_compra(codigo),
FOREIGN KEY (codigo_produto) REFERENCES tb_produto(codigo));