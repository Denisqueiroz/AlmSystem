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
public class AtualizarItem extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            Item item = new Item();

            item.setIdItem(Integer.parseInt(request.getParameter("idItem")));
            item.setRetiradaItem(Integer.parseInt(request.getParameter("retiradaItem")));
            item.setOperacaoItem(Integer.parseInt(request.getParameter("operacaoItem")));
            String mensagem = null;

            try {

                ItemDAOIpml dao = new ItemDAOIpml();
                
               
                

                dao.AtualizarQuantidade(item.getIdItem(), item.getRetiradaItem(),item.getOperacaoItem());
                mensagem = "Item  editado com sucesso";
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("ListarItens").forward(request, response);
            } catch (Exception ex) {
                System.out.println("Problemas no Servlet ao alterar Produto! Erro: " + ex.getMessage());
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
