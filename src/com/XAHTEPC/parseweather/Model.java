package com.XAHTEPC.parseweather;

public class Model {
    private String date;
    private String temp_day;
    private String temp_night;
    private String inform;

    public Model(String date, String temp_day, String temp_night, String inform){
        this.date = date;
        this.temp_day = temp_day;
        this.temp_night = temp_night;
        this.inform = inform;
    }

    public String getDate() {
        return date;
    }

    public String getTemp_day() {
        return temp_day;
    }

    public String getTemp_night() {
        return temp_night;
    }

    public String getInform() {
        return inform;
    }


}
