
package controller;

import dao.ProdutoDao;
import entity.Produto;
import java.util.List;


public class ProdutoController {
    
    private final ProdutoDao objProdutoDao = new ProdutoDao();

    public String insert(Produto objProduro) {

        if (objProdutoDao.insert(objProduro) == true) {
            return "Salvo com sucesso";
        } else {
            return "Não foi possível cadastrar produto";
        }

    }

    public String delete(Produto objProduto) {

        if (objProdutoDao.delete(objProduto) == true) {
            return "Removido com sucesso";
        } else {
            return "Não foi possível remover o produto";
        }

    }

    public String update(Produto objProduto) {

        if (objProdutoDao.update(objProduto) == true) {
            return "Atualizado com sucesso";
        } else {
            return "Não foi possível atualizar o produto";
        }

    }

    public List<Produto> getAll() {

        return objProdutoDao.getAll();

    }

    public Produto getById(int id) {

        return objProdutoDao.getById(id);

    }
     public Produto getByName(String nome) {
       return  objProdutoDao.getByName(nome);
    }

}
