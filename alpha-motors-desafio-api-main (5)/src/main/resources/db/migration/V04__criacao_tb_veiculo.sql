CREATE TABLE tb_veiculo(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
marca VARCHAR(255) NOT NULL,
modelo VARCHAR(255) NOT NULL,
ano VARCHAR(255) NOT NULL,
cor VARCHAR(255) NOT NULL,
descricao VARCHAR(255),
quantidade INT NOT NULL,
preco_custo DECIMAL(19,2),
preco_venda DECIMAL(19,2) NOT NULL);