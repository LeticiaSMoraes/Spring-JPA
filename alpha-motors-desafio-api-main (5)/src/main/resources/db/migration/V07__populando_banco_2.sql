INSERT INTO tb_venda(codigo, funcionario_id, cliente_id, data, valor_total)
	VALUES (1, 1, 2, '2022-11-01', 829.60);
INSERT INTO tb_venda(codigo, funcionario_id, cliente_id, data, valor_total)
	VALUES (2, 2, 1, '2022-10-25', 550);
INSERT INTO tb_venda(codigo, funcionario_id, cliente_id, data, valor_total)
	VALUES (3, 1, 3, '2022-10-20', 610);
INSERT INTO tb_venda(codigo, funcionario_id, cliente_id, data, valor_total)
	VALUES (4, 3, 3, '2022-11-24', 580);
	
INSERT INTO tb_item_venda(codigo, codigo_venda, codigo_produto, codigo_veiculo, quantidade, valor)
	VALUES (1, 1, 1, null, 2, 67.80);
INSERT INTO tb_item_venda(codigo, codigo_venda, codigo_produto, codigo_veiculo, quantidade, valor)
	VALUES (2, 1, 2, null, 2, 347);
INSERT INTO tb_item_venda(codigo, codigo_venda, codigo_produto, codigo_veiculo, quantidade, valor)	
	VALUES (3, 2, 6, null, 1, 550);
INSERT INTO tb_item_venda(codigo, codigo_venda, codigo_produto, codigo_veiculo,  quantidade, valor)
	VALUES (4, 3, 7, null, 1, 150);
INSERT INTO tb_item_venda(codigo, codigo_venda, codigo_produto, codigo_veiculo,  quantidade, valor)
	VALUES (5, 3, 5, null, 2, 230);
INSERT INTO tb_item_venda(codigo, codigo_venda, codigo_produto, codigo_veiculo,  quantidade, valor)
	VALUES (6, 4, 8, null, 1, 580);