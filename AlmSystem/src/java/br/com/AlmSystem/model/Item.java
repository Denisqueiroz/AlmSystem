/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.AlmSystem.model;

/**
 *
 * @author TBO-002
 */
public class Item {
    
    private Integer idItem;
    private Integer saldoItem;
    private String dataValidadeItem;
    private String dataCompraItem;
    private Integer totalItem ;
    private Produto idProduto;

    public Item() {
    }

    public Item(Integer idItem) {
        this.idItem = idItem;
    }

    public Item(Integer idItem, Integer saldoItem, String dataValidadeItem, String dataCompraItem,Integer totalItem, Produto idProduto) {
        this.idItem = idItem;
        this.saldoItem = saldoItem;
        this.dataValidadeItem = dataValidadeItem;
        this.dataCompraItem = dataCompraItem;
        this.totalItem = totalItem ;
        this.idProduto = idProduto;
    }

    public Item(Integer idItem, Integer saldoItem, String dataCompraItem, String dataValidadeItem ) {
        this.idItem = idItem;
        this.saldoItem = saldoItem;
        this.dataCompraItem = dataCompraItem ;
        this.dataValidadeItem = dataValidadeItem;
        this.idProduto = idProduto;
       
    }

    public Item(Produto idProduto) {
        this.idProduto = idProduto;
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
    public String getDataValidadeItem() {
        return dataValidadeItem;
    }

    /**
     * @param dataValidadeItem the dataValidadeItem to set
     */
    public void setDataValidadeItem(String dataValidadeItem) {
        this.dataValidadeItem = dataValidadeItem;
    }

    /**
     * @return the dataCompraItem
     */
    public String getDataCompraItem() {
        return dataCompraItem;
    }

    /**
     * @param dataCompraItem the dataCompraItem to set
     */
    public void setDataCompraItem(String dataCompraItem) {
        this.dataCompraItem = dataCompraItem;
    }

    /**
     * @return the idProduto
     */
    public Produto getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
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

   
}