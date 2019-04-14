/*
 *  Copyright (c) 2016 Agung Pramono <agungpermadi13@gmail.com || www.github.com/agung pramono>.
 *  All rights reserved.
 * 
 * Silahkan digunakan dengan bebas / dimodifikasi
 * Dengan tetap mencantumkan nama @author dan Referensi / Source
 * Terima Kasih atas Kerjasamanya.
 * 
 *  TestingResultDao.java
 * 
 *  Created on Jun 29, 2016, 8:36:51 AM
 */
package com.agung.nb.dao;

import com.agung.nb.domain.Testing;
import com.agung.nb.helper.RowMapperHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author agung
 */
public class TestingResultDao {

    private Connection con;

    private PreparedStatement insertStatement;
    private PreparedStatement selectAllStatement;
    private PreparedStatement validaStatement;
    private PreparedStatement deleteAllStatement;
    private PreparedStatement countAllStatement;

    public void setConnection(Connection con) throws SQLException {
        this.con = con;
        insertStatement = this.con.prepareStatement(SqlHelper.INSERT_QUERY_RESULT);
        selectAllStatement = this.con.prepareStatement(SqlHelper.GET_ALL_QUERY_RESULT);
        validaStatement = this.con.prepareStatement(SqlHelper.SELECT_BY_ALL_ATTRIBUT);
        deleteAllStatement = this.con.prepareStatement(SqlHelper.DELETE_ALL_QUERY_RESULT);
        countAllStatement = this.con.prepareStatement(SqlHelper.COUNT_ALL_DATASET_QUERY);
    }

    public void saveTesting(Testing result) throws SQLException {
        insertStatement.setString(1, result.getPenghasilan());
        insertStatement.setString(2, result.getStatus());
        insertStatement.setString(3, result.getStatusRumah());
        insertStatement.setString(4, result.getPinjaman());
        insertStatement.setString(5, result.getPekerjaan());
        insertStatement.setDouble(6, result.getNilai());
        insertStatement.setString(7, result.getKlasifikasi());
        insertStatement.executeUpdate();
    }

    public Testing findByAttributParam(Testing h) throws SQLException {
        Testing r = new Testing();

        validaStatement.setString(1, h.getPenghasilan());
        validaStatement.setString(2, h.getStatus());
        validaStatement.setString(3, h.getStatusRumah());
        validaStatement.setString(4, h.getPinjaman());
        validaStatement.setString(5, h.getPekerjaan());

        ResultSet rs = validaStatement.executeQuery();
        if (rs.next()) {

            r.setPenghasilan(rs.getString("penghasilan"));
            r.setStatus(rs.getString("status"));
            r.setStatusRumah(rs.getString("status_rumah"));
            r.setPinjaman(rs.getString("pinjaman"));
            r.setPekerjaan(rs.getString("pekerjaan"));

            return r;
        }
        return null;
    }

    public void deleteAllTesting() throws SQLException {
        deleteAllStatement.executeUpdate();
    }

    public List<Testing> getAllTesting() throws SQLException {
        List<Testing> hasil = new ArrayList<>();

        ResultSet rs = selectAllStatement.executeQuery();
        while (rs.next()) {
            Testing testing = RowMapperHelper.toTesting(rs);
            hasil.add(testing);
        }
        return hasil;
    }

    public Integer countAllDataHasil() throws SQLException {
        Integer jumlah = 0;

        ResultSet rs = countAllStatement.executeQuery();
        if (rs.next()) {
            jumlah = rs.getInt("jumlah");
        }
        return jumlah;
    }
}
