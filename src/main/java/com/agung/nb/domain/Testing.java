/*
 *  Copyright (c) 2016 Agung Pramono <agungpermadi13@gmail.com || www.github.com/agung pramono>.
 *  All rights reserved.
 * 
 * Silahkan digunakan dengan bebas / dimodifikasi
 * Dengan tetap mencantumkan nama @author dan Referensi / Source
 * Terima Kasih atas Kerjasamanya.
 * 
 *  Testing.java
 * 
 *  Created on Jun 29, 2016, 8:27:38 AM
 */
package com.agung.nb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author agung
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Testing {
    private Integer id;
    private String penghasi;
    private String penghasilan;
    private String status;
    private String statusRumah;
    private String pinjaman;
    private String pekerjaan;
    private String klasifikasi;
    private double nilai;
    
}
