/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entity.CategoriaGrupoProdutos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author joao_victor1
 */
public class CategoriaProdutosDAO extends MySQL{
        private static final String SQL_INSERIR_CATEGORIA_ALIMENTO = "INSERT INTO categoriaAlimentos(nome) VALUES (?)";
    private static final String SQL_EDITAR_CATEGORIA_ALIMENTO = "UPDATE categoriaAlimentos SET nome = ? WHERE idCategoriaAlimentos = ?";
    private static final String SQL_DELETAR_CATEGORIA_ALIMENTO = "DELETE FROM categoriaAlimentos WHERE idCategoriaAlimentos = ?";
    private static final String SQL_GET_BY_ID_CATEGORIA_ALIMENTO = "SELECT idCategoriaAlimentos, nome FROM categoriaAlimentos WHERE idCategoriaAlimentos = ?";
    private static final String SQL_GET_ALL_CATEGORIA_ALIMENTO = "SELECT idCategoriaAlimentos, nome FROM categoriaAlimentos";

    public boolean insert(CategoriaGrupoProdutos categoriaGrupoProdutos) {

        Connection conexao = this.getConnection();
        ResultSet generatedKeys = null;

        try {
            PreparedStatement preparacao = conexao.prepareStatement(SQL_INSERIR_CATEGORIA_ALIMENTO);

            preparacao.setString(1, categoriaGrupoProdutos.getNome());
            preparacao.execute(); //Executando o PreparedStatement
            preparacao.close(); //Fechando o PreparedStatement

            return true;

        } catch (SQLException erro) {
            erro.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (SQLException erro) {
                erro.printStackTrace();
            }
        }
        return false;
    }

    public boolean update(CategoriaGrupoProdutos categoriaGrupoProdutos) {
        Connection conexao = this.getConnection();
        try {

            PreparedStatement preparacao = conexao.prepareStatement(SQL_EDITAR_CATEGORIA_ALIMENTO);

            preparacao.setString(1, categoriaGrupoProdutos.getNome());
            preparacao.setInt(2, categoriaGrupoProdutos.getIdCategoriaGrupoProdutos());

            preparacao.execute(); //Executndo o PreparedStatement
            preparacao.close(); //Fechando o PreparedStatement

            return true;

        } catch (SQLException erro) {

            erro.printStackTrace();

        } finally {

            try {
                conexao.close();
            } catch (SQLException erro) {
                erro.printStackTrace();
            }

        }
        return false;
    }

    public boolean delete(CategoriaGrupoProdutos categoriaGrupoProdutos) {
        Connection conexao = this.getConnection();
        try {

            PreparedStatement preparacao = conexao.prepareStatement(SQL_DELETAR_CATEGORIA_ALIMENTO);

            preparacao.setInt(1, categoriaGrupoProdutos.getIdCategoriaGrupoProdutos());

            preparacao.execute();
            preparacao.close();

            return true;

        } catch (SQLException erro) {

            erro.printStackTrace();

        } finally {

            try {
                conexao.close();
            } catch (SQLException erro) {
                erro.printStackTrace();
            }

        }
        return false;
    }

    public CategoriaGrupoProdutos getById(int id) {

        Connection conexao = this.getConnection();

        CategoriaGrupoProdutos categoriaGrupoProdutos = new CategoriaGrupoProdutos();

        try {
            PreparedStatement preparacao = conexao.prepareStatement(SQL_GET_BY_ID_CATEGORIA_ALIMENTO);

            preparacao.setInt(1, id);

            ResultSet resultado = preparacao.executeQuery();

            while (resultado.next()) {

                categoriaGrupoProdutos.setIdCategoriaGrupoProdutos(resultado.getInt("idCategoriaGrupoProdutos"));
                categoriaGrupoProdutos.setNome(resultado.getString("nome"));

            }

            resultado.close();
            preparacao.close();

        } catch (SQLException erro) {

            erro.printStackTrace();

        } finally {

            try {
                conexao.close();
            } catch (SQLException erro) {
                erro.printStackTrace();
            }

        }
        return categoriaGrupoProdutos;
    }

    public List<CategoriaGrupoProdutos> getAll() {
        List<CategoriaGrupoProdutos> listaCategoriaAlimento = new ArrayList();
        Connection conexao = this.getConnection();
        try {

            PreparedStatement preparacao = conexao.prepareStatement(SQL_GET_ALL_CATEGORIA_ALIMENTO);
            ResultSet resultado = preparacao.executeQuery();

            while (resultado.next()) {
                CategoriaGrupoProdutos categoriaGrupoProdutos = new CategoriaGrupoProdutos();
                categoriaGrupoProdutos.setIdCategoriaGrupoProdutos(resultado.getInt("idCategoriaGrupoProdutos"));
                categoriaGrupoProdutos.setNome(resultado.getString("nome"));
                listaCategoriaAlimento.add(categoriaGrupoProdutos);
            }

            resultado.close();
            preparacao.close();

        } catch (SQLException erro) {

            erro.printStackTrace();

        } finally {

            try {
                conexao.close();
            } catch (SQLException erro) {
                erro.printStackTrace();
            }

        }
        return listaCategoriaAlimento;
    }
}
