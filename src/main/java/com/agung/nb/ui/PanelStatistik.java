/*
 *  Copyright (c) 2016 Agung Pramono <agungpermadi13@gmail.com || www.github.com/agung pramono>.
 *  All rights reserved.
 * 
 * Silahkan digunakan dengan bebas / dimodifikasi
 * Dengan tetap mencantumkan nama @author dan Referensi / Source
 * Terima Kasih atas Kerjasamanya.
 * 
 *  PanelStatistik.java
 * 
 *  Created on Jul 18, 2016, 7:42:42 PM
 */
package com.agung.nb.ui;

import com.agung.nb.Main;
import java.awt.BorderLayout;
import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author agung
 */
public class PanelStatistik extends javax.swing.JPanel {

    public static final String PANEL_NAME = "<html><b>Statistik</b></html>";
    private static PanelStatistik panelStatistik;
    private static final String LANCAR = "LANCAR";
    private static final String MACET = "MACET";

    public PanelStatistik() {
        initComponents();
        createChart("penghasilan");
    }

    public static PanelStatistik getPanelStatistik() {
        if (panelStatistik == null) {
            panelStatistik = new PanelStatistik();
        }
        return panelStatistik;
    }

    private void createChart(String option) {
        JFreeChart barChart = ChartFactory.createBarChart3D(
                "Statistik Dataset (" + option + ")",
                "Klasifikasi",
                "Jumlah Data",
                createDataset(option),
                PlotOrientation.VERTICAL,
                true, true, false
        );

        CategoryPlot plot = barChart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.BLACK);

        ChartPanel chartPanel = new ChartPanel(barChart);
        panel.removeAll();
        panel.add(chartPanel, BorderLayout.CENTER);
        panel.repaint();
        panel.updateUI();

        setVisible(true);
    }

    private CategoryDataset createDataset(String option) {

        switch (option.toLowerCase()) {
            case "penghasilan":
                return createChartJumlahPenghasilan();
            case "status":
                return createChartStatus();
            case "status rumah":
                return createChartStatusRumah();
            case "pinjaman":
                return createChartPinjaman();
            case "pekerjaan":
                return createChartPekerjaan();
            default:
                new Object();
        }
        return null;
    }

    private DefaultCategoryDataset createChartJumlahPenghasilan() {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        Integer jumlahPenghasilanLancar1 = Main.getProsesService().getJumlahDataByPenghasilan(">=4jt", "Lancar");
        Integer jumlahPenghasilanMacet1 = Main.getProsesService().getJumlahDataByPenghasilan(">=4jt", "Macet");
        Integer jumlahPenghasilanLancar2 = Main.getProsesService().getJumlahDataByPenghasilan("<4jt", "Lancar");
        Integer jumlahPenghasilanMacet2 = Main.getProsesService().getJumlahDataByPenghasilan("<4jt", "Macet");

        dataset.addValue(jumlahPenghasilanLancar1, LANCAR, "Penghasilan >=4jt");
        dataset.addValue(jumlahPenghasilanMacet1, MACET, "Penghasilan >=4jt");
        dataset.addValue(jumlahPenghasilanLancar2, LANCAR, "Penghasilan <4jt");
        dataset.addValue(jumlahPenghasilanMacet2, MACET, "Penghasilan <4jt");

        return dataset;
    }

    private DefaultCategoryDataset createChartStatus() {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        Integer jumlahStatusLancar1 = Main.getProsesService().getJumlahDataByStatus("menikah", "Lancar");
        Integer jumlahStatusMacet1 = Main.getProsesService().getJumlahDataByStatus("menikah", "Macet");
        Integer jumlahStatusLancar2 = Main.getProsesService().getJumlahDataByStatus("belum menikah", "Lancar");
        Integer jumlahStatusMacet2 = Main.getProsesService().getJumlahDataByStatus("belum menikah", "Macet");

        dataset.addValue(jumlahStatusLancar1, LANCAR, "menikah");
        dataset.addValue(jumlahStatusMacet1, MACET, "menikah");
        dataset.addValue(jumlahStatusLancar2, LANCAR, "belum menikah");
        dataset.addValue(jumlahStatusMacet2, MACET, "belum menikah");

        return dataset;
    }

    private DefaultCategoryDataset createChartStatusRumah() {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        Integer jumlahStatusRumahLancar1 = Main.getProsesService().getJumlahDataByStatusRumah("pribadi", "Lancar");
        Integer jumlahStatusRumahMacet1 = Main.getProsesService().getJumlahDataByStatusRumah("pribadi", "Macet");
        Integer jumlahStatusRumahLancar2 = Main.getProsesService().getJumlahDataByStatusRumah("sewa", "Lancar");
        Integer jumlahStatusRumahMacet2 = Main.getProsesService().getJumlahDataByStatusRumah("sewa", "Macet");

        dataset.addValue(jumlahStatusRumahLancar1, LANCAR, "pribadi");
        dataset.addValue(jumlahStatusRumahMacet1, MACET, "pribadi");
        dataset.addValue(jumlahStatusRumahLancar2, LANCAR, "sewa");
        dataset.addValue(jumlahStatusRumahMacet2, MACET, "sewa");

        return dataset;
    }

    private DefaultCategoryDataset createChartPinjaman() {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        Integer jumlahPinjamanLancar1 = Main.getProsesService().getJumlahDataByPinjaman(">4jt", "Lancar");
        Integer jumlahPinjamanMacet1 = Main.getProsesService().getJumlahDataByPinjaman(">4jt", "Macet");
        Integer jumlahPinjamanLancar2 = Main.getProsesService().getJumlahDataByPinjaman("3jt-4jt", "Lancar");
        Integer jumlahPinjamanMacet2 = Main.getProsesService().getJumlahDataByPinjaman("3jt-4jt", "Macet");

        dataset.addValue(jumlahPinjamanLancar1, LANCAR, "Pinjaman >4jt");
        dataset.addValue(jumlahPinjamanMacet1, MACET, "Pinjaman >4jt");
        dataset.addValue(jumlahPinjamanLancar2, LANCAR, "Pinjaman 3jt-4jt");
        dataset.addValue(jumlahPinjamanMacet2, MACET, "Pinjaman 3jt-4jt");

        return dataset;
    }

    private DefaultCategoryDataset createChartPekerjaan() {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        Integer jumlahPekerjaanLancar1 = Main.getProsesService().getJumlahDataByPekerjaan("pns", "Lancar");
        Integer jumlahPekerjaanMacet1 = Main.getProsesService().getJumlahDataByPekerjaan("pns", "Macet");
        Integer jumlahPekerjaanLancar2 = Main.getProsesService().getJumlahDataByPekerjaan("swasta", "Lancar");
        Integer jumlahPekerjaanMacet2 = Main.getProsesService().getJumlahDataByPekerjaan("swasta", "Macet");

        dataset.addValue(jumlahPekerjaanLancar1, LANCAR, "pns");
        dataset.addValue(jumlahPekerjaanMacet1, MACET, "pns");
        dataset.addValue(jumlahPekerjaanLancar2, LANCAR, "swasta");
        dataset.addValue(jumlahPekerjaanMacet2, MACET, "swasta");

        return dataset;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbFilter = new javax.swing.JComboBox();
        btnClose = new javax.swing.JButton();

        setBackground(new java.awt.Color(109, 172, 218));

        panel.setBackground(new java.awt.Color(153, 153, 153));
        panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel.setLayout(new java.awt.BorderLayout(10, 10));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Filter ");

        cbFilter.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbFilter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Penghasilan", "Status", "Status Rumah", "Pinjaman", "Pekerjaan" }));
        cbFilter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFilterItemStateChanged(evt);
            }
        });
        cbFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFilterActionPerformed(evt);
            }
        });

        btnClose.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/windows_close.png"))); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(257, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnClose))
                .addGap(4, 4, 4))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnClose, cbFilter});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbFilterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFilterItemStateChanged
        String option = cbFilter.getSelectedItem().toString();
        createChart(option);
    }//GEN-LAST:event_cbFilterItemStateChanged

    private void cbFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFilterActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cbFilterActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        Main.getMainFrame().getMainTabbedPane().remove(this);
    }//GEN-LAST:event_btnCloseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JComboBox cbFilter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
