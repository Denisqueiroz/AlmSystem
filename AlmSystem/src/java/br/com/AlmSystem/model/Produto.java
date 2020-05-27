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
    private Marca marca;
    private Fornecedor fornecedor;
    private Unidade unidade;
    private Integer descUnidade;

    public Produto() {
    }

    public Produto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Produto(Integer idProduto, String descricaoProduto, Marca idMarca, Fornecedor idFornecedor, Unidade idUnidade, Integer descUnidade) {
        this.idProduto = idProduto;
        this.descricaoProduto = descricaoProduto;
        this.marca = idMarca;
        this.fornecedor = idFornecedor;
        this.unidade = idUnidade;
        this.descUnidade = descUnidade;
    }

    public Produto(Integer idProduto, String descricaoProduto) {
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
     * @return the marca
     */
    public Marca getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    /**
     * @return the fornecedor
     */
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    /**
     * @return the unidade
     */
    public Unidade getUnidade() {
        return unidade;
    }

    /**
     * @param unidade the unidade to set
     */
    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
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
