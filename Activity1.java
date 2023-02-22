package com.example.tall_as_giraffe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

public class Activity1 extends AppCompatActivity {

    ImageView exercises_images;
    TextView exercises_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        exercises_images = findViewById(R.id.image);
        exercises_text = findViewById(R.id.exercisesName);

        Intent intent = getIntent();
        if(intent.getExtras() != null){
            String clickExercises = intent.getStringExtra("description");
            int clickImages = intent.getIntExtra("image",0);

            exercises_text.setText(clickExercises);
            exercises_images.setImageResource(clickImages);
        }

    }
}