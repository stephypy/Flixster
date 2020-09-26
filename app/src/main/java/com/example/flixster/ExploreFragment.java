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
import com.example.flixster.adapters.GenreAdapter;
import com.example.flixster.models.Genre;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;

public class ExploreFragment extends Fragment {

    public static final String ALL_GENRES_URL = "https://api.themoviedb.org/3/genre/movie/list?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed&language=en-US";
    public static final String TAG = "ExploreFragment";

    List<Genre> genres;
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
        View exploreView = inflater.inflate(R.layout.fragment_explore_layout, container, false);

        // 1. Get reference to recycler view
        recyclerView = exploreView.findViewById(R.id.rv_explore);

        // 2. Set Layout Manager
        recyclerView.setLayoutManager(new LinearLayoutManager(exploreView.getContext()));

        // 3. Data for recycler view
        genres = new ArrayList<>();

        // 4. Create an adapter
        final GenreAdapter genreAdapter = new GenreAdapter(myContext, genres);

        // 5. Set adapter
        recyclerView.setAdapter(genreAdapter);

        // Preparing async http client
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(ALL_GENRES_URL, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                Log.d(TAG, "onSuccess");
                JSONObject jsonObject = json.jsonObject;
                try {
                    JSONArray results = jsonObject.getJSONArray("genres");
                    genres.addAll(Genre.fromJsonArray(results));
                    genreAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    Log.d(TAG, "Hit json exception when fetching genres", e);
                }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                Log.d(TAG, "onFailure");
            }
        });

        return exploreView;
    }
}
