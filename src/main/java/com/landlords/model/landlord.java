package com.landlords.model;

import io.codearte.jfairy.Fairy;

public class Landlord {

    private String  firstName;
    private String  lastName;
    private Boolean trusted;
    private String  status;

    public Landlord(){
    }

    public  Landlord(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName  = lastName;
    }

    public  Landlord(String firstName, String lastName, Boolean trusted){
        this.firstName = firstName;
        this.lastName  = lastName;
        this.trusted   = trusted;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(){
        Fairy fairy = Fairy.create();
        this.firstName = fairy.person().firstName();
    }

    public  String getLastName(){
        return lastName;
    }

    public void setLastName(){
        Fairy fairy = Fairy.create();
        this.lastName = fairy.person().firstName();

    }

    public Boolean getTrusted() {
        return trusted;
    }

    public void  setTrusted(Boolean trusted) {
        this.trusted = trusted;
    }

    public String getStatus(){
        return status;
    }


}
