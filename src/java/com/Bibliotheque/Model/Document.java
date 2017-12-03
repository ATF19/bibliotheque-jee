package com.Bibliotheque.Model;

import java.io.Serializable;
import java.sql.ResultSet;

public class Document implements Serializable {
    private int id;
    private int idCategorie;
    private String libelle;
    private String langue;
    private String description;
    private int nbrPages;
    private String image;
    private String type; // livre ou cours ou these
    private String status = "disponible"; // disponible ou reserve
    private Livre livre;
    private Database db;

    public Document() {
        this.db = new Database();
    }
    
    public boolean ajouter() {
        String sql = "INSERT INTO document(idCategorie, libelle, langue, description, nbrPages, image, type, statut)"
                + "VALUES("+idCategorie+", '"+libelle+"', '"+langue+"', '"+description.replaceAll("'", "")+"', "+nbrPages+", '"+image+"', '"+type+"', '"+status+"')";
        return db.create(sql);
    }
    
    public boolean modifier() {
        String sql = "UPDATE document SET "
                + "idCategorie="+idCategorie
                + ", libelle='"+libelle+"'"
                + ", langue='"+langue+"'"
                + ", description='"+description.replaceAll("'", "")+"'"
                + ", nbrPages="+nbrPages
                + ", image='"+image+"'"
                + ", type='"+type+"'"
                + ", statut='"+status+"'"
                + " WHERE id="+id;
        return db.update(sql);
    }
    
    public boolean modifierStatus() {
        String sql = "UPDATE document SET "
                + "statut='"+status+"'"
                + " WHERE id="+id;
        return db.update(sql);
    }
    
    public boolean supprimer() {
        String sql = "DELETE FROM document WHERE id="+id;
        return db.delete(sql);
    }
    
    public void obtenir() {
        String sql = "SELECT * FROM document WHERE id="+id;
        ResultSet res = db.read(sql);
        try {
            if(res.next()) {
                idCategorie = res.getInt("idCategorie");
                libelle = res.getString("libelle");
                langue = res.getString("langue");
                description = res.getString("description");
                nbrPages = res.getInt("nbrPages");
                image = res.getString("image");
                type = res.getString("type");
                status = res.getString("statut");
            }
            if(type.equals("livre")) {
                livre = new Livre();
                System.out.println(id);
                livre.setId(id);
                livre.obtenir();
            }
            db.disconnect();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public String auteur() {
        if(type.equals("livre")) {
            return livre.getAuteur();
        }
        return "";
    }
    
    public String isbn() {
        if(type.equals("livre")) {
            return "ISBN: "+livre.getISBN();
        }
        return "";
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
     * @return the idCategorie
     */
    public int getIdCategorie() {
        return idCategorie;
    }

    /**
     * @param idCategorie the idCategorie to set
     */
    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
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

    /**
     * @return the langue
     */
    public String getLangue() {
        return langue;
    }

    /**
     * @param langue the langue to set
     */
    public void setLangue(String langue) {
        this.langue = langue;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the nbrPages
     */
    public int getNbrPages() {
        return nbrPages;
    }

    /**
     * @param nbrPages the nbrPages to set
     */
    public void setNbrPages(int nbrPages) {
        this.nbrPages = nbrPages;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the livre
     */
    public Livre getLivre() {
        return livre;
    }

    /**
     * @param livre the livre to set
     */
    public void setLivre(Livre livre) {
        this.livre = livre;
    }
}
