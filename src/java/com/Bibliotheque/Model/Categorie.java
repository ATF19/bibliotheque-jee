package com.Bibliotheque.Model;

import java.io.Serializable;
import java.sql.ResultSet;

public class Categorie implements Serializable {
    private int id;
    private String libelle;
    private Database db;

    public Categorie() {
        this.db = new Database();
    }
    
    public boolean ajouter() {
        String sql = "INSERT INTO categorie(libelle) VALUE('"+libelle+"')";
        return db.create(sql);
    }
    
    public boolean modifier() {
        String sql = "UPDATE categorie SET libelle='"+libelle+"' WHERE id="+id;
        return db.update(sql);
    }
    
    public boolean supprimer() {
        String sql = "DELETE FROM categorie WHERE id="+id;
        return db.delete(sql);
    }
    
    public void obtenir() {
        String sql = "SELECT * FROM categorie WHERE id="+id;
        ResultSet res = db.read(sql);
        try {
            if(res.next()) {
                libelle = res.getString("libelle");
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
     * @return the libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * @param libelle the libelle to set
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
