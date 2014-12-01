create database ProjetoTCC;
use ProjetoTCC;


CREATE TABLE IF NOT EXISTS ProjetoTCC.CategoriaProduto(
  idCategoriaProduto INT NOT NULL AUTO_INCREMENT,
  nomeGrupo VARCHAR(50) NOT NULL,
  PRIMARY KEY (idCategoriaProduto));

CREATE TABLE IF NOT EXISTS ProjetoTCC.Produto (
idProduto INT NOT NULL AUTO_INCREMENT,
  nomeProduto VARCHAR(100) NOT NULL,
  custoProduto DOUBLE NOT NULL,
  valorProduto DOUBLE NOT NULL,
  estoqueAtual INT NULL,
  estoqueMin INT NOT NULL,
  unidade INT NULL,
  CategoriaProduto_idCategoriaProduto INT NOT NULL,
  PRIMARY KEY (idProduto),
  INDEX fk_Produto_CategoriaProduto_idx(CategoriaProduto_idCategoriaProduto ASC),
  CONSTRAINT fk_Produto_CategoriaProduto
    FOREIGN KEY (CategoriaProduto_idCategoriaProduto)
    REFERENCES ProjetoTCC.CategoriaProduto (idCategoriaProduto)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


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
