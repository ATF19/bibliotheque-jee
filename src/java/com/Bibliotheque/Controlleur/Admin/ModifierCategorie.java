package com.Bibliotheque.Controlleur.Admin;

import com.Bibliotheque.Model.Categorie;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 2
 */
public class ModifierCategorie extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Categorie cat = new Categorie();
        cat.setId(id);
        cat.obtenir();
        cat.supprimer();
        try {
            response.sendRedirect("http://localhost:8080/Bibliotheque/admin/categories.jsp");
        } catch (IOException ex) {
            Logger.getLogger(AjouterCategorie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String libelle = request.getParameter("libelle");
        int id = Integer.parseInt(request.getParameter("id"));
        Categorie cat = new Categorie();
        cat.setId(id);
        cat.obtenir();
        cat.setLibelle(libelle);
        cat.modifier();
        try {
            response.sendRedirect("http://localhost:8080/Bibliotheque/admin/categories.jsp");
        } catch (IOException ex) {
            Logger.getLogger(AjouterCategorie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
