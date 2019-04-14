/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agung.nb.helper;

import com.agung.nb.domain.Nasabah;
import com.agung.nb.domain.Testing;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author agung
 */
public class RowMapperHelper {

    public static Nasabah toNasabah(ResultSet rs) throws Exception {
        Nasabah n = new Nasabah();

        n.setId(rs.getInt("id"));
        n.setNamaNasabah(rs.getString("nama_anggota"));
        n.setPenghasilan(rs.getString("penghasilan"));
        n.setStatus(rs.getString("status"));
        n.setStatusRumah(rs.getString("status_rumah"));
        n.setPinjaman(rs.getString("pinjaman"));
        n.setPekerjaan(rs.getString("pekerjaan"));
        n.setKlasifikasi(rs.getString("klasifikasi"));

        return n;
    }

    public static Testing toTesting(ResultSet rs) throws SQLException {
        Testing testing = new Testing();
        testing.setId(rs.getInt("id"));
        testing.setPenghasilan(rs.getString("penghasilan"));
        testing.setStatus(rs.getString("status"));
        testing.setStatusRumah(rs.getString("status_rumah"));
        testing.setPinjaman(rs.getString("pinjaman"));
        testing.setPekerjaan(rs.getString("pekerjaan"));
        testing.setNilai(rs.getDouble("nilai_uji"));
        testing.setKlasifikasi(rs.getString("klasifikasi"));
        
        return testing;
    }

}
