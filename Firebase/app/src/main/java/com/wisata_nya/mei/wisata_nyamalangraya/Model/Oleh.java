package com.wisata_nya.mei.wisata_nyamalangraya.Model;

/**
 * Created by mei on 1/28/2018.
 */

public class Oleh {

    String olehId;
    String olehNama;
    String olehHarga;
    String olehVarian;
    String olehKeterangan;

    public Oleh() {    }

    public Oleh(String olehId, String olehNama, String olehHarga, String olehVarian, String olehKeterangan) {
        this.olehId = olehId;
        this.olehNama = olehNama;
        this.olehHarga = olehHarga;
        this.olehVarian = olehVarian;
        this.olehKeterangan = olehKeterangan;
    }

    public String getOlehId() {
        return olehId;
    }

    public void setOlehId(String olehId) {
        this.olehId = olehId;
    }

    public String getOlehNama() {
        return olehNama;
    }

    public void setOlehNama(String olehNama) {
        this.olehNama = olehNama;
    }

    public String getOlehHarga() {
        return olehHarga;
    }

    public void setOlehHarga(String olehHarga) {
        this.olehHarga = olehHarga;
    }

    public String getOlehVarian() {
        return olehVarian;
    }

    public void setOlehVarian(String olehVarian) {
        this.olehVarian = olehVarian;
    }

    public String getOlehKeterangan() {
        return olehKeterangan;
    }

    public void setOlehKeterangan(String olehKeterangan) {
        this.olehKeterangan = olehKeterangan;
    }
}
