package com.example.flixster;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.flixster.adapters.MovieAdapter;
import com.example.flixster.models.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;

public class HomepageFragment extends Fragment {

    public static final String NOW_PLAYING_URL = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
    public static final String TAG = "MainActivity";

    List<Movie> movies;
    RecyclerView recyclerView;
    Context myContext;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        myContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View homepageView = inflater.inflate(R.layout.fragment_homepage_layout, container, false);

        // 1. Get reference to recycler view
        recyclerView = homepageView.findViewById(R.id.rv_homepage);

        // 2. Set Layout Manager
        recyclerView.setLayoutManager(new LinearLayoutManager(homepageView.getContext()));

        // 3. Data for recycler view
        movies = new ArrayList<>();

        // 4. Create an adapter
        final MovieAdapter movieAdapter = new MovieAdapter(myContext, movies);

        // 5. Set adapter
        recyclerView.setAdapter(movieAdapter);

        // Preparing async http client
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(NOW_PLAYING_URL, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                Log.d(TAG, "onSuccess");
                JSONObject jsonObject = json.jsonObject;
                try {
                    JSONArray results = jsonObject.getJSONArray("results");
                    movies.addAll(Movie.fromJsonArray(results));
                    movieAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    Log.d(TAG, "Hit json exception when fetching results", e);
                }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                Log.d(TAG, "onFailure");
            }
        });
        return homepageView;
    }
}
