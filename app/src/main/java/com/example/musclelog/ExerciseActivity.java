package com.example.musclelog;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.musclelog.databinding.ActivityExerciseBinding;

import java.util.ArrayList;
import java.util.HashMap;

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



        Singleton singleton = Singleton.getInstance();
        ArrayList<Exercises> selectedworkout = singleton.getExerciseList();


        binding.recyclerViewExercises.setLayoutManager(new GridLayoutManager(this,2));
        MusclelogAdapter musclelogAdapter = new MusclelogAdapter(selectedworkout);
        binding.recyclerViewExercises.setAdapter(musclelogAdapter);


    }
}