package com.agung.nb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author agung
 */
public class ProgressDao {

    private Connection con;
    private PreparedStatement countByKlasifikasiStatement;
    private PreparedStatement countByPenghasilanStatement;
    private PreparedStatement countByStatusStatement;
    private PreparedStatement countByStatusRumahStatement;
    private PreparedStatement countByPinjamanStatement;
    private PreparedStatement countByPekerjaanStatement;

    public void setConnection(Connection koneksi) throws SQLException {
        this.con = koneksi;
        countByKlasifikasiStatement = this.con.prepareStatement(SqlHelper.COUNT_QUERY);
        countByPenghasilanStatement = this.con.prepareStatement(SqlHelper.COUNT_PENGHASILAN_QUERY);
        countByStatusStatement = this.con.prepareStatement(SqlHelper.COUNT_STATUS_QUERY);
        countByStatusRumahStatement = this.con.prepareStatement(SqlHelper.COUNT_STATUS_RM_QUERY);
        countByPinjamanStatement = this.con.prepareStatement(SqlHelper.COUNT_PINJAMAN_QUERY);
        countByPekerjaanStatement = this.con.prepareStatement(SqlHelper.COUNT_PEKERJAAN_QUERY);
    }

    public Integer countByKlasifikasi(String klasifikasi) throws SQLException {
        Integer jumlah = 0;

        countByKlasifikasiStatement.setString(1, klasifikasi);
        ResultSet rs = countByKlasifikasiStatement.executeQuery();
        if (rs.next()) {
            jumlah = rs.getInt("jumlah");
        }
        return jumlah;
    }

    public Integer countByPenghasilan(String option, String value) throws SQLException {
        Integer jumlah = 0;

        countByPenghasilanStatement.setString(1, option);
        countByPenghasilanStatement.setString(2, value);
        ResultSet rs = countByPenghasilanStatement.executeQuery();
        if (rs.next()) {
            jumlah = rs.getInt("jumlah");
        }
        return jumlah;
    }

    public Integer countByStatus(String option, String value) throws SQLException {
        Integer jumlah = 0;

        countByStatusStatement.setString(1, option);
        countByStatusStatement.setString(2, value);
        ResultSet rs = countByStatusStatement.executeQuery();
        if (rs.next()) {
            jumlah = rs.getInt("jumlah");
        }
        return jumlah;
    }

    public Integer countByStatusRumah(String option, String value) throws SQLException {
        Integer jumlah = 0;

        countByStatusRumahStatement.setString(1, option);
        countByStatusRumahStatement.setString(2, value);
        ResultSet rs = countByStatusRumahStatement.executeQuery();
        if (rs.next()) {
            jumlah = rs.getInt("jumlah");
        }
        return jumlah;
    }

    public Integer countByPinjaman(String option, String value) throws SQLException {
        Integer jumlah = 0;

        countByPinjamanStatement.setString(1, option);
        countByPinjamanStatement.setString(2, value);
        ResultSet rs = countByPinjamanStatement.executeQuery();
        if (rs.next()) {
            jumlah = rs.getInt("jumlah");
        }
        return jumlah;
    }

    public Integer countByPekerjaan(String option, String value) throws SQLException {
        Integer jumlah = 0;

        countByPekerjaanStatement.setString(1, option);
        countByPekerjaanStatement.setString(2, value);
        ResultSet rs = countByPekerjaanStatement.executeQuery();
        if (rs.next()) {
            jumlah = rs.getInt("jumlah");
        }
        return jumlah;
    }

}
