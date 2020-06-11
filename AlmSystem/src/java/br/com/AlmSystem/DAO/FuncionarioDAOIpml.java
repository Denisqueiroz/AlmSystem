/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.AlmSystem.DAO;

import br.com.AlmSystem.model.Funcionario;
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
public class FuncionarioDAOIpml implements GenericDAO {

    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement stmt = null;

    public FuncionarioDAOIpml() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public Boolean cadastrar(Object object) throws Exception {
        Funcionario funcionario = (Funcionario) object;
        PreparedStatement stmt = null;

        String sql = "INSERT INTO funcionario( cpf, login, senha, id_pessoa) VALUES (?, ?, md5(?),?)";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, funcionario.getCpfFuncionario());
            stmt.setString(2, funcionario.getLoginFuncionario());
            stmt.setString(3, funcionario.getSenhaFuncionario());
            stmt.setInt(4, new PessoaDAOImpl().cadastrar(funcionario));
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

    public Funcionario logarFuncionario(String login, String senha) {

        Funcionario funcionario = null;

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select f.*, p.nome,p.tipo from funcionario f\n"
                + "   inner join pessoa p on p.id_pessoa = f.id_pessoa\n"
                + "   where login = ? and senha = md5(?);";


        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, login );
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

            if (rs.next()) {
                
                funcionario = new Funcionario();
                
                funcionario.setIdPessoa(rs.getInt("id_funcionario"));
                funcionario.setNomePessoa(rs.getString("nome"));
                funcionario.setLoginFuncionario(login);
                funcionario.setTipoPessoa(rs.getString("tipo"));
            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao logar Funcionario! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

        return funcionario;
    }

}
