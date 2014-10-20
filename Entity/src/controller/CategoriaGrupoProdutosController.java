/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.CategoriaProdutosDAO;
import entity.CategoriaGrupoProdutos;
import java.util.List;

/**
 *
 * @author joao_victor1
 */
public class CategoriaGrupoProdutosController {
        private final CategoriaProdutosDAO objCategoriaProdutosDAO = new CategoriaProdutosDAO();

    public String insert(CategoriaGrupoProdutos objCategoriaGrupoProdutos) {

        if (objCategoriaProdutosDAO.insert(objCategoriaGrupoProdutos) == true) {
            return "Salvo com sucesso";
        } else {
            return "Não foi possível cadastrar uma nova categoria";
        }

    }

    public String delete(CategoriaGrupoProdutos objCategoriaGrupoProdutos) {

        if (objCategoriaProdutosDAO.delete(objCategoriaGrupoProdutos) == true) {
            return "Removido com sucesso";
        } else {
            return "Não foi possível remover a categoria";
        }

    }

    public String update(CategoriaGrupoProdutos objCategoriaGrupoProdutos) {

        if (objCategoriaProdutosDAO.update(objCategoriaGrupoProdutos) == true) {
            return "Atualizado com sucesso";
        } else {
            return "Não foi possível atualizar a categoria";
        }

    }

    public List<CategoriaGrupoProdutos> getAll() {

        return objCategoriaProdutosDAO.getAll();

    }

    public CategoriaGrupoProdutos getById(int id) {

        return objCategoriaProdutosDAO.getById(id);

    }
}
