/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.List;

/**
 *
 * @author joao_victor1
 */
public class CategoriaGrupoProdutosController {
        private final CategoriaAlimentoDAO objCategoriaAlimentoDAO = new CategoriaAlimentoDAO();

    public String insert(CategoriaAlimentos objCategoriaAlimentos) {

        if (objCategoriaAlimentoDAO.insert(objCategoriaAlimentos) == true) {
            return "Salvo com sucesso";
        } else {
            return "Não foi possível cadastrar uma nova categoria";
        }

    }

    public String delete(CategoriaAlimentos objCategoriaAlimentos) {

        if (objCategoriaAlimentoDAO.delete(objCategoriaAlimentos) == true) {
            return "Removido com sucesso";
        } else {
            return "Não foi possível remover a categoria";
        }

    }

    public String update(CategoriaAlimentos objCategoriaAlimentos) {

        if (objCategoriaAlimentoDAO.update(objCategoriaAlimentos) == true) {
            return "Atualizado com sucesso";
        } else {
            return "Não foi possível atualizar a categoria";
        }

    }

    public List<CategoriaAlimentos> getAll() {

        return objCategoriaAlimentoDAO.getAll();

    }

    public CategoriaAlimentos getById(int id) {

        return objCategoriaAlimentoDAO.getById(id);

    }
}
