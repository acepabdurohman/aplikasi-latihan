/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acepabdurohman.belajar.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Swamedia
 * Singleton Class
 */
public class KoneksiDatabase {
    private static KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
    private Connection koneksi;

    public static KoneksiDatabase getInstance(){
        return koneksiDatabase;
    }

    public Connection getKoneksi() {
        
        Properties properties = new Properties();
        InputStream resourceStream = KoneksiDatabase.class.getResourceAsStream("/jdbc.properties");
        try {
            properties.load(resourceStream);
            Class.forName(properties.getProperty("driver"));
            koneksi = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
            System.out.println("Terhubung dengan database");
        } catch (IOException ex) {
            Logger.getLogger(KoneksiDatabase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KoneksiDatabase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(KoneksiDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return koneksi;
    }
    
    public void disconnetConnection(){
        if(koneksi != null){
            try {
                koneksi.close();
            } catch (SQLException ex) {
                Logger.getLogger(KoneksiDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
