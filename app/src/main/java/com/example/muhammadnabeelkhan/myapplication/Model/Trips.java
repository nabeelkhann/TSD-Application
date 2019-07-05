package com.example.muhammadnabeelkhan.myapplication;

public class Trips {

    public int tripID;
    public String source;
    public String destination;
    public String depTime;
    public String depDate;
    public String arrTime;
    public String arrDate;


    public void Trips(){

    }

    public void Trips(int tripID , String source , String destination, String depTime , String depDate , String arrTime , String arrDate){

        this.tripID = tripID;
        this.source = source;
        this.destination = destination;
        this.depTime = depTime;
        this.depDate = depDate;
        this.arrTime = arrTime;
        this.arrDate = arrDate;

    }

    public int tripID(){
        return this.tripID;
    }
    public String source(){
        return this.source;
    }
    public String destination(){
        return this.destination;
    }
    public String depTime(){
        return this.depTime;
    }
    public String depDate(){
        return this.depDate;
    }
    public String arrTime(){
        return this.arrTime;
    }
    public String arrDate(){
        return this.arrDate;
    }


}
