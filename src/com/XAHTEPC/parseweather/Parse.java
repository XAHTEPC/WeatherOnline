package com.XAHTEPC.parseweather;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parse {
    static Document Doc;
    static List<Model> inform = new ArrayList<>();

    public static void getInfo(String url) throws IOException {
        Doc = Jsoup.connect("https://yandex.ru/pogoda" + url).get();
        //System.out.println(Doc);

        Elements date_element = Doc.getElementsByAttributeValue("class",
                "time forecast-briefly__date");
        Elements tempDay_element = Doc.getElementsByAttributeValue("class",
                "temp forecast-briefly__temp forecast-briefly__temp_day");
        Elements tempNight_element = Doc.getElementsByAttributeValue("class",
                "temp forecast-briefly__temp forecast-briefly__temp_night");
        Elements info_element = Doc.getElementsByAttributeValue("class",
                "forecast-briefly__condition");

        String[] Date = new String[31];
        String[] TempDay = new String[31];
        String[] TempNight = new String[31];
        String[] Info = new String[31];

        int i=0;
        for(Element el:date_element){
            Date[i]= el.text();
            i++;
        }
        i=0;
        for(Element el:tempDay_element){
            TempDay[i]= el.text();
            i++;
        }
        i=0;
        for(Element el:tempNight_element){
            TempNight[i]= el.text();
            i++;
        }
        i=0;
        for(Element el:info_element){
            Info[i]= el.text();
            i++;
        }


        for(int k=1;k<31;k++) {
            Model model;
            if(k==1){
                String day="";
                char[] day_mas = TempDay[k].toCharArray();
                for(int j=0;j<TempDay[k].length();j++){
                    if(day_mas[j]>='0'&&day_mas[j]<='9'||(day_mas[j]=='-'||day_mas[j]=='+'))
                        day+=day_mas[j];
                }
                String night="";
                char[] night_mas = TempNight[k].toCharArray();
                for(int j=0;j<TempNight[k].length();j++){
                    if(night_mas[j]>='0'&&night_mas[j]<='9'||(night_mas[j]=='-'||night_mas[j]=='+'))
                        night+=night_mas[j];
                }
                 model = new Model(Date[k], day, night, Info[k]);
            }
            else
                model = new Model(Date[k], TempDay[k], TempNight[k], Info[k]);
            inform.add(model);
        }
    }

    public static List<Model> getInform() {
        return inform;
    }
    public void clean(){

    }
}
