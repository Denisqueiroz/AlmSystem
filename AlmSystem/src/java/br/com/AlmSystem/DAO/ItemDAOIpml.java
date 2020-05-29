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

    public ItemDAOIpml() {
        try {
            this.conn = ConnectionFactory.getConnection();
        } catch (Exception ex) {
            System.out.println("Problemas ao conectar ao BD! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public Boolean cadastrar(Object object) throws Exception {
        Item item = (Item) object;
        PreparedStatement stmt = null;

        String sql = "  INSERT INTO item(quantidade, data_compra, data_validade,"
                + "  id_prod, notafiscal)VALUES ( ?, ?, ?, ?, ?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, item.getQuantidadeItem());
            stmt.setDate(2, new java.sql.Date(item.getDataCompraItem().getTime()));
            stmt.setDate(3, new java.sql.Date(item.getDataValidadeItem().getTime()));
            stmt.setInt(4, item.getProduto().getIdProduto());
            stmt.setString(5, item.getNotafiscal());
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
                + "inner join produto p on i.id_prod = p.id_prod";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {

                Item item = new Item();

                item.setIdItem(rs.getInt("id_item"));
                item.setQuantidadeItem(rs.getInt("quantidade"));
                item.setDataCompraItem(rs.getDate("data_compra"));
                item.setDataValidadeItem(rs.getDate("data_validade"));
                item.setDataEntrada(rs.getDate("data_entrada"));
                item.setProduto(new Produto(rs.getInt("id_prod"), rs.getString("descricao")));

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
        String sql = "UPDATE item SET  quantidade=?, data_compra=?, data_validade=?, id_prod=?,"
                + " notafiscal=? WHERE id_item = ?;";

        try {
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, item.getQuantidadeItem());
            stmt.setDate(2, new java.sql.Date(item.getDataCompraItem().getTime()));
            stmt.setDate(3, new java.sql.Date(item.getDataValidadeItem().getTime()));
            stmt.setInt(4, item.getProduto().getIdProduto());
            stmt.setString(5, item.getNotafiscal());
            stmt.setInt(6, item.getIdItem());

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
        String sql = "select i.*, p.descricao  from Item i\n"
                + " inner join produto p on p.id_prod =i. id_prod\n"
                + "  where id_item = ?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {

                item = new Item();
                item.setIdItem(rs.getInt("id_item"));
                item.setQuantidadeItem(rs.getInt("quantidade"));
                item.setDataCompraItem(rs.getDate("data_compra"));
                item.setDataValidadeItem(rs.getDate("data_validade"));
                item.setProduto(new Produto(rs.getInt("id_prod"),rs.getString("descricao")));

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
        Item item = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT Sum(quantidade) as quantidade from item where id_prod = ? ";

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

    public void AtualizarQuantidade(int idItem, int retiradaItem,  int operacaoItem ) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = " select retirar_quantidade(?, ?, ?); ";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idItem);
            stmt.setInt(2, retiradaItem);
             stmt.setInt(3, operacaoItem);
            rs = stmt.executeQuery();

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

    }

}
