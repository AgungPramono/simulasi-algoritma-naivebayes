/*
 * Copyright (C) 2016 Agung Pramono.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 *  SqlHelper.java
 */
package com.agung.nb.dao;

/**
 *
 * @Created by : agung
 * @Date : 11/Aug/2016
 *
 */
public interface SqlHelper {

    /**
     * Query untuk hasil uji
     */
    String INSERT_QUERY_RESULT
            = "insert into hasiluji (penghasilan,status,status_rumah,pinjaman,pekerjaan,nilai_uji,klasifikasi) values(?,?,?,?,?,?,?)";

    String GET_ALL_QUERY_RESULT
            = "select * from hasiluji order by id asc";

    String DELETE_ALL_QUERY_RESULT
            = "delete from hasiluji";

    String SELECT_BY_ALL_ATTRIBUT
            = "select * from hasiluji where penghasilan=? and status=? and status_rumah=? and pinjaman=? and pekerjaan=?";

    String COUNT_ALL_DATASET_QUERY
            = "select count(*) as jumlah from hasiluji";

    /**
     * Query untuk tabel nasabah
     */
    String INSERT_QUERY_NASABAH
            = "insert into nasabah (nama_anggota,penghasilan,status,status_rumah,pinjaman,"
            + "pekerjaan,klasifikasi) values(?,?,?,?,?,?,?)";

    String UPDATE_QUERY
            = "update nasabah set nama_anggota=?,penghasilan=?,status=?,status_rumah=?,pinjaman=?,"
            + "pekerjaan=?,klasifikasi=? where id=?";

    String DELETE_QUERY
            = "delete from nasabah where id=?";

    String DELETE_ALL_QUERY_NASABAH
            = "delete from nasabah";

    String GET_ALL_QUERY_NASABAH
            = "select * from nasabah order by id desc";

    String COUNT_ALL
            = "select count(*) as jumlah from nasabah";

    /**
     * Query untuk pengujian
     */
    String COUNT_QUERY
            = "select count(*) as jumlah from nasabah where klasifikasi=?";

    String COUNT_PENGHASILAN_QUERY
            = "select count(*) as jumlah from nasabah where penghasilan=? and klasifikasi=?";

    String COUNT_STATUS_QUERY
            = "select count(*) as jumlah from nasabah where status=? and klasifikasi=?";

    String COUNT_STATUS_RM_QUERY
            = "select count(*) as jumlah from nasabah where status_rumah=? and klasifikasi=?";

    String COUNT_PINJAMAN_QUERY
            = "select count(*) as jumlah from nasabah where pinjaman=? and klasifikasi=?";

    String COUNT_PEKERJAAN_QUERY
            = "select count(*) as jumlah from nasabah where pekerjaan=? and klasifikasi=?";

}
