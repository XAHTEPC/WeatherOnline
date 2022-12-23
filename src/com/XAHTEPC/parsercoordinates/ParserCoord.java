package com.XAHTEPC.parsercoordinates;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ParserCoord {
    static Document Doc;
    String url;
    String ans="";
    public ParserCoord(String url) {
        this.url = url;
    }
    public String getCoord() throws IOException {
        Doc = Jsoup.connect(url).get();
        Elements elements = Doc.getElementsByAttributeValue("class","coordinates-city-info");
        for(Element el: elements){
            //System.out.println(el.text()+"---------------");
            ans = el.text();
        }
        return ans;
    }
}
