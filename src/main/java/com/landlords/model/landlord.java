package com.landlords.model;

public class Landlord {

    private String  firstName;
    private String  lastName;
    private Boolean trusted;

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
        this.firstName = firstName;
    }

    public  String getLastName(){
        return lastName;
    }

    public void setLastName(){
        this.lastName = lastName;
    }

    public Boolean getTrusted(){
        return trusted;
    }

    public void  setTrusted(Boolean trusted){
        this.trusted = trusted;
    }


}
