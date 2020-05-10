/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.AlmSystem.Controller;

import br.com.AlmSystem.DAO.GenericDAO;
import br.com.AlmSystem.DAO.ProdutoDAOImpl;
import br.com.AlmSystem.model.Fornecedor;
import br.com.AlmSystem.model.Marca;
import br.com.AlmSystem.model.Produto;
import br.com.AlmSystem.model.Unidade;
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
public class SalvarProduto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String mensagem = "";

            try {

                String descricaoProduto = request.getParameter("descricaoProduto");
                Integer idUnidade = Integer.parseInt(request.getParameter("idUnidade"));
                Integer idMarca = Integer.parseInt(request.getParameter("idMarca"));
                Integer idFornecedor = Integer.parseInt(request.getParameter("idFornecedor"));

                Produto produto = new Produto();
                produto.setDescricaoProduto(descricaoProduto);

                produto.setIdUnidade(new Unidade(idUnidade));
                produto.setIdMarca(new Marca(idMarca));
                produto.setIdFornecedor(new Fornecedor(idFornecedor));

                GenericDAO dao = new ProdutoDAOImpl();

                if (request.getParameter("idProduto").equals("")) {
                    if (dao.cadastrar(produto)) {
                        mensagem = "Produto cadastrado com sucesso";
                    } else {
                        mensagem = "Problemas aos cadastra o Produto";
                    }
                } else {

                    produto.setIdProduto(Integer.parseInt((request.getParameter("idProduto"))));

                    if (dao.alterar(produto)) {
                        mensagem = "Produto Alterado com Sucesso!";
                    } else {
                        mensagem = "Probelmas ao alterar Produto";
                    }

                }

                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("DadosProduto").forward(request, response);

            } catch (Exception ex) {
                System.out.println("Problemas ao Salvar Produto! Erro!!" + ex.getMessage());
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
