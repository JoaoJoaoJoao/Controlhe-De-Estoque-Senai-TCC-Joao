
package controller;

import dao.FornecedorDao;
import entity.Fornecedor;
import entity.Produto;
import java.util.List;


public class FornecedorController {
    
    private final FornecedorDao objFornecedorDao = new FornecedorDao();

    public String insert(Fornecedor objFornecedor ) {

        if (objFornecedorDao.insert(objFornecedor) == true) {
            return "Salvo com sucesso";
        } else {
            return "Não foi possível cadastrar novo tipo de usuário";
        }

    }

    public String delete(Fornecedor objFornecedor) {

        if (objFornecedorDao.delete(objFornecedor) == true) {
            return "Removido com sucesso";
        } else {
            return "Não foi possível remover tipo de usuário";
        }

    }

    public String update(Fornecedor objFornecedor) {

        if (objFornecedorDao.update(objFornecedor) == true) {
            return "Atualizado com sucesso";
        } else {
            return "Não foi possível atualizar tipo de usuário";
        }

    }

    public List<Fornecedor> getAll() {

        return objFornecedorDao.getAll();

    }

    public Fornecedor getById(int id) {

        return objFornecedorDao.getById(id);

    }
    public Fornecedor getByName(String nome) {
       return  objFornecedorDao.getByName(nome);
    }
}
