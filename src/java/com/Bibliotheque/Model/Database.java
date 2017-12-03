package com.Bibliotheque.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2
 */
public class Database {
    private Connection connexion = null;
    
    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bibliotheque", "root", "");
        } catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void disconnect() {
        try {
            connexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean create(String sql) {
        this.connect();
        Statement stmt;
        int res = -1;
        try {
            stmt = connexion.createStatement();
            res = stmt.executeUpdate(sql);
            stmt.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        this.disconnect();
        if(res > 0)
            return true;
        else
            return false;
    }
    
    public boolean update(String sql) {
        this.connect();
        Statement stmt;
        int res = -1;
        try {
            stmt = connexion.createStatement();
            res = stmt.executeUpdate(sql);
            stmt.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        this.disconnect();
        if(res > 0)
            return true;
        else
            return false;
    }
    
    public boolean delete(String sql) {
        this.connect();
        Statement stmt;
        int res = -1;
        try {
            stmt = connexion.createStatement();
            res = stmt.executeUpdate(sql);
            stmt.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        this.disconnect();
        if(res > 0)
            return true;
        else
            return false;
    }
    
    public ResultSet read(String sql) {
        this.connect();
        try {
            Statement stmt = connexion.createStatement();
            ResultSet res = stmt.executeQuery(sql);
            return res;
        } catch(Exception e) {
            e.printStackTrace();
            this.disconnect();
            return null;
        } 
    }
    
    /**
     * @return the connexion
     */
    public Connection getConnexion() {
        return connexion;
    }
}
