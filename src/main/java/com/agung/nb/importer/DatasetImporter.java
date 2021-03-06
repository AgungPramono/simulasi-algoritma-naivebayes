/*
 *  Copyright (c) 2015 Agung Pramono <agungpermadi13@gmail.com || www.github.com/agung pramono>.
 *  All rights reserved.
 * 
 * Silahkan digunakan dengan bebas / dimodifikasi
 * Dengan tetap mencantumkan nama @author dan Referensi / Source
 * Terima Kasih atas Kerjasamanya.
 * 
 *  ProdukExporter.java
 * 
 *  Created on Dec 27, 2015, 8:52:51 AM
 */
package com.agung.nb.importer;

import com.agung.nb.domain.Nasabah;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author agung
 */
public class DatasetImporter {
    
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(DatasetImporter.class);

    public static HasilImportDataset proses(File file,String sparator) throws FileNotFoundException {
        try {
            List<Nasabah> dataNasabah = new ArrayList<>();

            HasilImportDataset hasil = new HasilImportDataset();
            hasil.setSucces(dataNasabah);

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String data = br.readLine();

            Integer noBaris = 0;

            while ((data = br.readLine()) != null) {
                noBaris++;
//                System.out.println("Data : " + data);
                String[] baris = data.split(sparator);
//                System.out.println("jumlah kolom " + baris.length);

                Nasabah n = new Nasabah();
                n.setNamaNasabah(baris[0]);
                n.setPenghasilan(baris[1]);
                n.setStatus(baris[2]);
                n.setStatusRumah(baris[3]);
                n.setPinjaman(baris[4]);
                n.setPekerjaan(baris[5]);
                n.setKlasifikasi(baris[6]);

                dataNasabah.add(n);

            }
            br.close();
            fr.close();

            return hasil;
        } catch (IOException ex) {
            LOGGER.error("Error Read File {}", ex.fillInStackTrace());
        }
        return null;
    }
}
