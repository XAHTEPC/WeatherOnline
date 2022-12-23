package com.XAHTEPC;

import com.XAHTEPC.inputcity.Input;
import com.XAHTEPC.parseweather.Model;
import com.XAHTEPC.parseweather.Parse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Model> ans;
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите город, в котором хотите узнать погоду: ");
        String town = scan.next();
        System.out.println("Город: " + town);
        Input input = new Input(town);
        input.getCoordinates();
        String url = input.getNewURL();
        //System.out.println("url: " + url);
        Parse.getInfo(url);
        ans = Parse.getInform();
        for(int i=0; i<ans.size();i++){
            System.out.println("Дата: " + ans.get(i).getDate() +
                    "\nТемпература днем: " + ans.get(i).getTemp_day() +
                    "\nТемпература ночью: " + ans.get(i).getTemp_night() +
                    "\nОсадки: " + ans.get(i).getInform() + "\n");
        }

    }
}
