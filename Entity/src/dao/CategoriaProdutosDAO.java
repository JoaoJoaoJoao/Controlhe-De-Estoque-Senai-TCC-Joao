package dao;

import entity.CategoriaGrupoProdutos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaProdutosDAO extends MySQL {

    private static final String SQL_INSERIR_CATEGORIA_PRODUTO = "INSERT INTO ProjetoTCC.CategoriaProduto(nomeGrupo) VALUES (?)";
    private static final String SQL_EDITAR_CATEGORIA_PRODUTO = "UPDATE ProjetoTCC.CategoriaProduto SET nomeGrupo = ? WHERE idCategoriaGrupoProduto = ?";
    private static final String SQL_DELETAR_CATEGORIA_PRODUTO = "DELETE FROM ProjetoTCC.CategoriaProduto WHERE idCategoriaGrupoProduto = ?";
    private static final String SQL_GET_BY_ID_CATEGORIA_PRODUTO = "SELECT idCategoriaGrupoProduto, nomeGrupo FROM ProjetoTCC.CategoriaProduto WHERE idCategoriaGrupoProduto = ?";
    private static final String SQL_GET_ALL_CATEGORIA_PRODUTO = "SELECT idCategoriaGrupoProduto, nomeGrupo FROM ProjetoTCC.CategoriaProduto";
    private static final String SQL_GET_BY_NAME_CATEGORIA_PRODUTO = "SELECT idCategoriaGrupoProduto,nomeGrupo FROM ProjetoTCC.CategoriaProduto WHERE nomeGrupo=?";

    public boolean insert(CategoriaGrupoProdutos categoriaGrupoProdutos) {

        Connection conexao = this.getConnection();
        ResultSet generatedKeys = null;

        try {
            try (PreparedStatement preparacao = conexao.prepareStatement(SQL_INSERIR_CATEGORIA_PRODUTO)) {
                preparacao.setString(1, categoriaGrupoProdutos.getNome());
                preparacao.execute();
            }

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

            PreparedStatement preparacao = conexao.prepareStatement(SQL_EDITAR_CATEGORIA_PRODUTO);

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

            PreparedStatement preparacao = conexao.prepareStatement(SQL_DELETAR_CATEGORIA_PRODUTO);

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
            PreparedStatement preparacao = conexao.prepareStatement(SQL_GET_BY_ID_CATEGORIA_PRODUTO);

            preparacao.setInt(1, id);

            ResultSet resultado = preparacao.executeQuery();

            while (resultado.next()) {

                categoriaGrupoProdutos.setIdCategoriaGrupoProdutos(resultado.getInt("idCategoriaGrupoProdutos"));
                categoriaGrupoProdutos.setNome(resultado.getString("nomeGrupo"));

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
        List<CategoriaGrupoProdutos> listaCategoriaProduto = new ArrayList();
        Connection conexao = this.getConnection();
        try {

            PreparedStatement preparacao = conexao.prepareStatement(SQL_GET_ALL_CATEGORIA_PRODUTO);
            ResultSet resultado = preparacao.executeQuery();

            while (resultado.next()) {
                CategoriaGrupoProdutos categoriaGrupoProdutos = new CategoriaGrupoProdutos();
                categoriaGrupoProdutos.setIdCategoriaGrupoProdutos(resultado.getInt("idCategoriaGrupoProduto"));
                categoriaGrupoProdutos.setNome(resultado.getString("nomeGrupo"));
                listaCategoriaProduto.add(categoriaGrupoProdutos);
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
        return listaCategoriaProduto;
    }

    public CategoriaGrupoProdutos getByName(String nomeGrupo) {
        Connection conexao = this.getConnection();

        CategoriaGrupoProdutos gPro = new CategoriaGrupoProdutos();

        try {
            PreparedStatement preparacao = conexao.prepareStatement(SQL_GET_BY_NAME_CATEGORIA_PRODUTO);
            preparacao.setString(1, nomeGrupo);
            ResultSet resultado = preparacao.executeQuery();

            while (resultado.next()) {
                gPro.setIdCategoriaGrupoProdutos(resultado.getInt("idCategoriaGrupoProduto"));
                gPro.setNome(resultado.getString("nomeGrupo"));

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
        return gPro;
    }
}
