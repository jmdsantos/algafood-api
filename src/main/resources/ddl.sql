create table formapagamento (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table grupo (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table grupo_permissoes (grupo_id bigint not null, permissoes_id bigint not null) engine=InnoDB
create table restaurante_forma_pagamento (restaurante_id bigint not null, forma_pagamento_id bigint not null) engine=InnoDB
create table cidade (id bigint not null auto_increment, nome varchar(255) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
create table cozinha (id bigint not null auto_increment, descricao varchar(255), nome varchar(255) not null, primary key (id)) engine=InnoDB
create table estado (id bigint not null auto_increment, uf varchar(255) not null, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table permissao (id bigint not null auto_increment, descricao varchar(255) not null, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table produto (id bigint not null auto_increment, ativo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, restaurante_id bigint, primary key (id)) engine=InnoDB
create table restaurante (id bigint not null auto_increment, data_atualizacao datetime not null, data_cadastro datetime not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(255) not null, taxa_frete decimal(19,2) not null, cozinha_id bigint not null, endereco_cidade_id bigint, primary key (id)) engine=InnoDB
create table restaurante_produtos (restaurante_id bigint not null, produtos_id bigint not null) engine=InnoDB
alter table grupo_permissoes add constraint FKayjy5tklv5pbug1fgcglrus6u foreign key (permissoes_id) references permissao (id)
alter table grupo_permissoes add constraint FKd7wt9tnvrfttdcl5ofoelgi6j foreign key (grupo_id) references grupo (id)
alter table restaurante_forma_pagamento add constraint FKpk3g4dumsg2cpcxudu6fo4v53 foreign key (forma_pagamento_id) references formapagamento (id)
alter table restaurante_forma_pagamento add constraint FKa30vowfejemkw7whjvr8pryvj foreign key (restaurante_id) references restaurante (id)
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table produto add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante (id)
alter table restaurante add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha (id)
alter table restaurante add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade (id)
alter table restaurante_produtos add constraint FKg4ysuq1sw783poblhs9uuueep foreign key (produtos_id) references produto (id)
alter table restaurante_produtos add constraint FKti5of5m60kqvc6dt63ynj30u7 foreign key (restaurante_id) references restaurante (id)
create table formapagamento (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table grupo (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table grupo_permissoes (grupo_id bigint not null, permissoes_id bigint not null) engine=InnoDB
create table restaurante_forma_pagamento (restaurante_id bigint not null, forma_pagamento_id bigint not null) engine=InnoDB
create table cidade (id bigint not null auto_increment, nome varchar(255) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
create table cozinha (id bigint not null auto_increment, descricao varchar(255), nome varchar(255) not null, primary key (id)) engine=InnoDB
create table estado (id bigint not null auto_increment, uf varchar(255) not null, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table permissao (id bigint not null auto_increment, descricao varchar(255) not null, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table produto (id bigint not null auto_increment, ativo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, restaurante_id bigint, primary key (id)) engine=InnoDB
create table restaurante (id bigint not null auto_increment, data_atualizacao datetime not null, data_cadastro datetime not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(255) not null, taxa_frete decimal(19,2) not null, cozinha_id bigint not null, endereco_cidade_id bigint, primary key (id)) engine=InnoDB
create table restaurante_produtos (restaurante_id bigint not null, produtos_id bigint not null) engine=InnoDB
alter table grupo_permissoes add constraint FKayjy5tklv5pbug1fgcglrus6u foreign key (permissoes_id) references permissao (id)
alter table grupo_permissoes add constraint FKd7wt9tnvrfttdcl5ofoelgi6j foreign key (grupo_id) references grupo (id)
alter table restaurante_forma_pagamento add constraint FKpk3g4dumsg2cpcxudu6fo4v53 foreign key (forma_pagamento_id) references formapagamento (id)
alter table restaurante_forma_pagamento add constraint FKa30vowfejemkw7whjvr8pryvj foreign key (restaurante_id) references restaurante (id)
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table produto add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante (id)
alter table restaurante add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha (id)
alter table restaurante add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade (id)
alter table restaurante_produtos add constraint FKg4ysuq1sw783poblhs9uuueep foreign key (produtos_id) references produto (id)
alter table restaurante_produtos add constraint FKti5of5m60kqvc6dt63ynj30u7 foreign key (restaurante_id) references restaurante (id)
