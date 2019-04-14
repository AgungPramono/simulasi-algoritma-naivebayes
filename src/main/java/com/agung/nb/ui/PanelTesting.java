/*
 *  Copyright (c) 2016 Agung Pramono <agungpermadi13@gmail.com || www.github.com/agung pramono>.
 *  All rights reserved.
 * 
 * Silahkan digunakan dengan bebas / dimodifikasi
 * Dengan tetap mencantumkan nama @author dan Referensi / Source
 * Terima Kasih atas Kerjasamanya.
 * 
 *  PanelTesting.java
 * 
 *  Created on Jul 17, 2016, 6:55:10 PM
 */
package com.agung.nb.ui;

import com.agung.nb.Main;
import com.agung.nb.core.NaiveBayesEngine;
import com.agung.nb.domain.Testing;
import com.agung.nb.modul.TableUtil;
import com.agung.nb.modul.TestingTableModel;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author agung
 */
public class PanelTesting extends javax.swing.JPanel {

    public static final String PANEL_NAME = "<html><body><b>Testing</b></body></html>";
    private static PanelTesting panel;
    private Testing hasilUji;

    public PanelTesting() {
        initComponents();
        initComboBox();
    }

    public static PanelTesting getTestingPanel() {
        if (panel == null) {
            panel = new PanelTesting();
        }
        return panel;
    }

    private Boolean validasiForm() {
        if (cbPenghasilan.getSelectedItem().toString().trim().length() > 1
                && cbStatus.getSelectedItem().toString().trim().length() > 1
                && cbStatusRumah.getSelectedItem().toString().trim().length() > 1
                && cbPinjaman.getSelectedItem().toString().trim().length() > 1
                && cbPekerjaaan.getSelectedItem().toString().trim().length() > 1) {
            return true;
        }
        return false;
    }

    public void initComboBox() {
        cbPenghasilan.removeAllItems();
        cbPekerjaaan.removeAllItems();
        cbStatus.removeAllItems();
        cbStatusRumah.removeAllItems();
        cbPinjaman.removeAllItems();
        List<String> listPenghasilan = Main.getMasterService().selectAttributByParam("penghasilan");

        for (String r : listPenghasilan) {
            cbPenghasilan.addItem(r);
        }

        List<String> listStatus = Main.getMasterService().selectAttributByParam("status");
        for (String s : listStatus) {
            cbStatus.addItem(s);
        }

        List<String> listStatusRumah = Main.getMasterService().selectAttributByParam("status_rumah");
        for (String rm : listStatusRumah) {
            cbStatusRumah.addItem(rm);
        }

        List<String> listPinjaman = Main.getMasterService().selectAttributByParam("pinjaman");
        for (String p : listPinjaman) {
            cbPinjaman.addItem(p);
        }

        List<String> listPekerjaan = Main.getMasterService().selectAttributByParam("pekerjaan");
        for (String pkj : listPekerjaan) {
            cbPekerjaaan.addItem(pkj);
        }
    }

    private Testing cekHasilUjiExist() {
        Testing hu = new Testing();
        hu.setPenghasilan(cbPenghasilan.getSelectedItem().toString());
        hu.setStatus(cbStatus.getSelectedItem().toString());
        hu.setStatusRumah(cbStatusRumah.getSelectedItem().toString());
        hu.setPinjaman(cbPinjaman.getSelectedItem().toString());
        hu.setPekerjaan(cbPekerjaaan.getSelectedItem().toString());

        Testing h = Main.getProsesService().findForValidateTesting(hu);
        return h;
    }

    private void prosesAlgoritma(String penghasilan, String status,
            String statusRumah, String pinjaman, String pekerjaan) {
        //proses dg metode naive bayes
        NaiveBayesEngine nb = new NaiveBayesEngine();
        nb.hitungJumlahClassByKasus(penghasilan, status, pinjaman, statusRumah, pekerjaan);
        txaOutput.setText(nb.getOutput());

        DecimalFormat formater = new DecimalFormat("##.#####");
        lblKlasifikasi.setText(nb.getKlasifikasi());
        lblNilaiMax.setText(String.valueOf(formater.format(nb.getNilaiMaxFinal())));

        //simpan data pengujian
        loadDataPengujian(nb.getNilaiMaxFinal(), nb.getKlasifikasi());
    }

    private void loadDataPengujian(double nilaiUji, String klasifikasi) {
        if (hasilUji == null) {
            hasilUji = new Testing();
        }
        hasilUji.setPenghasilan(cbPenghasilan.getSelectedItem().toString());
        hasilUji.setStatus(cbStatus.getSelectedItem().toString());
        hasilUji.setStatusRumah(cbStatusRumah.getSelectedItem().toString());
        hasilUji.setPinjaman(cbPinjaman.getSelectedItem().toString());
        hasilUji.setPekerjaan(cbPekerjaaan.getSelectedItem().toString());

        hasilUji.setNilai(nilaiUji);
        hasilUji.setKlasifikasi(klasifikasi);

        try {
            Main.getProsesService().simpanPengujian(hasilUji);

            JOptionPane.showMessageDialog(this, "KASUS PENGUJIAN BARU !! DATA DISIMPAN", "Informasi",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearForm() {
        lblKlasifikasi.setText("");
        lblNilaiMax.setText("");
        txaOutput.setText("");
        cbPenghasilan.setSelectedIndex(0);
        cbStatus.setSelectedIndex(0);
        cbStatusRumah.setSelectedIndex(0);
        cbPinjaman.setSelectedIndex(0);
        cbPekerjaaan.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnProses = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnReset = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbPenghasilan = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cbStatusRumah = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cbPinjaman = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cbPekerjaaan = new javax.swing.JComboBox();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblNilaiMax = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblKlasifikasi = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaOutput = new javax.swing.JTextArea();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        btnProses.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnProses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gearwheel_play.png"))); // NOI18N
        btnProses.setText("Proses");
        btnProses.setPreferredSize(new java.awt.Dimension(67, 25));
        btnProses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/selection_recycle.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnKeluar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/windows_close.png"))); // NOI18N
        btnKeluar.setText("Close");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(153, 153, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Nilai Attribut", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel1.setText("Penghasilan");

        cbPenghasilan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));

        jLabel2.setText("Status");

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));

        jLabel3.setText("Status Rumah");

        cbStatusRumah.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));

        jLabel4.setText("Pinjaman");

        cbPinjaman.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));

        jLabel5.setText("Pekerjaan");

        cbPekerjaaan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbPekerjaaan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbPinjaman, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbPenghasilan, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbStatusRumah, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPenghasilan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbStatusRumah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbPinjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbPekerjaaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(0, 204, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Klasifikasi", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Nilai Max");

        lblNilaiMax.setFont(new java.awt.Font("Courier New", 1, 36)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Klasifikasi");

        lblKlasifikasi.setFont(new java.awt.Font("Courier New", 1, 36)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(221, 221, 221))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(lblNilaiMax, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(lblKlasifikasi, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblKlasifikasi, lblNilaiMax});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNilaiMax, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblKlasifikasi)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblKlasifikasi, lblNilaiMax});

        jPanel8.setBackground(new java.awt.Color(153, 153, 0));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Output", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        txaOutput.setEditable(false);
        txaOutput.setColumns(20);
        txaOutput.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        txaOutput.setRows(5);
        jScrollPane2.setViewportView(txaOutput);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnProses, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel6, jPanel7});

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnKeluar, btnProses});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnProses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReset)
                            .addComponent(btnKeluar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnKeluar, btnProses, btnReset});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesActionPerformed
        String penghasilan = cbPenghasilan.getSelectedItem().toString();
        String status = cbStatus.getSelectedItem().toString();
        String statusRumah = cbStatusRumah.getSelectedItem().toString();
        String pinjaman = cbPinjaman.getSelectedItem().toString();
        String pekerjaan = cbPekerjaaan.getSelectedItem().toString();

        try {
            Integer jumlahData = Main.getMasterService().hitungSemuaDataset();
            if (jumlahData >= 1) {
                if (validasiForm()) {
                    if (cekHasilUjiExist() == null) {
                        prosesAlgoritma(penghasilan, status, statusRumah, pinjaman, pekerjaan);
                    } else {
                        //clearForm();
                        txaOutput.setText("");
                        lblKlasifikasi.setText("");
                        lblNilaiMax.setText("");
                        JOptionPane.showMessageDialog(this, "PENGUJIAN SUDAH PERNAH DILAKUKAN !!!"
                                + " GANTI DG KASUS LAIN",
                                "Terjadi Kesalahan !", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Kriteria pengujian tidak lengkap !!", "Terjadi Kesalahan",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else if (jumlahData < 1 || jumlahData == 0) {
                JOptionPane.showMessageDialog(this, "Pengujian tidak dapat di lakukan ! Dataset masih kosong",
                        "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnProsesActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        //initComboBox();
        clearForm();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        Main.getMainFrame().getMainTabbedPane().remove(this);
        panel = null;
    }//GEN-LAST:event_btnKeluarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnProses;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox cbPekerjaaan;
    private javax.swing.JComboBox cbPenghasilan;
    private javax.swing.JComboBox cbPinjaman;
    private javax.swing.JComboBox cbStatus;
    private javax.swing.JComboBox cbStatusRumah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblKlasifikasi;
    private javax.swing.JLabel lblNilaiMax;
    private javax.swing.JTextArea txaOutput;
    // End of variables declaration//GEN-END:variables
}
