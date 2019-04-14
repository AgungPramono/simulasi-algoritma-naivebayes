-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- Host: localhost
-- Waktu pembuatan: 29. Juni 2016 jam 17:00
-- Versi Server: 5.6.22
-- Versi PHP: 6.0.0-dev

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- Database: `datamining`
-- 

-- --------------------------------------------------------

-- 
-- Struktur dari tabel `hasiluji`
-- 

CREATE TABLE `hasiluji` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `penghasilan` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `status_rumah` varchar(255) NOT NULL,
  `pinjaman` varchar(255) NOT NULL,
  `pekerjaan` varchar(255) NOT NULL,
  `nilai_uji` double NOT NULL,
  `klasifikasi` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

-- 
-- Dumping data untuk tabel `hasiluji`
-- 


-- --------------------------------------------------------

-- 
-- Struktur dari tabel `nasabah`
-- 

CREATE TABLE `nasabah` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama_anggota` varchar(255) DEFAULT NULL,
  `penghasilan` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `status_rumah` varchar(255) DEFAULT NULL,
  `pinjaman` varchar(255) DEFAULT NULL,
  `pekerjaan` varchar(255) DEFAULT NULL,
  `klasifikasi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=107 ;

-- 
-- Dumping data untuk tabel `nasabah`
-- 


