/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.AlmSystem.DAO;

import br.com.AlmSystem.model.Pessoa;
import br.com.AlmSystem.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Suporte
 */
public class PessoaDAOImpl {

    protected Connection conn;

    public PessoaDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public int cadastrar(Pessoa pessoa) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer id = null;
        String sql = "INSERT INTO public.pessoa( tipo, nome, telefone, email, cep, uf, cidade, logadoro,"
                + " bairro, numero, pais)\n"
                + "	VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id_pessoa";

        try {
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, pessoa.getTipoPessoa());
            stmt.setString(2, pessoa.getNomePessoa());
            stmt.setString(3, pessoa.getTelefonePessoa());
            stmt.setString(4, pessoa.getEmailPessoa());
            stmt.setString(5, pessoa.getCepPessoa());
            stmt.setString(6, pessoa.getCidadePessoa());
            stmt.setString(7, pessoa.getUfPessoa());
            stmt.setString(8, pessoa.getBairroPessoa());
            stmt.setString(9, pessoa.getLogadoroPessoa());
            stmt.setString(10, pessoa.getNumeroPessoa());
            stmt.setString(11, pessoa.getPaisPessoa());

            rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id_pessoa");
            }
        } catch (SQLException e) {
            System.out.println("Problemas ao cadastrar nova Pessoa. Erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar a conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return id;

    }

    public Boolean alterar(Object object) {

        Pessoa pessoa = (Pessoa) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE pessoa  SET   tipo=?, nome=?, telefone=?, email=?, cep=?, uf=?,\n"
                + "	cidade=?, logadoro=?, bairro=?, numero=?, pais=? WHERE id_pessoa=?  ;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getTipoPessoa());
            stmt.setString(2, pessoa.getNomePessoa());
            stmt.setString(3, pessoa.getTelefonePessoa());
            stmt.setString(4, pessoa.getEmailPessoa());
            stmt.setString(5, pessoa.getCepPessoa());
            stmt.setString(6, pessoa.getUfPessoa());
            stmt.setString(7, pessoa.getCidadePessoa());
            stmt.setString(8, pessoa.getLogadoroPessoa());
            stmt.setString(9, pessoa.getBairroPessoa());
            stmt.setString(10, pessoa.getNumeroPessoa());
            stmt.setString(11, pessoa.getPaisPessoa());
            stmt.setInt(12, pessoa.getIdPessoa());

            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar PessoaDAO! Erro: " + ex.getMessage());
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

}
