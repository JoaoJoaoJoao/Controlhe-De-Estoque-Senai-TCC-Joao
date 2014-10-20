/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.IProdutoDao;
import dao.ProdutoDaoMySql;
import entity.Produto;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 */
public class ProdutoFacade {

    public void insertProduto(Produto produto) {

        ProdutoDaoMySql produtoDAO = new ProdutoDaoMySql();
        Produto.salvar(produto);
        JOptionPane.showMessageDialog(null, "Salvo com sucesso");

    }

    public String excluiProduto(Produto produto) {
        ProdutoDaoMySql pro = new ProdutoDaoMySql();
        pro.exclui(produto);

        return "Removido com sucesso";
    }

}
