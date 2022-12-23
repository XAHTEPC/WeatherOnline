package com.XAHTEPC.inputcity;

public class ModelCity {
    String task;

    public ModelCity(String task) {
        this.task = task;
    }

    public String makeURL(){
        String x="";
        String y="";
        int k=0;
        char[] coordinates = task.toCharArray();
        for(int i=0;i<task.length();i++){
            if(i>16&&coordinates[i]!=','&&coordinates[i]!=' '&&k<3)
                x+=coordinates[i];
            if(coordinates[i]==' ')
                k++;
            if(k==3&&coordinates[i]!=' ')
                y+=coordinates[i];
        }
        //System.out.println("x: " + x +"\ny: " + y);
        String newURL = "?lat=" + x + "&lon=" + y;
        return newURL;
    }
}
