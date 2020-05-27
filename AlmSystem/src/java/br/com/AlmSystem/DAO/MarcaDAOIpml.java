/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.AlmSystem.DAO;

import br.com.AlmSystem.model.Marca;
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
public class MarcaDAOIpml implements GenericDAO {

    private Connection conn;

    public MarcaDAOIpml() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Marca marca = (Marca) object;
        PreparedStatement stmt = null;

        String sql = "insert into marca (nome_marca )"
                + " values (?)";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, marca.getNomeMarca());

            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Problemas ao cadastrar Marca! Erro: " + e.getMessage());
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar a conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

    }

    @Override
    public List<Object> listar() {
        List<Object> marcas = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM marca order by nome_marca;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Marca marca = new Marca();
                marca.setIdMarca(rs.getInt("id_marca"));
                marca.setNomeMarca(rs.getString("nome_marca"));

                marcas.add(marca);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar a marca DAOImpl! Erro: " + ex.getMessage());

        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return marcas;
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
        Marca marca = null;
        String sql = "  select * from marca where id_marca = ? ";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                marca = new Marca();
                marca.setIdMarca(rs.getInt("id_marca"));
                marca.setNomeMarca(rs.getString("nome_marca"));

            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar a marca DAOImpl");
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar a conexão");
                ex.printStackTrace();
            }
        }
        return marca;

    }
}
