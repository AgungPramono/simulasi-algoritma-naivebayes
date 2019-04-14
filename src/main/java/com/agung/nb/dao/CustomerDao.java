package com.agung.nb.dao;

import com.agung.nb.domain.Nasabah;
import com.agung.nb.helper.RowMapperHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author agung
 */
public class CustomerDao {

    private Connection con;

    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement deleteStatement;
    private PreparedStatement deleteAllStatement;
    private PreparedStatement selectAllStatement;
    private PreparedStatement countAllStatement;

    public void setConnection(Connection con) throws Exception {
        this.con = con;
        insertStatement = this.con.prepareStatement(SqlHelper.INSERT_QUERY_NASABAH, 
                                                        Statement.RETURN_GENERATED_KEYS);
        updateStatement = this.con.prepareStatement(SqlHelper.UPDATE_QUERY);
        deleteStatement = this.con.prepareStatement(SqlHelper.DELETE_QUERY);
        deleteAllStatement = this.con.prepareStatement(SqlHelper.DELETE_ALL_QUERY_NASABAH);
        selectAllStatement = this.con.prepareStatement(SqlHelper.GET_ALL_QUERY_NASABAH);
        countAllStatement = this.con.prepareStatement(SqlHelper.COUNT_ALL);
    }

    public void saveOrUpdate(Nasabah nasabah) throws SQLException {
        if (nasabah.getId() == null) {

            insertStatement.setString(1, nasabah.getNamaNasabah());
            insertStatement.setString(2, nasabah.getPenghasilan());
            insertStatement.setString(3, nasabah.getStatus());
            insertStatement.setString(4, nasabah.getStatusRumah());
            insertStatement.setString(5, nasabah.getPinjaman());
            insertStatement.setString(6, nasabah.getPekerjaan());
            insertStatement.setString(7, nasabah.getKlasifikasi());
            int id = insertStatement.executeUpdate();
            nasabah.setId(id);

        } else {
            updateStatement.setString(1, nasabah.getNamaNasabah());
            updateStatement.setString(2, nasabah.getPenghasilan());
            updateStatement.setString(3, nasabah.getStatus());
            updateStatement.setString(4, nasabah.getStatusRumah());
            updateStatement.setString(5, nasabah.getPinjaman());
            updateStatement.setString(6, nasabah.getPekerjaan());
            updateStatement.setString(7, nasabah.getKlasifikasi());
            updateStatement.setInt(8, nasabah.getId());
            updateStatement.executeUpdate();
        }
    }

    public void delete(Nasabah nasabah) throws SQLException {
        deleteStatement.setInt(1, nasabah.getId());
        deleteStatement.executeUpdate();
    }

    public void deleteAll() throws SQLException {
        deleteAllStatement.executeUpdate();
    }

    public List<String> getAttributByParameter(String param) throws SQLException {

        List<String> result = new ArrayList<>();

        StringBuilder sb = new StringBuilder("select distinct ");

        switch (param.toLowerCase()) {
            case "penghasilan":
                sb.append("penghasilan ");
                break;
            case "status":
                sb.append("status");
                break;
            case "status_rumah":
                sb.append("status_rumah");
                break;
            case "pinjaman":
                sb.append("pinjaman");
                break;
            case "pekerjaan":
                sb.append("pekerjaan");
                break;
        }

        sb.append(" from nasabah");

        Connection Koneksi = con;
        PreparedStatement ps = Koneksi.prepareStatement(sb.toString());

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String data;
            data = rs.getString(param);
            result.add(data);
        }
        return result;
    }

    public List<Nasabah> cariSemua() throws SQLException, Exception {
        List<Nasabah> result = new ArrayList<>();

        ResultSet rs = selectAllStatement.executeQuery();
        while (rs.next()) {
            Nasabah n =  RowMapperHelper.toNasabah(rs);
            result.add(n);
        }
        return result;
    }

    public Integer countAllDataset() throws SQLException {
        Integer jumlah = 0;

        ResultSet rs = countAllStatement.executeQuery();
        if (rs.next()) {
            jumlah = rs.getInt("jumlah");
        }
        return jumlah;
    }

    
}
