/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.AlmSystem.Controller;

import br.com.AlmSystem.DAO.FuncionarioDAOIpml;
import br.com.AlmSystem.DAO.GenericDAO;
import br.com.AlmSystem.model.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TBO-002
 */
public class SalvarFuncionario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String mensagem = "";

            try {

                Funcionario funcionario = new Funcionario();

                funcionario.setCpfFuncionario(request.getParameter("cpf"));
                funcionario.setLoginFuncionario(request.getParameter("login"));
                funcionario.setSenhaFuncionario(request.getParameter("senha"));
//                -------herança-----
                funcionario.setNomePessoa(request.getParameter("nomePessoa"));
                funcionario.setTipoPessoa(request.getParameter("tipoPessoa"));
                funcionario.setEmailPessoa(request.getParameter("emailPessoa"));
                funcionario.setTelefonePessoa(request.getParameter("telefonePessoa"));
                funcionario.setCepPessoa(request.getParameter("cepPessoa"));
                funcionario.setCidadePessoa(request.getParameter("cidadePessoa"));
                funcionario.setLogadoroPessoa(request.getParameter("logradoroPessoa"));
                funcionario.setNumeroPessoa(request.getParameter("numeroPessoa"));
                funcionario.setBairroPessoa(request.getParameter("bairroPessoa"));
                funcionario.setUfPessoa(request.getParameter("ufPessoa"));
                funcionario.setPaisPessoa(request.getParameter("paisPessoa"));

                GenericDAO dao = new FuncionarioDAOIpml();
                if (request.getParameter("idFuncionario").equals("")) {
                    if (dao.cadastrar(funcionario)) {
                        mensagem = "funcionario cadastrado com sucesso";
                    } else {
                        mensagem = "Problemas aos cadastrat o funcionario ";
                    }
                } else {
                    funcionario.setIdFuncionario(Integer.parseInt((request.getParameter("idFuncionario"))));

                    if (dao.alterar(funcionario)) {
                        mensagem = "funcionario Alterado com Sucesso!";
                    } else {
                        mensagem = "Probelmas ao alterar funcionario";
                    }

                }

                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("index.jsp").forward(request, response);

            } catch (Exception ex) {
                System.out.println("Problemas ao Salvar funcionarioServelt! Erro!!" + ex.getMessage());
                ex.printStackTrace();
            }
        }
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
