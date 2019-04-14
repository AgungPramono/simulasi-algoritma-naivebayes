/*
 *  Copyright (c) 2016 Agung Pramono <agungpermadi13@gmail.com || www.github.com/agung pramono>.
 *  All rights reserved.
 * 
 * Silahkan digunakan dengan bebas / dimodifikasi
 * Dengan tetap mencantumkan nama @author dan Referensi / Source
 * Terima Kasih atas Kerjasamanya.
 * 
 *  DatasetTableModel.java
 * 
 *  Created on Jul 4, 2016, 4:19:53 PM
 */
package com.agung.nb.modul;

import com.agung.nb.domain.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author agung
 */
public class DatasetTableModel extends AbstractTableModel {
    private List<Customer> result = new ArrayList<>();
        private final String[] header = {"Nama Nasabah", "Penghasilan", "Status", "Status Rumah",
            "Pinjaman", "Pekerjaan", "Klasifikasi"};

        public DatasetTableModel(List<Customer> list) {
            this.result = list;
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
            Customer n = result.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return n.getNamaNasabah();
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
                    return n.getKlasifikasi();
                default:
                    return "";
            }
        }
}
