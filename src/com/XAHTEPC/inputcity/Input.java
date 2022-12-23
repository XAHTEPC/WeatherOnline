package com.XAHTEPC.inputcity;

import com.XAHTEPC.parsercoordinates.ParserCoord;

import java.io.IOException;

public class Input {
    String query = "https://time-in.ru/coordinates";
    String town;
    String newURL;

    public Input(String town) {
        this.town = town;
    }

    public void getCoordinates() throws IOException {
        String php = "?search=";
        php = php + town;
        query = query + php;
        ParserCoord parse = new ParserCoord(query);
        String new_url = parse.getCoord();
        ModelCity model = new ModelCity(new_url);
        this.newURL = model.makeURL();

    }

    public String getNewURL() {
        return newURL;
    }
}
