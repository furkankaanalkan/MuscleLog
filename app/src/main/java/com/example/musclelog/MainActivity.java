package com.example.musclelog;

import com.example.musclelog.databinding.ActivityMainBinding;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import android.view.View;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends AppCompatActivity {
  
  private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ViewCompat.setOnApplyWindowInsetsListener(binding.recyclerViewMain, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayList<ArrayList<Exercises>> typesValues = WorkoutManagerSingleton.getInstance().getTypesValues();
        ArrayList<String> typesKeys = WorkoutManagerSingleton.getInstance().getTypesKeys();


        binding.recyclerViewMain.setLayoutManager(new LinearLayoutManager(this));
        ExerciseTypesAdapter exerciseTypesAdapter = new ExerciseTypesAdapter(typesValues , typesKeys);
        binding.recyclerViewMain.setAdapter(exerciseTypesAdapter);

    }
}