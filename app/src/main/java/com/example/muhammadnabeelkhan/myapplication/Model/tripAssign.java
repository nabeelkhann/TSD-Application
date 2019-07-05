package com.example.muhammadnabeelkhan.myapplication;

public class tripAssign {

    public String driverid;
    public String tripID;


    public void tripAssign(){

    }

    public void Drivers(String driverid , String tripID){

        this.driverid = driverid;
        this.tripID = tripID;

    }

    public String did(){
        return this.driverid;
    }

    public String tid(){
        return this.tripID;
    }
}
