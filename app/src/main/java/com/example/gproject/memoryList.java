package com.example.gproject;

public class memoryList {

    private String date;
    private String memory;

    public memoryList(){}

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date=date;
    }

    public String getMemory(){
        return memory;
    }

    public void setMemory(String memory){
        this.memory=memory;
    }

    public memoryList(String date, String memory){
        this.date=date;
        this.memory=memory;
    }
}
