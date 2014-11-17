

package dao;

import entity.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao extends MySQL {

    private static final String SQL_INSERIR_PRODUTO = "INSERT INTO ProjetoTCC.Produto(nomeProduto,custoProduto,valorProduto,estoqueAtual,estoqueMin,unidade,categoria) VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_EDITAR_PRODUTO = "UPDATE alimento SET nomeProduto = ? WHERE idProduto = ?";
    private static final String SQL_DELETAR_PRODUTO = "DELETE FROM ProjetoTCC.Produto WHERE idProduto = ?";
    private static final String SQL_GET_BY_ID_PRODUTO = "SELECT idProduto, nomeProduto FROM ProjetoTCC.Produto WHERE idProduto = ?";
    private static final String SQL_GET_ALL_PRODUTO = "SELECT idProduto,nomeProduto FROM ProjetoTCC.Produto WHERE nomeProduto=?";
    private static final String SQL_GET_BY_NAME_PRODUTO = "SELECT idProduto,nomeProduto FROM ProjetoTCC.Produto WHERE nomeProduto=?";

    public boolean insert(Produto produto) {

        Connection conexao = this.getConnection();
        ResultSet generatedKeys = null;

        try {
            PreparedStatement preparacao = conexao.prepareStatement(SQL_INSERIR_PRODUTO, PreparedStatement.RETURN_GENERATED_KEYS);

            preparacao.setString(1, produto.getNomeProduto());
            preparacao.setDouble(2, produto.getCustoProduto());
            preparacao.setDouble(3, produto.getValorProduto());
            preparacao.setInt(4, produto.getEstoqueIdeal());
            preparacao.setInt(5, produto.getEstoqueMin());
            preparacao.setInt(6, produto.getUnidade());
            preparacao.setString(7, produto.getCategoria()+"");
            preparacao.execute(); //Executndo o PreparedStatement

            //pego o id da inserção
            generatedKeys = preparacao.getGeneratedKeys();

            //adiciono o id ao objeto
            if (generatedKeys.next()) {
                produto.setIdProduto(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Criação de Endereço falhou, nao consegui obter o id.");
            }
            preparacao.close(); //Fechando o PreparedStatement

        } catch (SQLException erro) {
            erro.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (SQLException erro) {
                erro.printStackTrace();
            }
        }
        return true;

    }

    public boolean update(Produto produto) {
        Connection conexao = this.getConnection();
        try {

            PreparedStatement preparacao = conexao.prepareStatement(SQL_EDITAR_PRODUTO);

            preparacao.setString(1, produto.getNomeProduto());

            preparacao.setInt(2, produto.getIdProduto());

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

    public boolean delete(Produto produto) {
        Connection conexao = this.getConnection();
        try {

            PreparedStatement preparacao = conexao.prepareStatement(SQL_DELETAR_PRODUTO);

            preparacao.setInt(1, produto.getIdProduto());

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

    public Produto getById(int id) {

        Connection conexao = this.getConnection();

        Produto produto = new Produto();

        try {

            PreparedStatement preparacao = conexao.prepareStatement(SQL_GET_BY_ID_PRODUTO);

            preparacao.setInt(1, id);

            ResultSet resultado = preparacao.executeQuery();

            while (resultado.next()) {

                produto.setIdProduto(resultado.getInt("idProduto"));
                produto.setNomeProduto(resultado.getString("nomeProduto"));

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
        return produto;
    }

    public List<Produto> getAll() {
        List<Produto> listaProduto = new ArrayList();
        Connection conexao = this.getConnection();
        try {

            PreparedStatement preparacao = conexao.prepareStatement(SQL_GET_ALL_PRODUTO);
            ResultSet resultado = preparacao.executeQuery();

            while (resultado.next()) {
                Produto produto = new Produto();

                produto.setIdProduto(resultado.getInt("a.idAlimento"));
                produto.setNomeProduto(resultado.getString("a.nome"));

                listaProduto.add(produto);
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
        return listaProduto;
    }

    public Produto getByName(String nomeProduto) {
        Connection conexao = this.getConnection();

        Produto pro = new Produto();

        try {
            PreparedStatement preparacao = conexao.prepareStatement(SQL_GET_BY_NAME_PRODUTO);
            preparacao.setString(1, nomeProduto);
            ResultSet resultado = preparacao.executeQuery();

            while (resultado.next()) {
                pro.setIdProduto(resultado.getInt("idProduto"));
                pro.setNomeProduto(resultado.getString("nomeProduto"));

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
        return pro;
    }

  
}
