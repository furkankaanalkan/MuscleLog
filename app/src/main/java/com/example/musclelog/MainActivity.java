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

        ViewCompat.setOnApplyWindowInsetsListener(binding.recTextView, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Exercises deadlift = new Exercises("Deadlift", "Back", R.drawable.deadlift);
        Exercises dumbbell_curl = new Exercises("Dumbbell Curl", "Biceps", R.drawable.dumbbellcurl);
        Exercises chest_supported_dumbbell_row = new Exercises("Chest Supported Dumbbell Row", "Back", R.drawable.chestsupporteddumbbellrow);
        Exercises hummer_Curl = new Exercises("Hummer Curl", "Biceps", R.drawable.hummercurl);
        Exercises lat_pull_down = new Exercises("Lat Pull Down", "Back", R.drawable.latpulldown);
        Exercises face_pull = new Exercises("Face Pull", "Back", R.drawable.facepull);

        ArrayList<Exercises> pull_day = new ArrayList<>();
        pull_day.addAll(List.of(deadlift,dumbbell_curl,chest_supported_dumbbell_row,hummer_Curl,
                lat_pull_down,face_pull));

        HashMap<String, ArrayList<Exercises>> types = new HashMap<>();
        types.put("Pull Day",pull_day);

        Singleton singleton = Singleton.getInstance();
        singleton.setAllLists(types);

    }

    public void button1(View view){
        Intent intent = new Intent(MainActivity.this, ExerciseActivity.class);
        intent.putExtra("selectedWorkout", "Pull Day");
        startActivity(intent);

    }

}