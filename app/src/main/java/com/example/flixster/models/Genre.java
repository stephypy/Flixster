package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Genre {
    private String genreId;
    private String genreName;

    public Genre() {}

    public Genre(JSONObject jsonObject) throws JSONException {
        this.genreId = jsonObject.getString("id");
        this.genreName = jsonObject.getString("name");
    }

    public static List<Genre> fromJsonArray(JSONArray genreJsonArray) throws JSONException {
        List<Genre> genres = new ArrayList<>();
        for(int i = 0; i < genreJsonArray.length(); i++) {
            genres.add(new Genre(genreJsonArray.getJSONObject(i)));
        }
        return genres;
    }

    public String getGenreId() {
        return genreId;
    }

    public String getGenreName() {
        return genreName;
    }
}
