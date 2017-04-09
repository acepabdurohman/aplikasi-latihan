/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acepabdurohman.belajar.dao;

import com.acepabdurohman.belajar.connection.KoneksiDatabase;
import com.acepabdurohman.belajar.model.Barang;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Swamedia
 */
public class BarangDao {
    private KoneksiDatabase kd;
    
    // this class is dependence to KoneksiDatabase class
    public BarangDao(KoneksiDatabase kd){
        this.kd = kd;
    }
          
    public void save(Barang b){
        Connection c = kd.getKoneksi();
        String sql = "insert into t_barang values(null, ?, ?, ?, ?)";
        PreparedStatement ps;
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1, b.getKode());
            ps.setString(2, b.getNama());
            ps.setBigDecimal(3, b.getHarga());
            ps.setInt(4, b.getStok());
            Integer result = ps.executeUpdate();
            if(result != 0){
                System.out.println("Berhasil insert data");
            }
            else{
                System.out.println("Gagal insert data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            System.out.println("Connection is closed");
            kd.disconnetConnection();
        }
    }            
}
