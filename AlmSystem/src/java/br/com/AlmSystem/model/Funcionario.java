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
public class Funcionario extends Pessoa{

    private Integer idFuncionario;
    private String cpfFuncionario;
    private String loginFuncionario;
    private String senhaFuncionario;

    /**
     * @return the idFuncionario
     */
    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * @param idFuncionario the idFuncionario to set
     */
    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    /**
     * @return the cpfFuncionario
     */
    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    /**
     * @param cpfFuncionario the cpfFuncionario to set
     */
    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    /**
     * @return the loginFuncionario
     */
    public String getLoginFuncionario() {
        return loginFuncionario;
    }

    /**
     * @param loginFuncionario the loginFuncionario to set
     */
    public void setLoginFuncionario(String loginFuncionario) {
        this.loginFuncionario = loginFuncionario;
    }

    /**
     * @return the senhaFuncionario
     */
    public String getSenhaFuncionario() {
        return senhaFuncionario;
    }

    /**
     * @param senhaFuncionario the senhaFuncionario to set
     */
    public void setSenhaFuncionario(String senhaFuncionario) {
        this.senhaFuncionario = senhaFuncionario;
    }

   
    
}
