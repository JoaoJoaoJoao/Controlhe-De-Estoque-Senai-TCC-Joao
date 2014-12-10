package entity;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import javax.swing.JOptionPane;

public class Produto {

    private Integer idProduto;
    private String nomeProduto;
    private double custoProduto;
    private double valorProduto;
    private int estoqueIdeal;
    private int estoqueMin;
    private int unidade;
    private String categoria;
    private int estoqueRetirado;

    
    
    public void AtualizaEstoque ( int estoqueIdeal, int estoqueRetirado){
        estoqueIdeal = estoqueIdeal - estoqueRetirado;
    }
    
    public int getEstoqueRetirado() {
        return estoqueRetirado;
    }

    public void setEstoqueRetirado(int estoqueRetirado) {
        this.estoqueRetirado = estoqueRetirado;
    }

    public String Estoque(int estoqueIdeal, int estoqueRetirado) {
        if (estoqueIdeal < estoqueRetirado == true) {

        }

        return "Estoque inferior a quantidade desejada";
    }

    public String VerificaQuantidade(int estoqueIdeal, int estoqueMin) {

        if (estoqueIdeal < estoqueMin == true) {

        }
        return "Estoque Ideal tem que ser maior que estoque Mínimo";

    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getUnidade() {
        return unidade;
    }

    public void setUnidade(int unidade) {
        this.unidade = unidade;
    }

    public int getEstoqueIdeal() {
        return estoqueIdeal;
    }

    public void setEstoqueIdeal(int estoqueIdeal) {
        this.estoqueIdeal = estoqueIdeal;
    }

    public int getEstoqueMin() {
        return estoqueMin;
    }

    public void setEstoqueMin(int estoqueMin) {
        this.estoqueMin = estoqueMin;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getCustoProduto() {
        return custoProduto;
    }

    public void setCustoProduto(double custoProduto) {
        this.custoProduto = custoProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public static void salvar(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
