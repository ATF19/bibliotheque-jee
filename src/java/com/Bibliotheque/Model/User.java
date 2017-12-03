package com.Bibliotheque.Model;

import java.io.Serializable;
import java.sql.ResultSet;

public class User implements Serializable {
    private String email;
    private String password;
    private String role = "etudiant"; // etudiant ou admin
    private int actif = 0; // 0 ou 1
    private Database db;

    public User() {
        this.db = new Database();
    }
    
    public boolean connecter() {
        ResultSet res = db.read("SELECT count(*) AS total FROM user WHERE email='"+email+"' AND password='"+password+"' AND actif=1");
        if(res == null) 
            return false;
        try {
            res.next();
            if(res.getInt("total") > 0) {
                db.disconnect();
                return true;
            }
            else  {
                db.disconnect();
                return false;
            }
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean ajouter() {
        String sql = "INSERT INTO user VALUES('"+email+"', '"+password+"', '"+role+"', 0)";
        return db.create(sql);
    }
    
    public boolean modifier() {
        String sql = "UPDATE user SET "
                + " email='"+email+"'"
                + ", password='"+password+"'"
                + ", actif="+actif
                + " WHERE email='"+email+"'";
        return db.update(sql);
    }
    
    public boolean supprimer() {
        String sql = "DELETE FROM user WHERE email='"+email+"'";
        return db.delete(sql);
    }
    
    public void obtenir() {
        String sql = "SELECT * FROM user WHERE email='"+email+"'";
        ResultSet res = db.read(sql);
        try {
            if(res.next()) {
                password = res.getString("password");
                role = res.getString("role");
                actif = res.getInt("actif");
            }
            db.disconnect();
        } catch(Exception e) {
            e.printStackTrace();
        }
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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        if(role.equals("etudiant") || role.equals("admin"))
            this.role = role;
    }

    /**
     * @return the actif
     */
    public int getActif() {
        return actif;
    }

    /**
     * @param actif the actif to set
     */
    public void setActif(int actif) {
        this.actif = actif;
    }
}
