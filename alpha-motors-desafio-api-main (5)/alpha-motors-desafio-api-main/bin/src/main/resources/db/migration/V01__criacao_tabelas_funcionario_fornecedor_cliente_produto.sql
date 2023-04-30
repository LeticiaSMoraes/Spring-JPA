CREATE TABLE tb_funcionario(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(255) NOT NULL,
cpf VARCHAR(11) NOT NULL,
telefone VARCHAR(255) NOT NULL,
email VARCHAR(255) NOT NULL,
senha VARCHAR(255) NOT NULL,
logradouro VARCHAR(255) NOT NULL,
numero VARCHAR(255) NOT NULL,
complemento VARCHAR(255),
cep VARCHAR(8));

CREATE TABLE tb_fornecedor(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
razao_social VARCHAR(255) NOT NULL,
cnpj VARCHAR(14) NOT NULL,
telefone VARCHAR(11),
email VARCHAR(255) NOT NULL,
logradouro VARCHAR(255) NOT NULL,
numero VARCHAR(255) NOT NULL,
complemento VARCHAR(255),
cep VARCHAR(8) NOT NULL);

CREATE TABLE tb_cliente(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(255) NOT NULL,
cpf VARCHAR(11) NOT NULL,
telefone VARCHAR(255) NOT NULL,
email VARCHAR(255) NOT NULL,
logradouro VARCHAR(255) NOT NULL,
numero VARCHAR(255) NOT NULL,
complemento VARCHAR(255),
cep VARCHAR(8));

CREATE TABLE tb_produto(
codigo BIGINT AUTO_INCREMENT PRIMARY KEY,
fornecedor_id BIGINT NOT NULL,
nome VARCHAR(255) NOT NULL,
descricao VARCHAR(255) NOT NULL,
quantidade INT,
preco_custo DECIMAL(19,2),
preco_venda DECIMAL(19,2),
FOREIGN KEY (fornecedor_id) REFERENCES tb_fornecedor(id));
