/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.AlmSystem.model;

/**
 *
 * @author Opa
 */
public class Produto {

    private Integer idProduto;
    private String descricaoProduto;
    private Marca idMarca;
    private Fornecedor idFornecedor;
    private Unidade idUnidade;
    private Integer descUnidade;

    public Produto() {
    }

    public Produto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Produto(Integer idProduto, String descricaoProduto, Marca idMarca, Fornecedor idFornecedor, Unidade idUnidade, Integer descUnidade) {
        this.idProduto = idProduto;
        this.descricaoProduto = descricaoProduto;
        this.idMarca = idMarca;
        this.idFornecedor = idFornecedor;
        this.idUnidade = idUnidade;
        this.descUnidade = descUnidade;
    }

    public Produto(Integer idProduto,  String descricaoProduto ) {
       this.idProduto = idProduto;
       this.descricaoProduto = descricaoProduto;
    }
    
    
    

    /**
     * @return the idProduto
     */
    public Integer getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return the descricaoProduto
     */
    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    /**
     * @param descricaoProduto the descricaoProduto to set
     */
    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    /**
     * @return the idMarca
     */
    public Marca getIdMarca() {
        return idMarca;
    }

    /**
     * @param idMarca the idMarca to set
     */
    public void setIdMarca(Marca idMarca) {
        this.idMarca = idMarca;
    }

    /**
     * @return the idFornecedor
     */
    public Fornecedor getIdFornecedor() {
        return idFornecedor;
    }

    /**
     * @param idFornecedor the idFornecedor to set
     */
    public void setIdFornecedor(Fornecedor idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    /**
     * @return the idUnidade
     */
    public Unidade getIdUnidade() {
        return idUnidade;
    }

    /**
     * @param idUnidade the idUnidade to set
     */
    public void setIdUnidade(Unidade idUnidade) {
        this.idUnidade = idUnidade;
    }

    /**
     * @return the descUnidade
     */
    public Integer getDescUnidade() {
        return descUnidade;
    }

    /**
     * @param descUnidade the descUnidade to set
     */
    public void setDescUnidade(Integer descUnidade) {
        this.descUnidade = descUnidade;
    }

}
