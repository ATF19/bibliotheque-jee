package com.Bibliotheque.Controlleur;

import com.Bibliotheque.Model.Liste;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 2
 */
public class Index extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        Liste liste = new Liste();
        liste.obtenirDocuments();
        request.setAttribute("documents", liste.getDocuments());
        try {
           this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
       } catch(Exception e) {
           e.printStackTrace();
       }
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        this.doGet(request, response);
    }
}
