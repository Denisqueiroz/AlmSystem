/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.AlmSystem.DAO;

import br.com.AlmSystem.model.Item;
import br.com.AlmSystem.model.Produto;
import br.com.AlmSystem.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TBO-002
 */
public class ItemDAOIpml implements GenericDAO {

    private Connection conn;

    public ItemDAOIpml() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) throws Exception {
        Item item = (Item) object;
        PreparedStatement stmt = null;

        String sql = "  INSERT INTO item ( quantidade, data_compra, data_validade,"
                + " id_prod ) VALUES (?, ?, ?, ?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, item.getSaldoItem());
            stmt.setString(2, item.getDataCompraItem());
            stmt.setString(3, item.getDataValidadeItem());
            stmt.setInt(4, item.getIdProduto().getIdProduto());

            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Problemas ao cadastrar Item! Erro: " + e.getMessage());
            e.printStackTrace();
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
    public List<Object> listar() throws Exception {
        List<Object> items = new ArrayList<Object>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select i.*,p.* from item i\n"
                + "inner join  produto p on p.id_prod = p.id_prod \n"
                + "inner join fornecedor f on p.id_forne = f.id_forne";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {

                Item item = new Item();

                item.setIdItem(rs.getInt("id_item"));
                item.setSaldoItem(rs.getInt("quantidade"));
                item.setDataCompraItem(rs.getString("data_compra"));
                item.setDataValidadeItem(rs.getString("data_validade"));
                item.setIdProduto(new Produto(rs.getInt("id_prod"), rs.getString("descricao")));

                items.add(item);

            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar o Item! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);

            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmentros de conexão:  ERRO " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return items;
    }

    @Override
    public Boolean excluir(int idObject) throws Exception {
        PreparedStatement stmt = null;
        String sql = "DELETE FROM item WHERE id_item = ?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir Item! Erro: " + ex.getMessage());
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
            }
        }
    }

    @Override
    public Boolean alterar(Object object) throws Exception {
        Item item = (Item) object;
        PreparedStatement stmt = null;
        String sql = " update item set  quantidade = ?,data_compra = ? "
                + " data_vencimento = ? , id_prod = ?  where id_item=?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, item.getSaldoItem());
            stmt.setString(2, item.getDataCompraItem());
            stmt.setString(3, item.getDataValidadeItem());
            stmt.setInt(4, item.getIdProduto().getIdProduto());
            stmt.execute();

            if (new ItemDAOIpml().alterar(item)) {
                stmt.executeUpdate();
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar ItemDAO! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {

            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Object carregar(int idObject) throws Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Item item = null;
        String sql = "select * from Item  where id_item = ?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {

                item = new Item();
                item.setIdItem(rs.getInt("id_item"));
                item.setSaldoItem(rs.getInt("quantidade"));
                item.setDataCompraItem(rs.getString("data_compra"));
                item.setDataValidadeItem(rs.getString("data_validade"));
                item.setIdProduto(new Produto(rs.getInt("id_prod")));

            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao Carregar Para carregar o Item !!! ERRO: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar a conexão!!! ERRO: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return item;
    }

     public Item SomaQuantidade(int idProduto) {
        Item item = null ;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT Sum(quantidade) as quantidade from item where id_prod = ? " ;
                    
               
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idProduto);
            rs = stmt.executeQuery();
            while (rs.next()) {
              item = new Item();
                item.setTotalItem(rs.getInt("quantidade"));
               

            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao contar o Item! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);

            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmentros de conexão:  ERRO " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return item;

    }

}
