/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.AlmSystem.Controller;


import br.com.AlmSystem.DAO.UsuarioDAOIpml;
import br.com.AlmSystem.model.Pessoa;
import br.com.AlmSystem.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TBO-002
 */
public class LogarUsuario extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       if (request.getParameter("acao").equalsIgnoreCase("logar")) {
            
            Pessoa pessoa = null ;
            Usuario usuario= null;

            if (!request.getParameter("login").equals("") && !request.getParameter("senha").equals("")) {

                try {

                    UsuarioDAOIpml dao = new UsuarioDAOIpml();
                    
                    usuario = dao.logarUsuario(request.getParameter("login"), request.getParameter("senha"));

                    if (usuario != null) {
                        
                        HttpSession session = request.getSession(true);
                        session.setAttribute("pessoa", pessoa);
                        session.setAttribute("saudacao", "Seja bem-vindo Sr(a). " + pessoa.getNomePessoa() + "!");
                        
                        if (pessoa.getTipoPessoa().equalsIgnoreCase("f")){
                            request.getRequestDispatcher("./principal/principal.jsp").forward(request, response);
                        } else if (pessoa.getTipoPessoa().equalsIgnoreCase("a")){
                            request.getRequestDispatcher("aluno/index.jsp").forward(request, response);
                        } else {
                            erro(request, response, "Não foram encontrados usuários de tipificação válida!");
                        }
                        
                    } else {
                        erro(request, response, "Usuario e/ou Senha inválidos! Tente novamente!");
                    }

                } catch (Exception ex) {
                    System.out.println("Problemas ao logar usuário! Erro: " + ex.getMessage());
                    ex.printStackTrace();
                }

            } else {
                erro(request, response, "Não são aceitos valores nulos! Tente novamente!");
            }
        } else if (request.getParameter("acao").equals("logout")) {
            HttpSession session = request.getSession(true);
            session.invalidate();
            response.sendRedirect("./principal/principal.jsp");
        } else {
            erro(request, response, "Ação desconhecida! Tente novamente!");
        }

    }

    private void erro(HttpServletRequest request, HttpServletResponse response, String mensagem) throws ServletException, IOException {
        request.setAttribute("erro", mensagem);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
