package com.example.musclelog;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.musclelog.databinding.ActivityExerciseBinding;
import com.example.musclelog.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class ExerciseActivity extends AppCompatActivity {

    private ActivityExerciseBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityExerciseBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ViewCompat.setOnApplyWindowInsetsListener(binding.recyclerViewExercises, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Exercises deadlift = new Exercises("Deadlift", "Back", R.drawable.deadlift);
        Exercises dumbell_curl = new Exercises("Dumbbell Curl", "Biceps", R.drawable.dumbbellcurl);
        Exercises chest_supported_dumbell_row = new Exercises("Chest Supported Dumbbell Row", "Back", R.drawable.chestsupporteddumbbellrow);
        Exercises Hummer_Curl = new Exercises("Hummer Curl", "Biceps", R.drawable.hummercurl);
        Exercises lat_pull_down = new Exercises("Lat Pull Down", "Back", R.drawable.latpulldown);
        Exercises face_pull = new Exercises("Face Pull", "Back", R.drawable.facepull);

        ArrayList<Exercises> pull_day = new ArrayList<>();
        pull_day.add(deadlift);
        pull_day.add(dumbell_curl);
        pull_day.add(chest_supported_dumbell_row);
        pull_day.add(Hummer_Curl);
        pull_day.add(lat_pull_down);
        pull_day.add(face_pull);

        binding.recyclerViewExercises.setLayoutManager(new GridLayoutManager(this, 2));
        MusclelogAdapter musclelogAdapter = new MusclelogAdapter(pull_day);
        binding.recyclerViewExercises.setAdapter(musclelogAdapter);


    }
}