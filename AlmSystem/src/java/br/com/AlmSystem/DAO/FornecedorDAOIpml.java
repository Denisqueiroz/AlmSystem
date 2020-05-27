/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.AlmSystem.DAO;

import br.com.AlmSystem.model.Fornecedor;
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
public class FornecedorDAOIpml implements GenericDAO {

    private Connection conn;

    public FornecedorDAOIpml() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {

        Fornecedor fornecedor = (Fornecedor) object;
        PreparedStatement stmt = null;
        String sql = "  INSERT INTO fornecedor(inscricao_social , cnpj, id_pessoa) VALUES (?, ?, ?)";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, fornecedor.getInscricaoEstadual());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setInt(3, new PessoaDAOImpl().cadastrar(fornecedor));
            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Problemas ao cadastrar Fornecedor! Erro: " + e.getMessage());
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
    public List<Object> listar() {
        List<Object> fornecedores = new ArrayList<Object>();
        PreparedStatement stmt = null; //construindo o caminho até o banco
        ResultSet rs = null; // resultSet guardar dados vindos de um banco
        String sql = "select f.*,p.* from fornecedor f\n"
                + "inner join pessoa p on p.id_pessoa = f.id_pessoa ";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setIdFornecedor(rs.getInt("id_forne"));
                fornecedor.setInscricaoEstadual(rs.getString("inscricao_social"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setIdPessoa(rs.getInt("id_pessoa"));
                fornecedor.setTipoPessoa(rs.getString("tipo"));
                fornecedor.setNomePessoa(rs.getString("nome"));
                fornecedor.setTelefonePessoa(rs.getString("telefone"));
                fornecedor.setEmailPessoa(rs.getString("email"));
                fornecedor.setCepPessoa(rs.getString("cep"));
                fornecedor.setUfPessoa(rs.getString("uf"));
                fornecedor.setCidadePessoa(rs.getString("cidade"));
                fornecedor.setLogadoroPessoa(rs.getString("logadoro"));
                fornecedor.setBairroPessoa(rs.getString("bairro"));
                fornecedor.setNumeroPessoa(rs.getString("numero"));
                fornecedor.setPaisPessoa(rs.getString("pais"));

                fornecedores.add(fornecedor);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar o Fornecedor! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);

            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmentros de conexão:  ERRO " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return fornecedores;
    }

    @Override
    public Boolean excluir(int idObject) {
        PreparedStatement stmt = null;
        String sql = "DELETE FROM fornecedor  WHERE id_forne = ? ;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir Fornecedor! Erro: " + ex.getMessage());
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmentros de conexão! erro: " + ex.getMessage());
            }
        }
    }

    @Override
    public Boolean alterar(Object object) throws Exception {
        Fornecedor fornecedor = (Fornecedor) object;
        PreparedStatement stmt = null;
        String sql = " update fornecedor set  inscricao_social=?, cnpj=?  where id_forne=?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, fornecedor.getInscricaoEstadual());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setInt(3, new PessoaDAOImpl().cadastrar(fornecedor));
            stmt.execute();

            if (new PessoaDAOImpl().alterar(fornecedor)) {
                stmt.executeUpdate();
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar fornecedor DAO! Erro: " + ex.getMessage());
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
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Fornecedor fornecedor = null;
        String sql = "select f.*,p.* from fornecedor f\n"
                + "inner join pessoa p on p.id_pessoa = f.id_pessoa where f.id_forne = ? ";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {

                fornecedor = new Fornecedor();

                fornecedor.setIdFornecedor(rs.getInt("id_forne"));
                fornecedor.setInscricaoEstadual(rs.getString("inscricao_social"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setIdPessoa(rs.getInt("id_pessoa"));
                fornecedor.setTipoPessoa(rs.getString("tipo"));
                fornecedor.setNomePessoa(rs.getString("nome"));
                fornecedor.setTelefonePessoa(rs.getString("telefone"));
                fornecedor.setEmailPessoa(rs.getString("email"));
                fornecedor.setCepPessoa(rs.getString("cep"));
                fornecedor.setUfPessoa(rs.getString("uf"));
                fornecedor.setCidadePessoa(rs.getString("cidade"));
                fornecedor.setLogadoroPessoa(rs.getString("logadoro"));
                fornecedor.setBairroPessoa(rs.getString("bairro"));
                fornecedor.setNumeroPessoa(rs.getString("numero"));
                fornecedor.setPaisPessoa(rs.getString("pais"));

            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao Carregar Para carregar o Fornecedor !!! ERRO: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar a conexão!!! ERRO: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return fornecedor;
    }
}
