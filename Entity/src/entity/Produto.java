package entity;

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
  
    
    
    public String VerificaQuantidade (int estoqueIdeal, int estoqueMin){
       
        if (estoqueIdeal < estoqueMin == true){
           
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
