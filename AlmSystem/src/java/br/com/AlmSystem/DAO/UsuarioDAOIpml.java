/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.AlmSystem.DAO;

import br.com.AlmSystem.model.Usuario;
import br.com.AlmSystem.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author TBO-002
 */
public class UsuarioDAOIpml implements GenericDAO {

    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement stmt = null;

    public UsuarioDAOIpml() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public Boolean cadastrar(Object object) {
        Usuario usuario = (Usuario) object;
        PreparedStatement stmt = null;

        String sql = "INSERT INTO usuario( login, senha, id_pessoa) VALUES (?, ?, ?)";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getLoginUsuario());
            stmt.setString(2, usuario.getSenhaUsuario());
            stmt.setInt(3, new PessoaDAOImpl().cadastrar(usuario));
            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Problemas ao cadastrar Usuário! Erro: " + e.getMessage());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean excluir(int idObject) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean alterar(Object object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object carregar(int idObject) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Usuario logarUsuario(String email, String senha) {

        Usuario usuario = null;

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "INSERT INTO usuario(login, senha) VALUES (? , ? ); ";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

            if (rs.next()) {

                usuario = new Usuario();
                usuario.setLoginUsuario(rs.getString("login"));
                usuario.setSenhaUsuario(rs.getString("senha"));

            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao logar Pessoa! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

        return usuario;

    }

}
