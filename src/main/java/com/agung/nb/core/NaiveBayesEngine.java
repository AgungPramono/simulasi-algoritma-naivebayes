/*
 *  Copyright (c) 2016 Agung Pramono <agungpermadi13@gmail.com || www.github.com/agung pramono>.
 *  All rights reserved.
 * 
 * Silahkan digunakan dengan bebas / dimodifikasi
 * Dengan tetap mencantumkan nama @author dan Referensi / Source
 * Terima Kasih atas Kerjasamanya.
 * 
 *  NaiveBayesEngine.java
 * 
 *  Created on May 17, 2016, 8:42:27 PM
 */
package com.agung.nb.core;

import com.agung.nb.Main;

/**
 *
 * @author agung
 */
public class NaiveBayesEngine {

    private Double jumlahLancar;
    private Double jumlahMacet;
    private Double classLancar;
    private Double classMacet;
    private Double nilaiMaxFinal, penghasilan1, penghasilan2, total;
    private String output, klasifikasi;
    private StringBuilder sb;

    public NaiveBayesEngine() {
        hitungJumlahLabel();
    }

    //hitung jumlah class
    private void hitungJumlahLabel() {
        jumlahLancar = (double) Main.getProsesService().getJumlahDataByKlasifikasi("LANCAR");
        jumlahMacet = (double) Main.getProsesService().getJumlahDataByKlasifikasi("MACET");

        total = jumlahLancar + jumlahMacet;

        //Class i / total
        classLancar = jumlahLancar / total;
        classMacet = jumlahMacet / total;
        sb = new StringBuilder();
        sb.append("C1(Class 1) --> Klasifikasi = LANCAR --> ").append(jumlahLancar).append("\n");
        sb.append("C1(Class 2) --> Klasifikasi = MACET --> ").append(jumlahMacet).append("\n");
        sb.append("Total = ").append(total).append("\n\n");
        sb.append("---------------------------------------------------------------\n\n");
        sb.append("Maka" + "\n");
        sb.append("P(C1) = ").append(jumlahLancar).append(" / ").append(total).append(" = ").append(classLancar).append("\n");
        sb.append("P(C2) = ").append(jumlahMacet).append(" / ").append(total).append(" = ").append(classMacet).append("\n\n");
    }

    public void hitungJumlahClassByKasus(String penghasilan, String status, String pinjaman, String statusRumah, String pekerjaan) {
        sb.append("STUDI KASUS \n");
        sb.append("-------------------------------------------------------------------\n");
        sb.append("Penghasilan\t\t: ").append(penghasilan).append("\nStatus\t\t\t: ").append(status).append("\nStatus Rumah\t\t: ")
                .append(statusRumah).append("\nPinjaman\t\t: ").append(pinjaman).append("\nPekerjaan\t\t: ").append(pekerjaan).append("\n");
        sb.append("Klasifikasi\t\t: Macet atau Lancar ?");
        sb.append("\n--------------------------------------------------------------------\n\n");

        /**
         * Hitung jumlah kasus yang sama dengan class yang sama
         */
        //penghasilan
        double penghasilan1 = Main.getProsesService().getJumlahDataByPenghasilan(penghasilan, "LANCAR");
        double jmlPenghasilanClassLancar = penghasilan1 / jumlahLancar;

        double penghasilan2 = Main.getProsesService().getJumlahDataByPenghasilan(penghasilan, "MACET");
        double jmlPenghasilanClassMacet = penghasilan2 / jumlahMacet;

        //sb.append(sb)
        //status
        double status1 = Main.getProsesService().getJumlahDataByStatus(status, "LANCAR");
        double jmlStatusClassLancar = status1 / jumlahLancar;

        double status2 = Main.getProsesService().getJumlahDataByStatus(status, "MACET");
        double jmlStatusClassMacet = status2 / jumlahMacet;

        //status rumah
        double statusRumah1 = Main.getProsesService().getJumlahDataByStatusRumah(statusRumah, "LANCAR");
        double jmlStatusRmClassLancar = statusRumah1 / jumlahLancar;

        double statusRumah2 = Main.getProsesService().getJumlahDataByStatusRumah(statusRumah, "MACET");
        double jmlStatusRmClassMacet = statusRumah2 / jumlahMacet;

        //pinjaman
        double pinjaman1 = Main.getProsesService().getJumlahDataByPinjaman(pinjaman, "LANCAR");
        double jmlPjmClassLancar = pinjaman1 / jumlahLancar;

        double pinjaman2 = Main.getProsesService().getJumlahDataByPinjaman(pinjaman, "MACET");
        double jmlPjmClassMacet = pinjaman2 / jumlahMacet;

        //pekerjaan
        double pekerjaan1 = Main.getProsesService().getJumlahDataByPekerjaan(pekerjaan, "LANCAR");
        double jmlPkrjaanClassLancar = pekerjaan1 / jumlahLancar;

        double pekerjaan2 = Main.getProsesService().getJumlahDataByPekerjaan(pekerjaan, "MACET");
        double jmlPkrjaanClassMacet = pekerjaan2 / jumlahMacet;

        sb.append("Naive Bayes Classifier\n");
        sb.append("--------------------------------------------------\n\n");
        sb.append("P(penghasilan = ").append(penghasilan).append("|Klasifikasi=LANCAR)= ").append(penghasilan1).append("\n");
        sb.append("P(penghasilan = ").append(penghasilan).append("|Klasifikasi=MACET)= ").append(penghasilan2).append("\n");
        sb.append("P(status = ").append(status).append("|Klasifikasi=LANCAR) = ").append(status1).append("\n");
        sb.append("P(status = ").append(status).append("|Klasifikasi=MACET) = ").append(status2).append("\n");
        sb.append("P(status Rumah = ").append(statusRumah).append("|Klasifikasi=LANCAR) = ").append(statusRumah1).append("\n");
        sb.append("P(status Rumah = ").append(statusRumah).append("|Klasifikasi=MACET) = ").append(statusRumah2).append("\n");
        sb.append("P(Pinjaman = ").append(pinjaman).append("|Klasifikasi=LANCAR)= ").append(pinjaman1).append("\n");
        sb.append("P(Pinjaman = ").append(pinjaman).append("|Klasifikasi=MACET) = ").append(pinjaman2).append("\n");
        sb.append("P(Pekerjaan = ").append(pekerjaan).append("|Klasifikasi=LANCAR) = ").append(pekerjaan1).append("\n");
        sb.append("P(Pekerjaan = ").append(pekerjaan).append("|Klasifikasi=MACET) = ").append(pekerjaan2).append("\n\n");

        sb.append("-----------------------------------------------------------------------------------------------\n");
        sb.append("\tAttribut \t\t\t\t\t\tClass/Label\n");
        sb.append("-----------------------------------------------------------------------------------------------\n");
        sb.append("\t\t\t\t\t\tLANCAR\t\t\t\tMACET\n");
        sb.append("===============================================================================================\n");
        sb.append("Penghasilan\n");
        sb.append("::").append(penghasilan).append("\t\t\t\t\t").append(jmlPenghasilanClassLancar).append("\t\t\t")
                .append(jmlPenghasilanClassMacet).append("\n");

        sb.append("-----------------------------------------------------------------------------------------------\n");
        sb.append("Status\n");
        sb.append("::").append(status).append("\t\t\t\t").append(jmlStatusClassLancar).append("\t\t\t").append(jmlStatusClassMacet)
                .append("\n");

        sb.append("-----------------------------------------------------------------------------------------------\n");
        sb.append("Status Rumah\n");
        sb.append("::  ").append(statusRumah).append("\t\t\t\t").append(jmlStatusRmClassLancar).append("\t\t\t")
                .append(jmlStatusRmClassMacet).append("\n");

        sb.append("-----------------------------------------------------------------------------------------------\n");
        sb.append("Pinjaman\n");
        sb.append("::  ").append(pinjaman).append("\t\t\t\t").append(jmlPjmClassLancar).append("\t\t\t").append(jmlPjmClassMacet)
                .append("\n");

        sb.append("-----------------------------------------------------------------------------------------------\n");
        sb.append("Pekerjaan\n");
        sb.append("::   ").append(pekerjaan).append("\t\t\t\t").append(jmlPkrjaanClassLancar).append("\t\t\t").append(jmlPkrjaanClassMacet)
                .append("\n");
        sb.append("===============================================================================================\n\n");

        /**
         * Kalikan semua nilai hasil sesuai dengan data X yang dicari class-nya
         */
        //double lancar = penghasilan1 * status1 * statusRumah1 * jmlPjmClassLancar * jmlPkrjaanClassLancar;
        double lancar = jmlPenghasilanClassLancar * jmlStatusClassLancar * jmlStatusRmClassLancar * jmlPjmClassLancar * jmlPkrjaanClassLancar;

        //double macet = penghasilan2 * status2 * statusRumah2 * jmlPjmClassMacet * jmlPkrjaanClassMacet;
        double macet = jmlPenghasilanClassMacet * jmlStatusClassMacet * jmlStatusRmClassMacet * jmlPjmClassMacet * jmlPkrjaanClassMacet;

        //sb.append("LANCAR = ").append(penghasilan1).append(" * ").append(status1).append(" * ").append(statusRumah1).append(" * ").append(jmlPjmClassLancar).append(" * ").append(jmlPkrjaanClassLancar).append(" = ").append(lancar).append("\n");
        sb.append("LANCAR\t= ").append(jmlPenghasilanClassLancar).append(" * ").append(jmlStatusClassLancar).append(" * ")
                .append(jmlStatusRmClassLancar).append(" * ").append(jmlPjmClassLancar).append(" * ").append(jmlPkrjaanClassLancar)
                .append(" = ").append(lancar).append("\n");

        //sb.append("MACET = ").append(penghasilan2).append(" * ").append(status2).append(" * ").append(statusRumah2).append(" * ").append(jmlPjmClassMacet).append(" * ").append(jmlPkrjaanClassMacet).append(" = ").append(macet).append("\n\n");
        sb.append("MACET\t= ").append(jmlPenghasilanClassMacet).append(" * ").append(jmlStatusClassMacet).append(" * ")
                .append(jmlStatusRmClassMacet).append(" * ").append(jmlPjmClassMacet).append(" * ").append(jmlPkrjaanClassMacet)
                .append(" = ").append(macet).append("\n\n");

        cariNilaiMax(lancar, macet);

        //set untuk menampilkan hasil
        setOutput(sb.toString());
    }

    private void cariNilaiMax(double lancar, double macet) {
        double nilaiMaxLancar = lancar * classLancar;
        double nilaiMacMacet = macet * classMacet;

        //cari nilai maksimal
        double nilaiMaxFinal = Math.max(nilaiMaxLancar, nilaiMacMacet);

        if (nilaiMaxLancar == nilaiMaxFinal && nilaiMaxLancar != 0) {
            setNilaiMaxFinal(nilaiMaxFinal);
            setKlasifikasi("LANCAR");
        } else if (nilaiMacMacet == nilaiMaxFinal && nilaiMacMacet != 0) {
            setNilaiMaxFinal(nilaiMaxFinal);
            setKlasifikasi("MACET");
        } else {
            setNilaiMaxFinal(Double.MIN_VALUE);
            setKlasifikasi("-");
        }

        sb.append("Nilai Maximal Lancar = ").append(lancar).append(" * ").append(classLancar).append(" = ").append(nilaiMaxLancar).append("\n");
        sb.append("Nilai Maximal Macet = ").append(macet).append(" * ").append(classMacet).append(" = ").append(nilaiMacMacet).append("\n");
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getKlasifikasi() {
        return klasifikasi;
    }

    public void setKlasifikasi(String klasifikasi) {
        this.klasifikasi = klasifikasi;
    }

    public Double getNilaiMaxFinal() {
        return nilaiMaxFinal;
    }

    public void setNilaiMaxFinal(Double nilaiMaxFinal) {
        this.nilaiMaxFinal = nilaiMaxFinal;
    }

}
