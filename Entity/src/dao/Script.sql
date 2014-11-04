create database ProjetoTCC;

use ProjetoTCC;

create table ProjetoTCC.CategoriaProduto(
idCategoriaGrupoProduto int not null auto_increment ,
nomeGrupo varchar (50),
primary key (idCategoriaGrupoProduto )); 


create table ProjetoTCC.Produto(
idProduto int not null auto_increment,
nomeProduto varchar (100),
custoProduto double ,
valorProduto double ,
estoqueAtual int ,
estoqueMin int ,
unidade int  ,
primary key (idProduto));

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
primary key (idFornecedor)); 
