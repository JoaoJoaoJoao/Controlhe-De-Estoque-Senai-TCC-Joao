package entity;

public class Fornecedor extends Endereco {

    private int idFornecedor;
    private String nomeFornecedor;
    private String telefoneFornecedor;
    private int cnpj;
    private String nomeContatoFornecedor;
    private int inscricaoEstadual;

    public int getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(int inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getNomeContatoFornecedor() {
        return nomeContatoFornecedor;
    }

    public void setNomeContatoFornecedor(String nomeContatoFornecedor) {
        this.nomeContatoFornecedor = nomeContatoFornecedor;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getTelefoneFornecedor() {
        return telefoneFornecedor;
    }

    public void setTelefoneFornecedor(String telefoneFornecedor) {
        this.telefoneFornecedor = telefoneFornecedor;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

}
