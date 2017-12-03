package com.Bibliotheque.Model;

import java.io.Serializable;
import java.sql.ResultSet;

public class Livre implements Serializable {
    private int id; // foreign key from Document.id
    private String ISBN;
    private String auteur;
    private Database db;

    public Livre() {
        this.db = new Database();
    }
    
    public boolean ajouter() {
        String sql = "INSERT INTO livre(id, ISBN, auteur)"
                + " VALUES("+id+", '"+ISBN+"', '"+auteur+"')";
        return db.create(sql);
    }
    
    public boolean modifier() {
        String sql = "UPDATE livre SET "
                + " ISBN='"+ISBN+"'"
                + ", auteur='"+auteur+"'"
                + " WHERE id="+id;
        return db.update(sql);
    }
    
    public boolean supprimer() {
        String sql = "DELETE FROM livre WHERE id="+id;
        return db.delete(sql);
    }
    
    public void obtenir() {
        String sql = "SELECT * FROM livre WHERE id="+id;
        ResultSet res = db.read(sql);
        try {
            if(res.next()) {
                ISBN = res.getString("ISBN");
                auteur = res.getString("auteur");
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
     * @return the ISBN
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * @param ISBN the ISBN to set
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * @return the auteur
     */
    public String getAuteur() {
        return auteur;
    }

    /**
     * @param auteur the auteur to set
     */
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
    
    
}
