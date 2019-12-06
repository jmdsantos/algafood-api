insert into estado(id, uf, nome) values (1, "RS", "Rio Grande do Sul");
insert into estado(id, uf, nome) values (2, "MG", "Minas Gerais");
insert into estado(id, uf, nome) values (3, "SP", "São Paulo");
insert into estado(id, uf, nome) values (4, "RJ", "Rio de Janeiro");
insert into estado(id, uf, nome) values (5, "PR", "Parana");

insert into cidade(nome, estado_id) values ("São Paulo", 3);
insert into cidade(nome, estado_id) values ("Rio de Janeiro", 4);
insert into cidade(nome, estado_id) values ("Rio Grande do Sul", 1);

insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');
insert into cozinha (id, nome) values (3, 'Francesa');

insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cep, endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro, endereco_cidade_id) values ('Thai Gourmet', 10.00, 1, utc_timestamp, utc_timestamp, '91060120', 'Rua Fulano de Tal', '111', 'Sem complemento', 'Bairro Funalo', 1 );
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Thai Delivery', 3.50, 1, utc_timestamp, utc_timestamp );
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Indiana Restaurante', 8.50, 2, utc_timestamp, utc_timestamp );

insert into produto(id, nome, descricao, preco, ativo) values (1, 'Batata', 'Batata frita com queijo', 5.25, true);
insert into produto(id, nome, descricao, preco, ativo) values (2, 'Suco', 'Suco de Laranja', 8.00, true);

insert into restaurante_produtos(restaurante_id, produtos_id) values (1,1), (1,2);

insert into formapagamento(id,descricao) values (1, "Cartão");
insert into formapagamento(id,descricao) values (2, "Debito");
insert into formapagamento(id,descricao) values (3, "Dinheiro");

insert into permissao(id, nome, descricao) values (1, "CONSULTAR_COZINHA", "Permite consultar cozinhas");
insert into permissao(id, nome, descricao) values (2, "EDITAR_COZINHAS", "Permite editar cozinhas");

insert into restaurante_forma_pagamento(restaurante_id, forma_pagamento_id) values (1,1), (1,2), (1,3), (2,3), (3,2), (3,3);
