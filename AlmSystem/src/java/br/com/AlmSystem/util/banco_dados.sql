create table pessoa (
id_pessoa serial not null,
tipo varchar(30),
nome varchar(50),
telefone varchar(14),
email varchar(50),
cep varchar(13),
uf varchar(20),
cidade varchar(30),
logadoro varchar(30),
bairro varchar(30),
numero varchar(5),
pais varchar(12),
			
CONSTRAINT pk_pessoa PRIMARY KEY (id_pessoa)
);

create table usuario (
id_usuario serial not null,
login varchar(12)not null,
senha varchar(9)not null,
id_pessoa integer,
constraint pk_usuario primary key (id_usuario),
CONSTRAINT fk_pessoa_usuario FOREIGN KEY(id_pessoa) REFERENCES pessoa(id_pessoa)
);

create table fornecedor (

id_forne serial not null,
inscricao_social varchar(30),
cnpj varchar(22),
id_pessoa integer,

constraint pk_fornecedor primary key (id_forne),
CONSTRAINT fk_pessoa_usuario FOREIGN KEY(id_pessoa) REFERENCES pessoa(id_pessoa)

);

create table unidade(
id_uni serial not null,
descricao varchar(50) not null,

CONSTRAINT pk_unidade PRIMARY KEY(id_uni)

);


create table produto (

id_prod serial not null,
descricao varchar(25),
quantidade integer,
id_uni integer,
id_marca integer,
id_forne integer,

constraint pk_produto primary key (id_prod),
constraint fk_unidade  foreign key(id_uni) references unidade(id_uni),
constraint fk_marca  foreign key(id_marca) references marca(id_marca),
CONSTRAINT fk_fornecedor FOREIGN KEY(id_forne) REFERENCES fornecedor(id_forne)
);

create table item (
	
id_item serial not null,
quantidade integer,
notafiscal varchar(100),
data_compra date,	
data_validade date,
data_entrada date,
id_prod integer,

constraint pk_item primary key (id_item),
constraint fk_produto  foreign key(id_prod) references produto(id_prod)

);





