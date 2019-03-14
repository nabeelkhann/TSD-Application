package com.example.muhammadnabeelkhan.myapplication;

public class Drivers {

    public String Id;
    public String password;
    public String Name;
    public String CNIC;
    public String city;
    public String gender;
    public String phone;


    public void Drivers(){

    }

    public void Drivers(String Id , String password , String Name, String CNIC , String city , String gender , String phone){

        this.Id = Id;
        this.password = password;
        this.Name=Name;
        this.CNIC=CNIC;
        this.city=city;
        this.gender=gender;
        this.phone=phone;

    }

    public String id(){
        return this.Id;
    }

    public String getPass(){
        return this.password;
    }
}
