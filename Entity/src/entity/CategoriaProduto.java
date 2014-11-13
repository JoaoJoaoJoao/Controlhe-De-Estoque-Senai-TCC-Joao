
package entity;


public class CategoriaProduto {
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
