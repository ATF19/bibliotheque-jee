package com.Bibliotheque.Model;

import java.io.Serializable;
import java.sql.ResultSet;

public class Etudiant implements Serializable {
    private int id;
    private String cin;
    private String carteE;
    private String email;
    private String nom;
    private String prenom;
    private String dateN;
    private String universite;
    private Database db;

    public Etudiant() {
        this.db = new Database();
    }
    
    public boolean ajouter() {
        String sql = "INSERT INTO etudiant(cin, carteE, email, nom, prenom, dateN, universite)"
                + " VALUES('"+cin+"','"+carteE+"','"+email+"','"+nom+"','"+prenom+"','"+dateN+"','"+universite+"')";
        return db.create(sql);
    }
    
    public boolean modifier() {
        String sql = "UPDATE etudiant SET "
                + " cin='"+cin+"'"
                + ", carteE='"+carteE+"'"
                + ", email='"+email+"'"
                + ", nom='"+nom+"'"
                + ", prenom='"+prenom+"'"
                + ", dateN='"+dateN+"'"
                + ", universite='"+universite+"'"
                + " WHERE id="+id;
        return db.update(sql);
    }
    
    public boolean supprimer() {
        String sql = "DELETE FROM etudiant WHERE id="+id;
        return db.delete(sql);
    }
    
    public void obtenir() {
        String sql = "SELECT * FROM etudiant WHERE id="+id;
        ResultSet res = db.read(sql);
        try {
            if(res.next()) {
                cin = res.getString("cin");
                carteE = res.getString("carteE");
                email = res.getString("email");
                nom = res.getString("nom");
                prenom = res.getString("prenom");
                dateN = res.getString("dateN");
                universite = res.getString("universite");
            }
            db.disconnect();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void obtenirParEmail() {
        String sql = "SELECT * FROM etudiant WHERE email='"+email+"'";
        ResultSet res = db.read(sql);
        try {
            if(res.next()) {
                id = res.getInt("id");
                cin = res.getString("cin");
                carteE = res.getString("carteE");
                nom = res.getString("nom");
                prenom = res.getString("prenom");
                dateN = res.getString("dateN");
                universite = res.getString("universite");
            }
            db.disconnect();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the cin
     */
    public String getCin() {
        return cin;
    }

    /**
     * @param cin the cin to set
     */
    public void setCin(String cin) {
        this.cin = cin;
    }

    /**
     * @return the carteE
     */
    public String getCarteE() {
        return carteE;
    }

    /**
     * @param carteE the carteE to set
     */
    public void setCarteE(String carteE) {
        this.carteE = carteE;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the dateN
     */
    public String getDateN() {
        return dateN;
    }

    /**
     * @param dateN the dateN to set
     */
    public void setDateN(String dateN) {
        this.dateN = dateN;
    }

    /**
     * @return the universite
     */
    public String getUniversite() {
        return universite;
    }

    /**
     * @param universite the universite to set
     */
    public void setUniversite(String universite) {
        this.universite = universite;
    }
}
