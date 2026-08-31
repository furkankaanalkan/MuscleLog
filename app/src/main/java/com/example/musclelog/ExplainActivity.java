package com.example.musclelog;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.musclelog.databinding.ActivityExplainBinding;

public class ExplainActivity extends AppCompatActivity {

    private ActivityExplainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityExplainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ViewCompat.setOnApplyWindowInsetsListener(binding.recTextView, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Exercises exerciseType = Singleton.getInstance().getSelectedexercise();

        binding.explainTitle.setText(exerciseType.name);
        binding.explainText.setText(exerciseType.description);
        binding.explainImage.setImageResource(exerciseType.images);
    }
}