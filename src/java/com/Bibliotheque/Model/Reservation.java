package com.Bibliotheque.Model;

import java.io.Serializable;
import java.sql.ResultSet;

public class Reservation implements Serializable {
    private int id;
    private int idEtudiant;
    private int idDocument;
    private String dateDebut;
    private String dateFin;
    private Database db;

    public Reservation() {
        this.db = new Database();
        dateFin = "-";
    }
    
    public boolean ajouter() {
        String sql = "INSERT INTO reserver(idEtudiant, idDocument, dateDebut, dateFin)"
                + " VALUES("+idEtudiant+", "+idDocument+", '"+dateDebut+"', '"+dateFin+"')";
        return db.create(sql);
    }
    
    public boolean modifier() {
        String sql = "UPDATE reserver SET "
                + " idEtudiant="+idEtudiant
                + ", idDocument="+idDocument
                + ", dateDebut='"+dateDebut+"'"
                + ", dateFin='"+dateFin+"'"
                + " WHERE id="+id;
        return db.update(sql);
    }
    
    public boolean supprimer() {
        String sql = "DELETE FROM reserver WHERE id="+id;
        return db.delete(sql);
    }
    
    public void obtenir() {
        String sql = "SELECT * FROM reserver WHERE id="+id;
        ResultSet res = db.read(sql);
        try {
            if(res.next()) {
                idEtudiant = res.getInt("idEtudiant");
                idDocument = res.getInt("idDocument");
                dateDebut = res.getString("dateDebut");
                dateFin = res.getString("dateFin");
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
     * @return the idEtudiant
     */
    public int getIdEtudiant() {
        return idEtudiant;
    }

    /**
     * @param idEtudiant the idEtudiant to set
     */
    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    /**
     * @return the idDocument
     */
    public int getIdDocument() {
        return idDocument;
    }

    /**
     * @param idDocument the idDocument to set
     */
    public void setIdDocument(int idDocument) {
        this.idDocument = idDocument;
    }

    /**
     * @return the dateDebut
     */
    public String getDateDebut() {
        return dateDebut;
    }

    /**
     * @param dateDebut the dateDebut to set
     */
    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * @return the dateFin
     */
    public String getDateFin() {
        return dateFin;
    }

    /**
     * @param dateFin the dateFin to set
     */
    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }
    
}
