package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {

    private int movieId;
    private String backdropPath;
    private String posterPath;
    private String title;
    private String overview;
    private double rating;

    public Movie() {}

    public Movie(JSONObject jsonObject) throws JSONException {
        this.movieId = jsonObject.getInt("id");
        this.backdropPath = jsonObject.getString("backdrop_path");
        this.posterPath = jsonObject.getString("poster_path");
        this.title = jsonObject.getString("title");
        this.overview = jsonObject.getString("overview");
        this.rating = jsonObject.getDouble("vote_average");
    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for(int i = 0; i < movieJsonArray.length(); i++) {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", this.backdropPath);
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", this.posterPath);
    }

    public String getTitle() {
        return this.title;
    }

    public String getOverview() {
        return this.overview;
    }

    public double getRating() {
        return rating;
    }
}
