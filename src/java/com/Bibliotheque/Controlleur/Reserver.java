package com.Bibliotheque.Controlleur;

import com.Bibliotheque.Model.Document;
import com.Bibliotheque.Model.Etudiant;
import com.Bibliotheque.Model.Reservation;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Reserver extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        if(session.getAttribute("email") != null) {
            String email = session.getAttribute("email").toString();
            
            int idDocument = Integer.parseInt(request.getParameter("idDocument"));
            Document doc = new Document();
            doc.setId(idDocument);
            doc.obtenir();
            
            Etudiant etud = new Etudiant();
            etud.setEmail(email);
            etud.obtenirParEmail();
            
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date aujourdhui = new Date();
            String dateDebut = dateFormat.format(aujourdhui).toString();
            
            Reservation reservation = new Reservation();
            reservation.setIdDocument(idDocument);
            reservation.setIdEtudiant(etud.getId());
            reservation.setDateDebut(dateDebut);
            boolean res = reservation.ajouter();
            if(res) {
                doc.setStatus("reserve");
                doc.modifierStatus();
                try {
                    response.sendRedirect("document.jsp?id="+doc.getId()+"&success=true");
                } catch (IOException ex) {
                    Logger.getLogger(Reserver.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else {
                try {
                    response.sendRedirect("document.jsp?id="+doc.getId()+"&success=false");
                } catch (IOException ex) {
                    Logger.getLogger(Reserver.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else {
            try {
                response.sendRedirect("connecter.jsp");
            } catch (IOException ex) {
                Logger.getLogger(Reserver.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        this.doGet(request, response);
    }
}
