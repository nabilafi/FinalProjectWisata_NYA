package com.wisata_nya.mei.wisata_nyamalangraya.Model;

/**
 * Created by mei on 1/17/2018.
 */

public class Kontak {

    String kontakId;
    String kontakKet;
    String kontakSosmed;

    public Kontak()
    {

    }

    public String getKontakId() {
        return kontakId;
    }

    public String getKontakKet() {
        return kontakKet;
    }

    public String getKontakSosmed() {
        return kontakSosmed;
    }

    public Kontak(String kontakId, String kontakKet, String kontakSosmed) {
        this.kontakId = kontakId;
        this.kontakKet = kontakKet;
        this.kontakSosmed = kontakSosmed;
    }
}
