/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.AlmSystem.Controller;

import br.com.AlmSystem.DAO.GenericDAO;
import br.com.AlmSystem.DAO.MarcaDAOIpml;
import br.com.AlmSystem.model.Marca;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Suporte
 */
@WebServlet(name = "CadastrarMarca", urlPatterns = {"/CadastrarMarca"})
public class CadastrarMarca extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=ISO-8859-1");
        try (PrintWriter out = response.getWriter()) {

            String nomemarca = request.getParameter("nomemarca");
            String mensagem = null;

            Marca marca = new Marca();

            marca.setNomeMarca(nomemarca);

            try {
                GenericDAO dao = new MarcaDAOIpml();
                if (dao.cadastrar(marca)) {
                    mensagem = "Tipo do Marca cadastrado com sucesso";
                } else {
                    mensagem = "Problemas ao cadastrar a Marca Servelt";
                }
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("marca/cadastrarmarca.jsp").forward(request, response);
            } catch (Exception e) {
                System.out.println("Problemas no Servlet ao cadastrar Marca! Erro: " + e.getMessage());
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
