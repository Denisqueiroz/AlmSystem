/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.AlmSystem.model;

/**
 *
 * @author Suporte
 */
public class Unidade {

    private Integer idUnidade;
    private String descUnidade;

    public Unidade() {
    }

    public Unidade(Integer idUnidade) {
        this.idUnidade = idUnidade;
    }

    public Unidade(Integer idUnidade, String descUnidade) {
        this.idUnidade = idUnidade;
        this.descUnidade = descUnidade;
    }

    public Integer getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Integer idUnidade) {
        this.idUnidade = idUnidade;
    }

    public String getDescUnidade() {
        return descUnidade;
    }

    public void setDescUnidade(String descUnidade) {
        this.descUnidade = descUnidade;
    }

}
