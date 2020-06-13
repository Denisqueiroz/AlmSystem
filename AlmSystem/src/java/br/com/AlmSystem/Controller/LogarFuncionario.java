/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.AlmSystem.Controller;

import br.com.AlmSystem.DAO.FuncionarioDAOIpml;
import br.com.AlmSystem.model.Funcionario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TBO-002
 */
@WebServlet(name = "LogarFuncionario", urlPatterns = {"/LogarFuncionario"})
public class LogarFuncionario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=ISO-8859-1");

        if (request.getParameter("acao").equalsIgnoreCase("logar")) {

            Funcionario funcionario = null;

            if (!request.getParameter("login").equals("") && !request.getParameter("senha").equals("")) {

                try {

                    FuncionarioDAOIpml dao = new FuncionarioDAOIpml();
                    funcionario = dao.logarFuncionario(request.getParameter("login"), request.getParameter("senha"));

                    if (funcionario != null) {

                        HttpSession session = request.getSession(true);
                        session.setAttribute("funcionario", funcionario);
                        session.setAttribute("saudacao", "Seja bem-vindo Sr(a). " + funcionario.getNomePessoa() + "!");

                        if (funcionario.getTipoPessoa().equalsIgnoreCase("funcionario")) {
                            request.getRequestDispatcher("principal/principal.jsp").forward(request, response);
                        } else if (funcionario.getTipoPessoa().equalsIgnoreCase("administrador")) {
                            request.getRequestDispatcher("principal/principal.jsp").forward(request, response);
                        } else {
                            erro(request, response, "Não foram encontrados usuários de tipificação válida!");
                        }

                    } else {
                        erro(request, response, "Usuario e/ou Senha inválidos! Tente novamente!");
                    }

                } catch (Exception ex) {
                    System.out.println("Problemas ao logar Funcionario! Erro: " + ex.getMessage());
                    ex.printStackTrace();
                }

            } else {
                erro(request, response, "Não são aceitos valores nulos! Tente novamente!");
            }
        } else if (request.getParameter("acao").equals("logout")) {
            HttpSession session = request.getSession(true);
            session.invalidate();
            response.sendRedirect("https://www.bolsonaro.com.br/");
        } else {
            erro(request, response, "Ação desconhecida! Tente novamente!");
        }

    }

    private void erro(HttpServletRequest request, HttpServletResponse response, String mensagem) throws ServletException, IOException {
        request.setAttribute("erro", mensagem);
        request.getRequestDispatcher("../index.jsp").forward(request, response);
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
