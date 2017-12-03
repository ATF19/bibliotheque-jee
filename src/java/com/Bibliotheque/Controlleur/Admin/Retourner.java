package com.Bibliotheque.Controlleur.Admin;

import com.Bibliotheque.Model.Document;
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

/**
 *
 * @author 2
 */
public class Retourner extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        int idReservation = Integer.parseInt(request.getParameter("id"));
        Reservation reservation = new Reservation();
        reservation.setId(idReservation);
        reservation.obtenir();
        Document document = new Document();
        document.setId(reservation.getIdDocument());
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date aujourdhui = new Date();
        String dateFin = dateFormat.format(aujourdhui).toString();
        
        document.setStatus("disponible");
        document.modifierStatus();
        reservation.setDateFin(dateFin);
        reservation.modifier();
        
        try {
            response.sendRedirect("http://localhost:8080/Bibliotheque/admin/reservations.jsp");
        } catch (IOException ex) {
            Logger.getLogger(Retourner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
