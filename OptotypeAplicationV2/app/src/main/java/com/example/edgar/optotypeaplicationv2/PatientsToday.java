package com.example.edgar.optotypeaplicationv2;

/**
 * Created by Edgar on 10/09/2017.
 */

public class PatientsToday {

    private String name;
    private String yearsOld;
    private int photo;

    public PatientsToday() {
        super();
    }

    public PatientsToday(String name, String yearsOld, int photo) {
        super();
        this.name = name;
        this.yearsOld = yearsOld;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(String yearsOld) {
        this.yearsOld = yearsOld;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
