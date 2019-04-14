/*
 *  Copyright (c) 2016 Agung Pramono <agungpermadi13@gmail.com || www.github.com/agung pramono>.
 *  All rights reserved.
 * 
 * Silahkan digunakan dengan bebas / dimodifikasi
 * Dengan tetap mencantumkan nama @author dan Referensi / Source
 * Terima Kasih atas Kerjasamanya.
 * 
 *  MasterService.java
 * 
 *  Created on May 20, 2016, 8:16:00 PM
 */
package com.agung.nb.service;

import com.agung.nb.dao.CustomerDao;
import com.agung.nb.domain.Nasabah;
import com.agung.nb.helper.Status;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author agung
 */
public class MasterService{

    private Connection con;
    private CustomerDao nd;
    
    //inisialisasi objek yang dibutuhkan
    public void setConnection(DataSource ds){
        try {
            con = ds.getConnection();
            nd = new CustomerDao();
            nd.setConnection(con);
        } catch (Exception ex) {
        }
    }
    
    /**
     * Proses simpan menggunakan java native database transaction management
     * unntuk menjaga konsistensi data
     * @param n Objek dari kelas Customer
     */
    public void save(Nasabah n){
        if (n != null) {
            try {
                con.setAutoCommit(false);
                nd.saveOrUpdate(n);
                con.commit();
                con.setAutoCommit(true);
            } catch (SQLException ex) {
                try {
                    con.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(MasterService.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }
    }

    public void delete(Nasabah n) {
        if (n !=null) {
            try {
                nd.delete(n);
            } catch (SQLException ex) {
                Logger.getLogger(MasterService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public List<String> selectAttributByParam(Status paramConstan){
        if (paramConstan != null) {
            try {
                return nd.getAttributByParameter(paramConstan.toString());
            } catch (SQLException ex) {
            }
        }
        return null;
    }

    public List<Nasabah> cariSemua() {
        try {
            return nd.cariSemua();
        } catch (Exception ex) {
            Logger.getLogger(MasterService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void deleteAllDataset(){
        try {
            nd.deleteAll();
        } catch (Exception e) {
        }
    }
    
    public Integer hitungSemuaDataset(){
        try {
            return nd.countAllDataset();
        } catch (SQLException e) {
        }
        return null;
    }
    
}
