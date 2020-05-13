/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.AlmSystem.DAO;

import br.com.AlmSystem.model.Unidade;
import br.com.AlmSystem.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Suporte
 */
public class UnidadeDAOImpl implements GenericDAO {

    private Connection conn;

    public UnidadeDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object)  {
         Unidade unidade = (Unidade) object ; 
        PreparedStatement stmt = null;

        String sql = "insert into unidade (descricao_uni)"
                + " values (?)";
               
         try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, unidade.getDescUnidade());
           
            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Problemas ao cadastrar Unidade! Erro: " + e.getMessage());
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar a conexão! Erro: " + ex.getMessage());
            }
        }
    }

    @Override
     public List<Object> listar() throws Exception {
       List<Object> unidades = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM unidade order by descricao_uni ;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Unidade unidade = new Unidade();
                unidade.setIdUnidade(rs.getInt("id_uni"));
                unidade.setDescUnidade(rs.getString("descricao_uni"));

                unidades.add(unidade);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar a unidade DAOImpl! Erro: " + ex.getMessage());

        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
            }
        }
        return unidades;
    }

    @Override
    public Boolean excluir(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean alterar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object carregar(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Unidade unidade = null;
         String sql = "select  * from unidade where id_uni = ?" ;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                unidade = new Unidade();
                unidade.setIdUnidade(rs.getInt("id_uni"));
                unidade.setDescUnidade(rs.getString("descricao_uni"));

            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar a unidade de medida DAOImpl");
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar a conexão");
            }
        }
        return unidade;
    
    
    }

}