package com.Bibliotheque.Model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author 2
 */
public class Liste implements Serializable {
   private ArrayList<Categorie> categories;
   private ArrayList<Document> documents;
   private ArrayList<Etudiant> etudiants;
   private ArrayList<Livre> livres;
   private ArrayList<Reservation> reservers;
   private ArrayList<User> users;
   private ArrayList<Document> documentsParCategorie;
   private ArrayList<Document> documentsParEtudiant;
   private ArrayList<Document> documentsParTitre;
   private Database db;

    public Liste() {
        this.db = new Database();
        categories = new ArrayList<>();
        documents = new ArrayList<>();
        etudiants = new ArrayList<>();
        livres = new ArrayList<>();
        reservers = new ArrayList<>();
        users = new ArrayList<>();
        documentsParCategorie = new ArrayList<>();
        documentsParEtudiant = new ArrayList<>();
        documentsParTitre = new ArrayList<>();
    }
   
   public void obtenirCategories() {
       String sql = "SELECT * FROM categorie";
       ResultSet res = db.read(sql);
       try {
           while(res.next()) {
                Categorie cat = new Categorie();
                cat.setId(res.getInt("id"));
                cat.setLibelle(res.getString("libelle"));
                categories.add(cat);
            }
           db.disconnect();
       } catch(Exception e) {
           e.printStackTrace();
       }
   }
   
   public void obtenirDocuments() {
       String sql = "SELECT * FROM document";
       ResultSet res = db.read(sql);
       try {
           while(res.next()) {
               Document doc = new Document();
               doc.setId(res.getInt("id"));
               doc.setIdCategorie(res.getInt("idCategorie"));
               doc.setLibelle(res.getString("libelle"));
               doc.setDescription(res.getString("description"));
               doc.setNbrPages(res.getInt("nbrPages"));
               doc.setImage(res.getString("image"));
               doc.setLangue(res.getString("langue"));
               doc.setType(res.getString("type"));
               doc.setStatus(res.getString("statut"));
               documents.add(doc);
            }
           db.disconnect();
       } catch(Exception e) {
           e.printStackTrace();
       }
   }

   public void obtenirDocumentsParCategorie(int idCategorie) {
       String sql = "SELECT * FROM document WHERE idCategorie="+idCategorie;
       ResultSet res = db.read(sql);
       try {
           while(res.next()) {
               Document doc = new Document();
               doc.setId(res.getInt("id"));
               doc.setIdCategorie(res.getInt("idCategorie"));
               doc.setLibelle(res.getString("libelle"));
               doc.setDescription(res.getString("description"));
               doc.setNbrPages(res.getInt("nbrPages"));
               doc.setImage(res.getString("image"));
               doc.setLangue(res.getString("langue"));
               doc.setType(res.getString("type"));
               doc.setStatus(res.getString("statut"));
               documentsParCategorie.add(doc);
            }
           db.disconnect();
       } catch(Exception e) {
           e.printStackTrace();
       }
   }
   
   public void obtenirDocumentsParEtudiant(String email) {
       Etudiant etud = new Etudiant();
       etud.setEmail(email);
       etud.obtenirParEmail();
       String sql = "SELECT * FROM document WHERE id IN (SELECT idDocument FROM reserver WHERE idEtudiant="+etud.getId()+" AND dateFin='-')";
       ResultSet res = db.read(sql);
       try {
           while(res.next()) {
               Document doc = new Document();
               doc.setId(res.getInt("id"));
               doc.setIdCategorie(res.getInt("idCategorie"));
               doc.setLibelle(res.getString("libelle"));
               doc.setDescription(res.getString("description"));
               doc.setNbrPages(res.getInt("nbrPages"));
               doc.setImage(res.getString("image"));
               doc.setLangue(res.getString("langue"));
               doc.setType(res.getString("type"));
               doc.setStatus(res.getString("statut"));
               documentsParEtudiant.add(doc);
            }
           db.disconnect();
       } catch(Exception e) {
           e.printStackTrace();
       }
   }
  
   public void obtenirDocumentsParTitre(String searchText) {
        String sql = "SELECT * FROM document WHERE libelle LIKE '%"+searchText+"%'";
        ResultSet res = db.read(sql);
        try {
            while(res.next()) {
               Document doc = new Document();
               doc.setId(res.getInt("id"));
               doc.setIdCategorie(res.getInt("idCategorie"));
               doc.setLibelle(res.getString("libelle"));
               doc.setDescription(res.getString("description"));
               doc.setNbrPages(res.getInt("nbrPages"));
               doc.setImage(res.getString("image"));
               doc.setLangue(res.getString("langue"));
               doc.setType(res.getString("type"));
               doc.setStatus(res.getString("statut"));
                getDocumentsParTitre().add(doc);
            }
            db.disconnect();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
   
   public void obtenirEtudiants() {
       String sql = "SELECT * FROM etudiant";
       ResultSet res = db.read(sql);
       try {
           while(res.next()) {
               Etudiant etud = new Etudiant();
               etud.setId(res.getInt("id"));
               etud.setCin(res.getString("cin"));
               etud.setCarteE(res.getString("carteE"));
               etud.setEmail(res.getString("email"));
               etud.setNom(res.getString("nom"));
               etud.setPrenom(res.getString("prenom"));
               etud.setDateN(res.getString("dateN"));
               etud.setUniversite(res.getString("universite"));
               etudiants.add(etud);
            }
           db.disconnect();
       } catch(Exception e) {
           e.printStackTrace();
       }
   }
   
   
   
   public void obtenirLivres() {
       String sql = "SELECT * FROM livre";
       ResultSet res = db.read(sql);
       try {
           while(res.next()) {
               Livre liv = new Livre();
               liv.setId(res.getInt("id"));
               liv.setISBN(res.getString("ISBN"));
               liv.setAuteur(res.getString("auteur"));
               livres.add(liv);
            }
           db.disconnect();
       } catch(Exception e) {
           e.printStackTrace();
       }
   }
   
   public void obtenirReservers() {
       String sql = "SELECT * FROM reserver";
       ResultSet res = db.read(sql);
       try {
           while(res.next()) {
               Reservation reserv = new Reservation();
               reserv.setId(res.getInt("id"));
               reserv.setIdDocument(res.getInt("idDocument"));
               reserv.setIdEtudiant(res.getInt("idEtudiant"));
               reserv.setDateDebut(res.getString("dateDebut"));
               reserv.setDateFin(res.getString("dateFin"));
               reservers.add(reserv);
            }
           db.disconnect();
       } catch(Exception e) {
           e.printStackTrace();
       }
   }
   
   
   public void obtenirUsers() {
       String sql = "SELECT * FROM user";
       ResultSet res = db.read(sql);
       try {
           while(res.next()) {
               User u = new User();
               u.setEmail(res.getString("email"));
               u.setPassword(res.getString("password"));
               users.add(u);
            }
           db.disconnect();
       } catch(Exception e) {
           e.printStackTrace();
       }
   }
   
    /**
     * @return the categories
     */
    public ArrayList<Categorie> getCategories() {
        return categories;
    }

    /**
     * @return the documents
     */
    public ArrayList<Document> getDocuments() {
        return documents;
    }

    /**
     * @return the etudiants
     */
    public ArrayList<Etudiant> getEtudiants() {
        return etudiants;
    }

    /**
     * @return the livres
     */
    public ArrayList<Livre> getLivres() {
        return livres;
    }

    /**
     * @return the reservers
     */
    public ArrayList<Reservation> getReservers() {
        return reservers;
    }

    /**
     * @return the users
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * @return the documentsParCategorie
     */
    public ArrayList<Document> getDocumentsParCategorie() {
        return documentsParCategorie;
    }

    /**
     * @param documentsParCategorie the documentsParCategorie to set
     */
    public void setDocumentsParCategorie(ArrayList<Document> documentsParCategorie) {
        this.documentsParCategorie = documentsParCategorie;
    }

    /**
     * @return the documentsParEtudiant
     */
    public ArrayList<Document> getDocumentsParEtudiant() {
        return documentsParEtudiant;
    }

    /**
     * @param documentsParEtudiant the documentsParEtudiant to set
     */
    public void setDocumentsParEtudiant(ArrayList<Document> documentsParEtudiant) {
        this.documentsParEtudiant = documentsParEtudiant;
    }

    /**
     * @return the documentsParTitre
     */
    public ArrayList<Document> getDocumentsParTitre() {
        return documentsParTitre;
    }

    /**
     * @param documentsParTitre the documentsParTitre to set
     */
    public void setDocumentsParTitre(ArrayList<Document> documentsParTitre) {
        this.documentsParTitre = documentsParTitre;
    }



   
}
