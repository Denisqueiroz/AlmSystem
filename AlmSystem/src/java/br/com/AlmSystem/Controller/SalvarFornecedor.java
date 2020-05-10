/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.AlmSystem.Controller;

import br.com.AlmSystem.DAO.FornecedorDAOIpml;
import br.com.AlmSystem.DAO.GenericDAO;
import br.com.AlmSystem.model.Fornecedor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TBO-002
 */
@WebServlet(name = "SalvarFornecedor", urlPatterns = {"/SalvarFornecedor"})
public class SalvarFornecedor extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             String mensagem = "";

            try {
                
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setInscricaoEstadual(request.getParameter("inscricaoEstadual"));
                fornecedor.setCnpj(request.getParameter("cnpj"));
//                -------herança-----
                fornecedor.setNomePessoa(request.getParameter("nomePessoa"));
                fornecedor.setTipoPessoa(request.getParameter("tipoPessoa"));
                fornecedor.setEmailPessoa(request.getParameter("emailPessoa"));
                fornecedor.setTelefonePessoa(request.getParameter("telefonePessoa"));
                fornecedor.setCepPessoa(request.getParameter("cepPessoa"));
                fornecedor.setCidadePessoa(request.getParameter("cidadePessoa"));
                fornecedor.setLogadoroPessoa(request.getParameter("logradoroPessoa"));
                fornecedor.setNumeroPessoa(request.getParameter("numeroPessoa"));
                fornecedor.setBairroPessoa(request.getParameter("bairroPessoa"));
                fornecedor.setUfPessoa(request.getParameter("ufPessoa"));
                fornecedor.setPaisPessoa(request.getParameter("paisPessoa"));
               

                GenericDAO dao = new FornecedorDAOIpml();
                if (request.getParameter("idFornecedor").equals("")) {
                    if (dao.cadastrar(fornecedor)) {
                        mensagem = "Fornecedor cadastrado com sucesso";
                    } else {
                        mensagem = "Problemas aos cadastrat o Fornecedor ";
                    }
               } else {
                    fornecedor.setIdFornecedor(Integer.parseInt((request.getParameter("idFornecedor"))));

                    if (dao.alterar(fornecedor)) {
                        mensagem = "Fornecedor Alterado com Sucesso!";
                    } else {
                        mensagem = "Probelmas ao alterar fornecedor";
                    }

                }

                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("ListarFornecedor").forward(request, response);

            } catch (Exception ex) {
                System.out.println("Problemas ao Salvar FornecedorServelt! Erro!!" + ex.getMessage());
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
