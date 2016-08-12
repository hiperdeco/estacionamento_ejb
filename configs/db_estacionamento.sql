CREATE DATABASE estacionamento;

\connect estacionamento

CREATE TABLE local(
id integer NOT NULL,
descricao varchar(150) NOT NULL,
CONSTRAINT pk_local_id PRIMARY KEY (id)
);
CREATE SEQUENCE seq_local;

CREATE TABLE tipo(
id integer NOT NULL,
descricao varchar(150) NOT NULL,
CONSTRAINT pk_tipo_id PRIMARY KEY (id)
);
CREATE SEQUENCE seq_tipo;

CREATE TABLE marca(
id integer NOT NULL,
descricao varchar(150) NOT NULL,
CONSTRAINT pk_marca_id PRIMARY KEY (id)
);
CREATE SEQUENCE seq_marca;

CREATE SEQUENCE seq_base;

CREATE TABLE modelo(
id integer NOT NULL,
descricao varchar(150) NOT NULL,
combustivel integer,
ano_fabricacao integer NOT NULL,
ano_modelo integer NOT NULL,
motor numeric(4,2),
marca_id integer NOT NULL,
CONSTRAINT pk_modelo_id PRIMARY KEY (id),
CONSTRAINT fk_modelo_marca FOREIGN KEY(marca_id) REFERENCES marca(id)
);
CREATE SEQUENCE seq_modelo;

CREATE TABLE tabela(
id integer NOT NULL,
descricao varchar(150) NOT NULL,
tipo_id integer NOT NULL,
valor numeric(8,2) NOT NULL,
taxa_minuto integer NOT NULL,
CONSTRAINT pk_tabela_id PRIMARY KEY (id),
CONSTRAINT fk_tabela_tipo FOREIGN KEY(tipo_id) REFERENCES tipo(id)
);
CREATE SEQUENCE seq_tabela;

CREATE TABLE pessoa(
id bigint NOT NULL,
nome varchar(150) NOT NULL,
email varchar(255),
cep integer,
endereco varchar(255),
cidade varchar(150),
uf char(2),
tipo char(1),
data_nascimento date,
CONSTRAINT pk_pessoa_id PRIMARY KEY(id)
);
CREATE SEQUENCE seq_pessoa;

CREATE TABLE pessoa_fisica(
 id bigint NOT NULL,
 rg bigint,
 cpf bigint NOT NULL,
 CONSTRAINT pk_pessoa_f_id PRIMARY KEY(id),
 CONSTRAINT uq_cpf UNIQUE(cpf)
);

CREATE TABLE pessoa_juridica(
 id bigint NOT NULL,
 cnpj bigint NOT NULL,
 ie bigint,
 im bigint,
 nome_fantasia varchar(255),
 CONSTRAINT pk_pessoa_j_id PRIMARY KEY(id),
 CONSTRAINT uq_cnpj UNIQUE(cnpj)
);

CREATE TABLE cliente(
id bigint NOT NULL,
pessoa_id bigint NOT NULL,
CONSTRAINT pk_cliente_id PRIMARY KEY(id),
CONSTRAINT fk_cliente_pessoa FOREIGN KEY(pessoa_id) REFERENCES pessoa(id)
);
CREATE SEQUENCE seq_cliente;


CREATE TABLE funcionario(
id bigint NOT NULL,
pessoa_id bigint NOT NULL,
cargo varchar(150) NOT NULL,
CONSTRAINT pk_funcionario_id PRIMARY KEY(id),
CONSTRAINT fk_funcionario_pessoa FOREIGN KEY(pessoa_id) REFERENCES pessoa(id)
);
CREATE SEQUENCE seq_funcionario;


CREATE TABLE veiculo(
id bigint NOT NULL,
placa varchar(50) NOT NULL,
cliente_id bigint NOT NULL,
cor varchar(150),
modelo_id integer NOT NULL,
tipo_id integer NOT NULL,
CONSTRAINT pk_veiculo_id PRIMARY KEY(id),
CONSTRAINT fk_veiculo_cliente FOREIGN KEY(cliente_id) REFERENCES cliente(id),
CONSTRAINT fk_veiculo_modelo FOREIGN KEY(modelo_id) REFERENCES modelo(id),
CONSTRAINT fk_veiculo_tipo FOREIGN KEY(tipo_id) REFERENCES tipo(id)
);
CREATE SEQUENCE seq_veiculo;

CREATE TABLE fluxo(
id bigint NOT NULL,
veiculo_id bigint NOT NULL,
hora_entrada timestamp,
hora_saida timestamp,
local_id integer NOT NULL,
valor_total numeric(8,2),
marcador varchar(150),
CONSTRAINT pk_fluxo_id PRIMARY KEY(id),
CONSTRAINT fk_fluxo_veiculo FOREIGN KEY(veiculo_id) REFERENCES veiculo(id),
CONSTRAINT fk_fluxo_local FOREIGN KEY(local_id) REFERENCES local(id)
);
	
CREATE SEQUENCE seq_fluxo;









