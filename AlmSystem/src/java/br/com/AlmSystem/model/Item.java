/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.AlmSystem.model;

import java.util.Date;

/**
 *
 * @author TBO-002
 */
public class Item {

    private Integer idItem;
    private Integer quantidadeItem;
    private Date dataValidadeItem;
    private Date dataCompraItem;
    private Date dataEntrada;
    private String notafiscal;
    private Integer totalItem;
    private Produto produto;
    private Integer retiradaItem ;
    private Integer operacaoItem ;

    public Item() {
    }

    public Item(Integer idItem, Produto produto) {
        this.idItem = idItem;
        this.produto = produto;
    }

    /**
     * @return the idItem
     */
    public Integer getIdItem() {
        return idItem;
    }

    /**
     * @param idItem the idItem to set
     */
    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    /**
     * @return the quantidadeItem
     */
    public Integer getQuantidadeItem() {
        return quantidadeItem;
    }

    /**
     * @param quantidadeItem the quantidadeItem to set
     */
    public void setQuantidadeItem(Integer quantidadeItem) {
        this.quantidadeItem = quantidadeItem;
    }

    /**
     * @return the dataValidadeItem
     */
    public Date getDataValidadeItem() {
        return dataValidadeItem;
    }

    /**
     * @param dataValidadeItem the dataValidadeItem to set
     */
    public void setDataValidadeItem(Date dataValidadeItem) {
        this.dataValidadeItem = dataValidadeItem;
    }

    /**
     * @return the dataCompraItem
     */
    public Date getDataCompraItem() {
        return dataCompraItem;
    }

    /**
     * @param dataCompraItem the dataCompraItem to set
     */
    public void setDataCompraItem(Date dataCompraItem) {
        this.dataCompraItem = dataCompraItem;
    }

    /**
     * @return the dataEntrada
     */
    public Date getDataEntrada() {
        return dataEntrada;
    }

    /**
     * @param dataEntrada the dataEntrada to set
     */
    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    /**
     * @return the notafiscal
     */
    public String getNotafiscal() {
        return notafiscal;
    }

    /**
     * @param notafiscal the notafiscal to set
     */
    public void setNotafiscal(String notafiscal) {
        this.notafiscal = notafiscal;
    }

    /**
     * @return the totalItem
     */
    public Integer getTotalItem() {
        return totalItem;
    }

    /**
     * @param totalItem the totalItem to set
     */
    public void setTotalItem(Integer totalItem) {
        this.totalItem = totalItem;
    }

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * @return the retiradaItem
     */
    public Integer getRetiradaItem() {
        return retiradaItem;
    }

    /**
     * @param retiradaItem the retiradaItem to set
     */
    public void setRetiradaItem(Integer retiradaItem) {
        this.retiradaItem = retiradaItem;
    }

    /**
     * @return the operacaoItem
     */
    public Integer getOperacaoItem() {
        return operacaoItem;
    }

    /**
     * @param operacaoItem the operacaoItem to set
     */
    public void setOperacaoItem(Integer operacaoItem) {
        this.operacaoItem = operacaoItem;
    }

    /**
     * @return the retirada
     */
}
