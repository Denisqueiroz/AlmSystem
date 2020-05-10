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
import java.util.logging.Level;
import java.util.logging.Logger;

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

//    public boolean verificaUsuario(Usuario usuario) throws Exception {
//
//        String sql = "select * from usuario where login = ? and senha = ? ";
//
//        try {
//
//            stmt = conn.prepareStatement(sql);
//
//            stmt.setString(1, usuario.getLoginUsuario());
//            stmt.setString(2, usuario.getSenhaUsuario());
//            ResultSet resultSet = stmt.executeQuery();
//            if (resultSet.next()) {
//                return true;
//
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(UsuarioDAOIpml.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//
//            ConnectionFactory.closeConnection(conn, stmt);
//
//        }
//        return false;
//    }
    //Método  criado para retorna  o usuario mas sem efeito não consegui aplicar a herança 
    public Usuario getUsuario(String loginUsuario, String senhaUsuario) throws SQLException, Exception {

        String sql = "select * from usuario where login = ? and senha = ? ";

        try {

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, loginUsuario);
            stmt.setString(2, senhaUsuario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setLoginUsuario(loginUsuario);
                usuario.setSenhaUsuario(senhaUsuario);
                //            usuario.setTipoPessoa(rs.getString("tipo"));
//              usuario.setNomePessoa(rs.getString("nome"));

                return usuario;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOIpml.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
            //  rs.close();
            System.out.println("O conn está fechado ? = " + conn.isClosed());
            System.out.println("O stmt está fechado ? = " + stmt.isClosed());
        }

        return null;

    }
}
