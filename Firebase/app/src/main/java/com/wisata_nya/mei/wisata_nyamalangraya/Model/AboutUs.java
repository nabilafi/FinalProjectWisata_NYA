package com.wisata_nya.mei.wisata_nyamalangraya.Model;

/**
 * Created by mei on 1/17/2018.
 */

public class AboutUs {

    String aboutUsId;
    String desc;
    String version;

    public AboutUs()
    {

    }

    public AboutUs(String aboutUsId, String desc, String version) {
        this.aboutUsId = aboutUsId;
        this.desc = desc;
        this.version = version;
    }

    public String getAboutUsId() {
        return aboutUsId;
    }

    public void setAboutUsId(String aboutUsId) {
        this.aboutUsId = aboutUsId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}

