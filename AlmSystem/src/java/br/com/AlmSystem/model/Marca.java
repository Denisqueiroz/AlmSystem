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
public class Marca {

    private Integer IdMarca;
    private String nomeMarca;

    public Marca() {
    }

    public Marca(Integer IdMarca) {
        this.IdMarca = IdMarca;
    }

    public Marca(Integer IdMarca, String nomeMarca) {
        this.IdMarca = IdMarca;
        this.nomeMarca = nomeMarca;
    }

    /**
     * @return the IdMarca
     */
    public Integer getIdMarca() {
        return IdMarca;
    }

    /**
     * @param IdMarca the IdMarca to set
     */
    public void setIdMarca(Integer IdMarca) {
        this.IdMarca = IdMarca;
    }

    /**
     * @return the nomeMarca
     */
    public String getNomeMarca() {
        return nomeMarca;
    }

    /**
     * @param nomeMarca the nomeMarca to set
     */
    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }

}
