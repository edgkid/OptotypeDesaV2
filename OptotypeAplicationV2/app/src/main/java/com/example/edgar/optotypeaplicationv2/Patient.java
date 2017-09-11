package com.example.edgar.optotypeaplicationv2;

/**
 * Created by Edgar on 10/09/2017.
 */

public class Patient {

    private String idPatient;
    private String name;
    private String LastName;
    private String middleName;
    private String maidenName;
    private String yearsOld;
    private String photo;
    private String fkUser;

    public Patient (){

    }

    public Patient(String idPatient, String name, String lastName, String middleName, String maidenName, String yearsOld, String photo, String fkUser) {
        this.idPatient = idPatient;
        this.name = name;
        this.LastName = lastName;
        this.middleName = middleName;
        this.maidenName = maidenName;
        this.yearsOld = yearsOld;
        this.photo = photo;
        this.fkUser = fkUser;
    }

    public String getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(String idPatient) {
        this.idPatient = idPatient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMaidenName() {
        return maidenName;
    }

    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }

    public String getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(String yearsOld) {
        this.yearsOld = yearsOld;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getFkUser() {
        return fkUser;
    }

    public void setFkUser(String fkUser) {
        this.fkUser = fkUser;
    }

}
