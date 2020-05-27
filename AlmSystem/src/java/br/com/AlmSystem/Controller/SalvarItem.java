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
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author TBO-002
 */
public class SalvarItem extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileUploadException, ParseException {
        response.setContentType("text/html;charset=ISO-8859-1");

        Item item = null;

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {

            item = new Item();

            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            upload.setSizeMax(50 * 1024 * 1024);

            List items = upload.parseRequest(request);

            Iterator it = items.iterator();

            while (it.hasNext()) {
                FileItem fileItem = (FileItem) it.next();
                if (!fileItem.isFormField()) {
                    try {
                        fileItem.write(new File("C:\\Users\\TBO-002\\OneDrive-FatecCentroPaulaSouza\\ArquivosVariados\\Documents\\GitHub\\AlmSystem\\AlmSystem\\web\\notasfiscais" + (new File(fileItem.getName())).getName()));
                    } catch (Exception ex) {
                        System.out.println("Problemas ao pegar o nome do arquivo! Erro:" + ex.getMessage());
                        ex.printStackTrace();
                    }

                    System.out.println(fileItem.getName());
                    item.setNotafiscal("notafiscal/" + fileItem.getName());
                    System.out.println("O arquivo enviado foi: " + item.getNotafiscal() + "e o seu tamanho é de: " + fileItem.getSize() + "bytes!");

                } else {
                    String dados = fileItem.getFieldName();
                    if (dados.equals("quantidadeItem")) {
                        item.setQuantidadeItem(Integer.parseInt(fileItem.getString()));
                    } else if (dados.equals("dataCompraItem")) {
                        item.setDataCompraItem(Conversoes.converterData(fileItem.getString().replace("-", "/")));
                    } else if (dados.equals("dataValidadeItem")) {
                        item.setDataValidadeItem(Conversoes.converterData(fileItem.getString().replace("-", "/")));
                    } else if (dados.equals("idProduto")) {
                        item.setProduto(new Produto(Integer.parseInt(fileItem.getString())));
                    }
                }
            }
        }

        String mensagem = null;
       
        try {
            GenericDAO dao = new ItemDAOIpml();
            if (dao.cadastrar(item)) {
                mensagem = "Item cadastrado com sucesso!";
            } else {
                mensagem = "Problema ao cadastrar Item!";
            }

            request.setAttribute("sucesso", mensagem);
            request.getRequestDispatcher("ListarItens").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao Cadastrar Item! Erro: " + ex.getMessage());
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
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            Logger.getLogger(SalvarItem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(SalvarItem.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (FileUploadException ex) {
            Logger.getLogger(SalvarItem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(SalvarItem.class.getName()).log(Level.SEVERE, null, ex);
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
