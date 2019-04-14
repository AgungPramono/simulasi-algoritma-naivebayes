/*
 *  Copyright (c) 2016 Agung Pramono <agungpermadi13@gmail.com || www.github.com/agung pramono>.
 *  All rights reserved.
 * 
 * Silahkan digunakan dengan bebas / dimodifikasi
 * Dengan tetap mencantumkan nama @author dan Referensi / Source
 * Terima Kasih atas Kerjasamanya.
 * 
 *  TestingTableModel.java
 * 
 *  Created on Jul 4, 2016, 4:22:11 PM
 */
package com.agung.nb.modul;

import com.agung.nb.domain.Testing;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author agung
 */
public class TestingTableModel extends AbstractTableModel {
    private List<Testing> result = new ArrayList<>();

        private String[] header = {"ID Pengujian", "Penghasilan", "Status", "Status Rumah",
            "Pinjaman", "Pekerjaan", "Nilai Pengujian", "Klasifikasi"};

        public TestingTableModel(List<Testing> result) {
            this.result = result;
        }

        @Override
        public int getRowCount() {
            return result.size();
        }

        @Override
        public int getColumnCount() {
            return header.length;
        }

        @Override
        public String getColumnName(int column) {
            return header[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Testing n = result.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return n.getId();
                case 1:
                    return n.getPenghasilan();
                case 2:
                    return n.getStatus();
                case 3:
                    return n.getStatusRumah();
                case 4:
                    return n.getPinjaman();
                case 5:
                    return n.getPekerjaan();
                case 6:
                    return n.getNilai();
                case 7:
                    return n.getKlasifikasi();
                default:
                    return "";
            }
        }
}
