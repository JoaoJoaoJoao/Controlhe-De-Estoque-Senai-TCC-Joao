/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

/**
 *
 * @author joao_victor1
 */
public class CategoriaGrupoProdutos {
    private Integer idGrupoProdutos;
    private String nome;

    public Integer getIdCategoriaGrupoProdutos() {
        return idGrupoProdutos;
    }

    public void setIdCategoriaGrupoProdutos(Integer idCategoriaAlimentos) {
        this.idGrupoProdutos = idCategoriaAlimentos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

}
