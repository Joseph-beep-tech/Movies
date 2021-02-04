package com.demotxt.myapp.myapplication.activities;


import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.demotxt.myapp.myapplication.R ;


public class MovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        // hiding the default actionbar
        getSupportActionBar().hide();

        // Recieving data

        String name  = getIntent().getExtras().getString("book_name");
        String description = getIntent().getExtras().getString("book_description");
        String studio = getIntent().getExtras().getString("book_studio") ;
        String category = getIntent().getExtras().getString("book_category");
        int nb_episode = getIntent().getExtras().getInt("book_nb_episode") ;
        String rating = getIntent().getExtras().getString("book_rating") ;
        String image_url = getIntent().getExtras().getString("book_img") ;

        // ini views

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_name = findViewById(R.id.aa_book_name);
        TextView tv_studio = findViewById(R.id.aa_studio);
        TextView tv_categorie = findViewById(R.id.aa_categorie) ;
        TextView tv_description = findViewById(R.id.aa_description);
        TextView tv_rating  = findViewById(R.id.aa_rating) ;
        ImageView img = findViewById(R.id.aa_thumbnail);

        // setting values to each view

        tv_name.setText(name);
        tv_categorie.setText(category);
        tv_description.setText(description);
        tv_rating.setText(rating);
        tv_studio.setText(studio);

        collapsingToolbarLayout.setTitle(name);


        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);


        // setting image using Glide
        Glide.with(this).load(image_url).apply(requestOptions).into(img);





    }
}
