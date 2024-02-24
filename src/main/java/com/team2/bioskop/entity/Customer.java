package com.team2.bioskop.entity;

public class Customer {

    String newNameOrBirth,NameOrBirth,oldNameOrBirth;
    String name;
    String birth_date;

    public Customer( String name, String birth_date) {
        this.name = name;
        this.birth_date = birth_date;
    }

    public Customer( String NameOrBirth, String newNameOrBirth, String oldNameOrBirth){
        this.NameOrBirth = NameOrBirth;
        this.newNameOrBirth = newNameOrBirth;
        this.oldNameOrBirth = oldNameOrBirth;
    }

    public String getNewNameOrBirth() {
        return newNameOrBirth;
    }

    public void setNewNameOrBirth(String newNameOrBirth) {
        this.newNameOrBirth = newNameOrBirth;
    }

    public String getNameOrBirth() {
        return NameOrBirth;
    }

    public void setNameOrBirth(String nameOrBirth) {
        NameOrBirth = nameOrBirth;
    }

    public String getOldNameOrBirth() {
        return oldNameOrBirth;
    }

    public void setOldNameOrBirth(String oldNameOrBirth) {
        this.oldNameOrBirth = oldNameOrBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }
}
