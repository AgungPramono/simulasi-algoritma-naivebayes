/*
 *  Copyright (c) 2015 Agung Pramono <agungpermadi13@gmail.com || www.github.com/agung pramono>.
 *  All rights reserved.
 * 
 * Silahkan digunakan dengan bebas / dimodifikasi
 * Dengan tetap mencantumkan nama @author dan Referensi / Source
 * Terima Kasih atas Kerjasamanya.
 * 
 *  HasilImportDataset.java
 * 
 *  Created on Dec 27, 2015, 9:19:24 AM
 */
package com.agung.nb.importer;

import com.agung.nb.domain.Customer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author agung
 */
public class HasilImportDataset {
    private List<Customer> succes = new ArrayList<>();

    public List<Customer> getSucces() {
        return succes;
    }

    public void setSucces(List<Customer> succes) {
        this.succes = succes;
    }
}
