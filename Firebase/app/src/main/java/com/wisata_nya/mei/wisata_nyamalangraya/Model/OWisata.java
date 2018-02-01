package com.wisata_nya.mei.wisata_nyamalangraya.Model;

/**
 * Created by mei on 1/20/2018.
 */

public class OWisata {

    String owisataId;
    String owisataName;
    String owisataAlamat;
    String owisataJamOps;
    String owisataHargaTiket;
    String owisataContactPerson;
    String owisataDeskripsi;

    String owisataKoorX;
    String owisataKoorY;

    String owisataKota;
    String Image_URL,Image_Title;

    public OWisata()
    {

    }

    public String getOwisataKoorX() {
        return owisataKoorX;
    }

    public void setOwisataKoorX(String owisataKoorX) {
        this.owisataKoorX = owisataKoorX;
    }

    public String getOwisataKoorY() {
        return owisataKoorY;
    }

    public void setOwisataKoorY(String owisataKoorY) {
        this.owisataKoorY = owisataKoorY;
    }

    public String getOwisataId() {
        return owisataId;
    }

    public void setOwisataId(String owisataId) {
        this.owisataId = owisataId;
    }

    public String getOwisataName() {
        return owisataName;
    }

    public void setOwisataName(String owisataName) {
        this.owisataName = owisataName;
    }

    public String getOwisataDeskripsi() {
        return owisataDeskripsi;
    }

    public void setOwisataDeskripsi(String owisataDeskripsi) {
        this.owisataDeskripsi = owisataDeskripsi;
    }

    public String getOwisataKota() {
        return owisataKota;
    }

    public void setOwisataKota(String owisataKota) {
        this.owisataKota = owisataKota;
    }

    public String getImage_URL() {
        return Image_URL;
    }

    public void setImage_URL(String image_URL) {
        Image_URL = image_URL;
    }

    public String getImage_Title() {
        return Image_Title;
    }

    public void setImage_Title(String image_Title) {
        Image_Title = image_Title;
    }

    public String getOwisataAlamat() {
        return owisataAlamat;
    }

    public void setOwisataAlamat(String owisataAlamat) {
        this.owisataAlamat = owisataAlamat;
    }

    public String getOwisataJamOps() {
        return owisataJamOps;
    }

    public void setOwisataJamOps(String owisataJamOps) {
        this.owisataJamOps = owisataJamOps;
    }

    public String getOwisataHargaTiket() {
        return owisataHargaTiket;
    }

    public void setOwisataHargaTiket(String owisataHargaTiket) {
        this.owisataHargaTiket = owisataHargaTiket;
    }

    public String getOwisataContactPerson() {
        return owisataContactPerson;
    }

    public void setOwisataContactPerson(String owisataContactPerson) {
        this.owisataContactPerson = owisataContactPerson;
    }

    public OWisata(String owisataId, String owisataName, String owisataAlamat, String owisataJamOps, String owisataHargaTiket, String owisataContactPerson, String owisataDeskripsi, String owisataKoorX, String owisataKoorY, String owisataKota, String image_URL, String image_Title) {
        this.owisataId = owisataId;
        this.owisataName = owisataName;
        this.owisataAlamat = owisataAlamat;
        this.owisataJamOps = owisataJamOps;
        this.owisataHargaTiket = owisataHargaTiket;
        this.owisataContactPerson = owisataContactPerson;
        this.owisataDeskripsi = owisataDeskripsi;
        this.owisataKoorX = owisataKoorX;
        this.owisataKoorY = owisataKoorY;
        this.owisataKota = owisataKota;
        Image_URL = image_URL;
        Image_Title = image_Title;
    }

    //    public OWisata(String owisataId, String owisataName, String owisataAlamat, String owisataJamOps, String owisataHargaTiket, String owisataContactPerson, String owisataDeskripsi, String owisataKota, String image_URL, String image_Title) {
//        this.owisataId = owisataId;
//        this.owisataName = owisataName;
//        this.owisataAlamat = owisataAlamat;
//        this.owisataJamOps = owisataJamOps;
//        this.owisataHargaTiket = owisataHargaTiket;
//        this.owisataContactPerson = owisataContactPerson;
//        this.owisataDeskripsi = owisataDeskripsi;
//        this.owisataKota = owisataKota;
//        Image_URL = image_URL;
//        Image_Title = image_Title;
//    }

    public OWisata(String owisataId, String owisataName, String owisataAlamat, String owisataJamOps, String owisataHargaTiket, String owisataContactPerson, String owisataDeskripsi, String owisataKoorX, String owisataKoorY, String owisataKota) {
        this.owisataId = owisataId;
        this.owisataName = owisataName;
        this.owisataAlamat = owisataAlamat;
        this.owisataJamOps = owisataJamOps;
        this.owisataHargaTiket = owisataHargaTiket;
        this.owisataContactPerson = owisataContactPerson;
        this.owisataDeskripsi = owisataDeskripsi;
        this.owisataKoorX = owisataKoorX;
        this.owisataKoorY = owisataKoorY;
        this.owisataKota = owisataKota;
    }

    public OWisata(String owisataKoorX, String owisataKoorY) {
        this.owisataKoorX = owisataKoorX;
        this.owisataKoorY = owisataKoorY;
    }

    //    public OWisata(String owisataId, String owisataName, String owisataAlamat, String owisataJamOps, String owisataHargaTiket, String owisataContactPerson, String owisataDeskripsi, String owisataKota) {
//        this.owisataId = owisataId;
//        this.owisataName = owisataName;
//        this.owisataAlamat = owisataAlamat;
//        this.owisataJamOps = owisataJamOps;
//        this.owisataHargaTiket = owisataHargaTiket;
//        this.owisataContactPerson = owisataContactPerson;
//        this.owisataDeskripsi = owisataDeskripsi;
//        this.owisataKota = owisataKota;
//    }




}
