/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.AlmSystem.DAO;

import br.com.AlmSystem.model.Fornecedor;
import br.com.AlmSystem.model.Marca;
import br.com.AlmSystem.model.Produto;
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
 * @author TBO-002
 */
public class ProdutoDAOImpl  implements GenericDAO {

    private Connection conn;

    public ProdutoDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Produto produto = (Produto) object;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO produto( descricao, id_uni, id_marca, id_forne) \n" +
                       " VALUES (?, ?, ?, ?  ) ";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getDescricaoProduto());
            stmt.setInt(2, produto.getIdUnidade().getIdUnidade());
            stmt.setInt(3, produto.getIdMarca().getIdMarca());
            stmt.setInt(4, produto.getIdFornecedor().getIdFornecedor());

            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Problemas ao cadastrar Produto DAO! Erro: " + e.getMessage());
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
    public List<Object> listar()  {
        List<Object> produtos = new ArrayList<Object>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT p.*,u.*,m.*,f.*,pe.nome from produto p\n"
                + "inner join unidade u on p.id_uni = u.id_uni\n"
                + "inner join marca m on p.id_marca = m.id_marca\n"
                + "inner join fornecedor f on p.id_forne = f.id_forne\n"
                + "inner join pessoa pe on f.id_pessoa = pe.id_pessoa ";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("id_prod"));
                produto.setDescricaoProduto(rs.getString("descricao"));                            
                produto.setIdUnidade(new Unidade(rs.getInt("id_uni"), rs.getString("descricao")));
                produto.setIdMarca(new Marca(rs.getInt("id_marca"), rs.getString("nome_marca")));
                produto.setIdFornecedor(new Fornecedor(rs.getInt("id_forne"), rs.getString("nome")));
               
                
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Produtos! Erro: " + ex.getMessage());
            ex.printStackTrace();

        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
            }
        }
        return produtos;
    }

    @Override
    public Boolean excluir(int idObject)  {
        PreparedStatement stmt = null;
        String sql = "DELETE FROM produto WHERE id_prod = ?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir Produto! Erro: " + ex.getMessage());
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
    public Boolean alterar(Object object) {

        Produto produto = (Produto) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE produto SET  descricao = ?,"
                + "id_uni=?, id_marca=?, id_forne=?  WHERE id_prod = ? ";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getDescricaoProduto());
            stmt.setInt(2,produto.getIdUnidade().getIdUnidade());
            stmt.setInt(3, produto.getIdMarca().getIdMarca());
            stmt.setInt(4, produto.getIdFornecedor().getIdFornecedor());
            stmt.setInt(5, produto.getIdProduto());
            
            

            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar Produto! Erro: " + ex.getMessage());
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
    public Object carregar(int idObject) {
        Produto produto = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = " select * from produto where id_prod = ?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            if (rs.next()) {
                produto = new Produto();
                produto.setIdProduto(rs.getInt("id_prod"));
                produto.setDescricaoProduto(rs.getString("descricao"));
               

            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar Produto! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar a conexão! Erro:" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return produto;
    }
}


