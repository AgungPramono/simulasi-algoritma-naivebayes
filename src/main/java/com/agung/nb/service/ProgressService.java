/*
 *  Copyright (c) 2016 Agung Pramono <agungpermadi13@gmail.com || www.github.com/agung pramono>.
 *  All rights reserved.
 * 
 * Silahkan digunakan dengan bebas / dimodifikasi
 * Dengan tetap mencantumkan nama @author dan Referensi / Source
 * Terima Kasih atas Kerjasamanya.
 * 
 *  ProgressService.java
 * 
 *  Created on May 21, 2016, 9:17:10 PM
 */
package com.agung.nb.service;

import com.agung.nb.dao.TestingResultDao;
import com.agung.nb.dao.ProgressDao;
import com.agung.nb.domain.Testing;
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
public class ProgressService {
    
    private Connection con;
    private ProgressDao pd;
    private TestingResultDao hd;
    
    public void setConnection(DataSource ds){
        try {
            this.con = ds.getConnection();
            
            pd = new ProgressDao();
            hd = new TestingResultDao();
            
            pd.setConnection(con);
            hd.setConnection(con);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public Integer getJumlahDataByKlasifikasi(String klasifikasi){
        if (klasifikasi != null) {
            try {
                return pd.countByKlasifikasi(klasifikasi);
            } catch (SQLException ex) {
                Logger.getLogger(ProgressService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            return 0;
        }
        return null;
    }
    
    public Integer getJumlahDataByPenghasilan(String option,String value){
        if (option != null && value != null) {
            try {
                return pd.countByPenghasilan(option, value);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }  
        }else{
            return 0;
        }
        return null;
    }
    
    public Integer getJumlahDataByStatus(String option,String value){
        if (option != null && value != null) {
            try {
                return pd.countByStatus(option, value);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }  
        }else{
            return 0;
        }
        return null;
    }
    
    public Integer getJumlahDataByStatusRumah(String option,String value){
        if (option != null && value != null) {
            try {
                return pd.countByStatusRumah(option, value);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }  
        }else{
            return 0;
        }
        return null;
    }
    
    public Integer getJumlahDataByPinjaman(String option,String value){
        if (option != null && value != null) {
            try {
                return pd.countByPinjaman(option, value);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }  
        }else{
            return 0;
        }
        return null;
    }
    
    public Integer getJumlahDataByPekerjaan(String option,String value){
        if (option != null && value != null) {
            try {
                return pd.countByPekerjaan(option, value);
            } catch (SQLException ex) {
            }  
        }else{
            return 0;
        }
        return null;
    }
    
    public void simpanPengujian(Testing hu){
        try {
            if (hu != null) {
                con.setAutoCommit(false);
                hd.saveTesting(hu);
                con.commit();
                con.setAutoCommit(true);
            }
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(ProgressService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public List<Testing> cariSemuaPengujian(){
        try {
            return hd.getAllTesting();
        } catch (SQLException e) {
        }
        return null;
    }
    
    public Testing findForValidateTesting(Testing h){
        try {
            if (h == null) {
                return new Testing();
            }
            return hd.findByAttributParam(h);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void hapusSemuaDataUji(){
        try {
            hd.deleteAllTesting();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Integer jumlahDataHasil(){
        try {
            return hd.countAllDataHasil();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
