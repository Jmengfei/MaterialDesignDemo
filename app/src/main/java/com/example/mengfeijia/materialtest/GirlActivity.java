package com.example.mengfeijia.materialtest;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class GirlActivity extends AppCompatActivity {

    public static final String GIRL_NAME = "girl_name";
    public static final String GIRL_IMAGE_ID = "girl_iamge_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girl);

        Intent intent = getIntent();
        String girlName = intent.getStringExtra(GIRL_NAME);
        int girlImageId = intent.getIntExtra(GIRL_IMAGE_ID, 0);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        ImageView girlImageView = (ImageView) findViewById(R.id.girl_image_view);
        TextView girlContentText = (TextView) findViewById(R.id.girl_content_text);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(girlName);
        Glide.with(this).load(girlImageId).into(girlImageView);
        String girlContent = generaGirlContent(girlName);
        girlContentText.setText(girlContent);
    }

    private String generaGirlContent(String girlName) {
        StringBuilder girlContent = new StringBuilder();
        for (int i = 0 ;i < 500 ; i++){
            girlContent.append(girlName);
        }
        return girlContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
