package com.example.hackathonapp;

public class GameData {
    public int id;
    public String riddle;
    public int imgSrc;
    public String code;

    public GameData(){

    }

    public GameData(int id, String riddle, int imgSrc, String code){
        this.id = id;
        this.riddle = riddle;
        this.imgSrc = imgSrc;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public String getRiddle() {
        return riddle;
    }

    public int getImgSrc() {
        return imgSrc;
    }

    public String getCode() {
        return code;
    }
}
