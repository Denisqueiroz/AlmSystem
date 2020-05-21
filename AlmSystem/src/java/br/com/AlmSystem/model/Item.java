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
    private Integer saldoItem;
    private Date dataValidadeItem;
    private Date dataCompraItem;
    private Date dataEntrada ;
    private String notafiscal;
    private Integer totalItem;
    private Integer retirada;
    private Produto produto;

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
     * @return the saldoItem
     */
    public Integer getSaldoItem() {
        return saldoItem;
    }

    /**
     * @param saldoItem the saldoItem to set
     */
    public void setSaldoItem(Integer saldoItem) {
        this.saldoItem = saldoItem;
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
     * @return the retirada
     */
    public Integer getRetirada() {
        return retirada;
    }

    /**
     * @param retirada the retirada to set
     */
    public void setRetirada(Integer retirada) {
        this.retirada = retirada;
    }

    
}
