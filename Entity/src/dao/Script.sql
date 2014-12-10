create database ProjetoTCC;
use ProjetoTCC;


CREATE TABLE ProjetoTCC.CategoriaProduto(
  idCategoriaGrupoProduto INT NOT NULL AUTO_INCREMENT,
  nomeGrupo VARCHAR(50) NOT NULL,
  PRIMARY KEY (idCategoriaGrupoProduto));

CREATE TABLE  ProjetoTCC.Produto (
  idProduto INT NOT NULL AUTO_INCREMENT primary key,
  nomeProduto VARCHAR(100) NOT NULL,
  custoProduto DOUBLE NOT NULL,
  valorProduto DOUBLE NOT NULL,
  estoqueAtual INT NULL,
  estoqueMin INT NOT NULL,
  unidade INT not NULL,
  categoria varchar (50) not null
   );


create table ProjetoTCC.Fornecedor(
idFornecedor int not null auto_increment,
nomeFornecedor varchar (100)  , 
telefoneForncedor varchar (20)  ,
cnpj int   ,
nomeContatoFornecedor varchar(100),
inscricaoEstadual int,
bairro varchar(100),
cidade varchar (100),
cep int,
rua varchar(100),
uf char (2),
primary key (idFornecedor)); 
