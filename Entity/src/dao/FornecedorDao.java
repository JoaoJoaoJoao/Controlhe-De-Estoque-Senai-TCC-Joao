/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;


import entity.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joao_victor1
 */
public class FornecedorDao  extends MySQL{
    
    private static final String SQL_INSERIR_FORNECEDOR= "INSERT INTO  ProjetoTCC.Fornecedor(nomeFornecedor,telefoneForncedor,cnpj,inscricaoEstadual,nomeContatoFornecedor) VALUES (?,?,?,?,?,?)";
    private static final String SQL_EDITAR_FORNECEDOR = "UPDATE ProjetoTCC.Fornecedor SET nomeFornecedor = ? WHERE idFornecedor = ?";
    private static final String SQL_DELETAR_FORNECEDOR = "DELETE FROM ProjetoTCC.Fornecedor WHERE idFornecedor = ?";
    private static final String SQL_GET_BY_ID_FORNECEDOR = "SELECT idFornecedor, nomeFornecedor FROM ProjetoTCC.Fornecedor WHERE idFornecedor = ?";
    private static final String SQL_GET_ALL_FORNECEDOR = "SELECT a.idAlimento, a.nome, ca.idCategoriaAlimentos, ca.nome FROM alimento as a LEFT JOIN alimentoCategoriaAlimentos as aca ON a.idAlimento = aca.idAlimento LEFT JOIN CategoriaAlimentos as ca ON aca.idCategoriaAlimentos  = ca.idCategoriaAlimentos";

    public boolean insert(Fornecedor fornecedor) {

        Connection conexao = this.getConnection();
        ResultSet generatedKeys = null;

        try {
            PreparedStatement preparacao = conexao.prepareStatement(SQL_INSERIR_FORNECEDOR, PreparedStatement.RETURN_GENERATED_KEYS);

            preparacao.setString(1, fornecedor.getNomeFornecedor());
            preparacao.setString(2, fornecedor.getTelefoneFornecedor());
           preparacao.setInt(3, fornecedor.getCnpj());
            preparacao.setInt(4, fornecedor.getInscricaoEstadual());
           preparacao.setString(5, fornecedor.getNomeContatoFornecedor());
           preparacao.execute(); //Executndo o PreparedStatement

            //pego o id da inserção
            generatedKeys = preparacao.getGeneratedKeys();

            //adiciono o id ao objeto
            if (generatedKeys.next()) {
                fornecedor.setIdFornecedor(generatedKeys.getInt(1));
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

    public boolean update(Fornecedor fornecedor) {
        Connection conexao = this.getConnection();
        try {

            PreparedStatement preparacao = conexao.prepareStatement(SQL_EDITAR_FORNECEDOR);

            preparacao.setString(1, fornecedor.getNomeFornecedor());

            preparacao.setInt(2, fornecedor.getIdFornecedor());

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

    public boolean delete(Fornecedor fornecedor) {
        Connection conexao = this.getConnection();
        try {

            PreparedStatement preparacao = conexao.prepareStatement(SQL_DELETAR_FORNECEDOR);

            preparacao.setInt(1, fornecedor.getIdFornecedor());

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

    public Fornecedor getById(int id) {

        Connection conexao = this.getConnection();

        Fornecedor fornecedor = new Fornecedor();

        try {
            PreparedStatement preparacao = conexao.prepareStatement(SQL_GET_BY_ID_FORNECEDOR);

            preparacao.setInt(1, id);

            ResultSet resultado = preparacao.executeQuery();

            while (resultado.next()) {

                fornecedor.setIdFornecedor(resultado.getInt("idFornecedor"));
                fornecedor.setNomeFornecedor(resultado.getString("nomeFornecedor"));

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
        return fornecedor;
    }

    public List<Fornecedor> getAll() {
        List<Fornecedor> listaFornecedor = new ArrayList();
        Connection conexao = this.getConnection();
        try {

            PreparedStatement preparacao = conexao.prepareStatement(SQL_GET_ALL_FORNECEDOR);
            ResultSet resultado = preparacao.executeQuery();

            while (resultado.next()) {
               Fornecedor fornecedor = new Fornecedor();

                fornecedor.setIdFornecedor(resultado.getInt("idFornecedor"));
                fornecedor.setNomeFornecedor(resultado.getString("nomeFornecedor"));

                listaFornecedor.add(fornecedor);
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
        return listaFornecedor;
    }

    
}
