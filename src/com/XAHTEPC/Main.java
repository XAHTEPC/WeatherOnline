package com.XAHTEPC;


import com.XAHTEPC.parseweather.Choise;
import com.XAHTEPC.parseweather.Model;
import com.XAHTEPC.parseweather.Parse;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Model> ans;
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите город, в котором хотите узнать погоду: ");
        String town = scan.nextLine();
        String url = "https://yandex.ru/pogoda/search?request=" + town;
        Parse parse = new Parse(url);
        if(parse.check()){
            parse.getInfo();
            ans = parse.getInform();
            for (int i = 0; i < ans.size(); i++) {
                System.out.println("Дата: " + ans.get(i).getDate() +
                        "\nТемпература днем: " + ans.get(i).getTemp_day() +
                        "\nТемпература ночью: " + ans.get(i).getTemp_night() +
                        "\nОсадки: " + ans.get(i).getInform() + "\n");
            }
            }
        else{
            System.out.println("Введите нужную цифру..");
            List<Choise> list = parse.gethoise();
            for(int i=0; i < list.size(); i++){
                System.out.println((i+1)+") " + list.get(i).getTownName());
                //System.out.println(i + ") " + list.get(i).getTownHref());
            }
            int num = scan.nextInt();
            //System.out.println("https://yandex.ru" + list.get(num).getTownHref());
            Parse parsenew = new Parse("https://yandex.ru" + list.get(num-1).getTownHref());
            parsenew.getInfo();
            ans = parsenew.getInform();
            for (int i = 0; i < ans.size(); i++) {
                System.out.println("Дата: " + ans.get(i).getDate() +
                        "\nТемпература днем: " + ans.get(i).getTemp_day() +
                        "\nТемпература ночью: " + ans.get(i).getTemp_night() +
                        "\nОсадки: " + ans.get(i).getInform() + "\n");
            }
        }
    }
}
