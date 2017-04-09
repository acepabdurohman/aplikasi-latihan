/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acepabdurohman.belajar.servlet;

import com.acepabdurohman.belajar.connection.KoneksiDatabase;
import com.acepabdurohman.belajar.dao.BarangDao;
import com.acepabdurohman.belajar.model.Barang;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Swamedia
 */
public class FormBarangServlet extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp){
        Barang b = new Barang();
        b.setKode(req.getParameter("kode"));
        b.setNama(req.getParameter("nama"));
        b.setHarga( new BigDecimal(req.getParameter("harga")));
        b.setStok(Integer.parseInt(req.getParameter("stok")));
        BarangDao barangDao = new BarangDao(KoneksiDatabase.getInstance());
        barangDao.save(b);
        try {
            resp.sendRedirect("/aplikasi-latihan/form-barang.html");
        } catch (IOException ex) {
            Logger.getLogger(FormBarangServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
