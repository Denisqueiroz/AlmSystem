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
public class Fornecedor  extends Pessoa {
    
    private Integer idFornecedor ;
    private String cnpj ;
    private String inscricaoEstadual ;

    public Fornecedor() {
    }

    public Fornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Fornecedor(Integer idFornecedor, String nomePessoa) {
       this.idFornecedor = idFornecedor;
       this.nomePessoa = nomePessoa ;
    }

        
       
    /**
     * @return the idFornecedor
     */
    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    /**
     * @param idFornecedor the idFornecedor to set
     */
    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the inscricaoEstadual
     */
    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    /**
     * @param inscricaoEstadual the inscricaoEstadual to set
     */
    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    
}
