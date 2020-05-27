/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.AlmSystem.Controller;

import br.com.AlmSystem.DAO.GenericDAO;
import br.com.AlmSystem.DAO.ItemDAOIpml;
import br.com.AlmSystem.model.Item;
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
public class AlterarItem extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Item item = new Item();

        item.setIdItem(Integer.parseInt(request.getParameter("idItem")));
        item.setQuantidadeItem(Integer.parseInt(request.getParameter("quantidadeItem")));
        String mensagem = null;

        try {

            GenericDAO dao = new ItemDAOIpml();
            if (dao.alterar(item)) {
                mensagem = "Item para teste editado com sucesso";

            } else {
                mensagem = "Problemas ao editar Item teste";
            }
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("ListarItens").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao alterar saldo do item! Erro: " + ex.getMessage());
            ex.printStackTrace();
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
