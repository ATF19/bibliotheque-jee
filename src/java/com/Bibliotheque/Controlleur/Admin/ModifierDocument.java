package com.Bibliotheque.Controlleur.Admin;

import com.Bibliotheque.Model.Document;
import com.Bibliotheque.Model.Liste;
import com.Bibliotheque.Model.Livre;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author 2
 */
// Annotation pour resoudre le problem de NULL sur les parametres de request avec enctype dans la form
@javax.servlet.annotation.MultipartConfig

public class ModifierDocument extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
       int id = Integer.parseInt(request.getParameter("id"));
       Document doc = new Document();
       doc.setId(id);
       doc.obtenir();
       if(doc.getType().equals("livre")) {
           doc.getLivre().supprimer();
       }
       doc.supprimer();
       try {
            response.sendRedirect("http://localhost:8080/Bibliotheque/admin/documents.jsp");
        } catch (IOException ex) {
            Logger.getLogger(AjouterCategorie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        int idCategorie = Integer.parseInt(request.getParameter("categorie"));
        String libelle = request.getParameter("libelle");
        String langue = request.getParameter("langue");
        String description = request.getParameter("description");
        int nbrPages = Integer.parseInt(request.getParameter("nbrPages"));
        String status = "disponible";
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Document doc = new Document();
            doc.setId(id);
            doc.obtenir();
            doc.setIdCategorie(idCategorie);
            doc.setLibelle(libelle);
            doc.setDescription(description);
            
            Part filePart = request.getPart("image");
            if(filePart.getSize() > 0) {
                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                InputStream fileContent = filePart.getInputStream();

                String path =  getServletContext().getRealPath("/upload");
                String imagePath = path+"/"+fileName;

                OutputStream outStream = new FileOutputStream(imagePath);

                byte[] buffer = new byte[4096]; 
                long count = 0L;
                int n = 0;
                while (-1 != (n = fileContent.read(buffer))) {
                    outStream.write(buffer, 0, n);
                    count += n;
                }


                outStream.flush();
                outStream.close();
                
                doc.setImage(fileName);
            }
            
            
            doc.setLangue(langue);
            doc.setNbrPages(nbrPages);
            doc.setStatus(status);
            doc.modifier();
            
            if(doc.getType().equals("livre")) {
                String auteur = request.getParameter("auteur");
                String isbn = request.getParameter("isbn");
                Livre livre = new Livre();
                livre.setId(id);
                livre.obtenir();
                livre.setAuteur(auteur);
                livre.setISBN(isbn);                           
                livre.modifier();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.sendRedirect("http://localhost:8080/Bibliotheque/admin/documents.jsp");
            } catch (IOException ex) {
                Logger.getLogger(AjouterDocument.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
