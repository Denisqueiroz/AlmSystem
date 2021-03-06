/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.AlmSystem.Controller;

import br.com.AlmSystem.DAO.GenericDAO;
import br.com.AlmSystem.DAO.ItemDAOIpml;
import br.com.AlmSystem.model.Item;

import br.com.AlmSystem.model.Produto;
import br.com.AlmSystem.util.Conversoes;
import java.io.IOException;
import java.io.PrintWriter;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TBO-002
 */
public class CadastrarIntens extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=ISO-8859-1");

        try (PrintWriter out = response.getWriter()) {

            Item item = new Item();

            item.setQuantidadeItem(Integer.parseInt(request.getParameter("saldoItem")));
            item.setDataCompraItem(Conversoes.converterData(request.getParameter("dataCompraItem")));
            item.setDataValidadeItem(Conversoes.converterData(request.getParameter("dataValidadeItem")));

            Produto produto = new Produto();
            produto.setIdProduto(Integer.parseInt(request.getParameter("idProduto")));
            item.setProduto(produto);

            String mensagem = null;
            try {

                GenericDAO dao = new ItemDAOIpml();
                if (request.getParameter("idItem").equals("")) {
                    if (dao.cadastrar(item)) {
                        mensagem = "Item cadastrado com sucesso";
                    } else {
                        mensagem = "Problemas aos cadastrat o item ";
                    }
                }

                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("ListarItens").forward(request, response);

            } catch (Exception ex) {
                System.out.println("Problemas ao Salvar ItemServelt! Erro!!" + ex.getMessage());
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
        try {
            processRequest(request, response);

        } catch (ParseException ex) {
            Logger.getLogger(CadastrarIntens.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);

        } catch (ParseException ex) {
            Logger.getLogger(CadastrarIntens.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
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
