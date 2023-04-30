INSERT INTO tb_compra(codigo, funcionario_id, fornecedor_id, data, valor_total)
	VALUES (1, 1, 1, '2022-11-01', 78000);
INSERT INTO tb_compra(codigo, funcionario_id, fornecedor_id, data, valor_total)
	VALUES (2, 2, 2, '2022-10-25', 6000);
INSERT INTO tb_compra(codigo, funcionario_id, fornecedor_id, data, valor_total)
	VALUES (3, 3, 5, '2022-10-20', 24200);

	
INSERT INTO tb_item_compra(codigo, codigo_compra, codigo_produto, quantidade, valor)
	VALUES (1, 1, 4, 100, 630);
INSERT INTO tb_item_compra(codigo, codigo_compra, codigo_produto, quantidade, valor)
	VALUES (2, 1, 6, 50, 300);
INSERT INTO tb_item_compra(codigo, codigo_compra, codigo_produto, quantidade, valor)	
	VALUES (3, 2, 3, 10, 600);
INSERT INTO tb_item_compra(codigo, codigo_compra, codigo_produto, quantidade, valor)
	VALUES (4, 3, 1, 100, 150);
INSERT INTO tb_item_compra(codigo, codigo_compra, codigo_produto, quantidade, valor)
	VALUES (5, 3, 5, 40, 230);
