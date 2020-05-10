/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.AlmSystem.DAO;

import java.util.List;

/**
 *
 * @author Suporte
 */
public interface GenericDAO {
    
    public Boolean cadastrar(Object object) throws Exception ;;
    public List<Object> listar() throws Exception;;
    public Boolean excluir(int idObject) throws Exception;;
    public Boolean alterar(Object object) throws Exception;;
    public Object carregar(int idObject) throws Exception;;
//    public List<Object> SomaQuantidade() throws Exception;;
      
}
