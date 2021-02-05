package com.demotxt.myapp.myapplication.activities;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.demotxt.myapp.myapplication.R;
import com.demotxt.myapp.myapplication.adapters.RecyclerViewAdapter;
import com.demotxt.myapp.myapplication.model.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class about extends AppCompatActivity {

    private final String JSON_URL = "https://gist.githubusercontent.com/Joseph-beep-tech/38014563cab12e177009a3ff4a53703c/raw/4683fe4e25ef98b5a8278f8ff13a3d0c8759dbaa/Library.json" ;

    private JsonArrayRequest request ;
    private RequestQueue requestQueue ;
    private List<Movie> lstMovie;
    private RecyclerView recyclerView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        lstMovie = new ArrayList<>() ;
        recyclerView = findViewById(R.id.recyclerviewid);
        jsonrequest();



    }

    private void jsonrequest() {

        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject  = null ;

                for (int i = 0 ; i < response.length(); i++ ) {


                    try {
                        jsonObject = response.getJSONObject(i) ;
                        Movie movie = new Movie() ;
                        movie.setName(jsonObject.getString("name"));
                        movie.setDescription(jsonObject.getString("description"));
                        movie.setRating(jsonObject.getString("Rating"));
                        movie.setCategorie(jsonObject.getString("categorie"));
                        movie.setNb_episode(jsonObject.getInt("episode"));
                        movie.setStudio(jsonObject.getString("studio"));
                        movie.setImage_url(jsonObject.getString("img"));
                        lstMovie.add(movie);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                setuprecyclerview(lstMovie);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        requestQueue = Volley.newRequestQueue(about.this);
        requestQueue.add(request) ;


    }

    private void setuprecyclerview(List<Movie> lstMovie) {


        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this, lstMovie) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);

    }


}
