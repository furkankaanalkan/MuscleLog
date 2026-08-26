package com.example.musclelog;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musclelog.databinding.RecyclerRowBinding;

import java.util.ArrayList;
import java.util.HashMap;

public class MusclelogAdapter extends RecyclerView.Adapter<MusclelogAdapter.MusclelogHolder> {

    ArrayList<Exercises> exerciseList;

    ArrayList<String> typeTitles;

    public MusclelogAdapter(ArrayList<Exercises> exerciseList) {
        this.exerciseList = exerciseList;
    }

    @NonNull
    @Override
    public MusclelogHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerRowBinding  recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new MusclelogHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(MusclelogAdapter.MusclelogHolder holder, int position) {
        String name = exerciseList.get(position).name;
        holder.binding.explainTitle.setText(name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPosition = holder.getAdapterPosition();

                if (adapterPosition != RecyclerView.NO_POSITION) {
                    Intent intent = new Intent(holder.itemView.getContext(), ExplainActivity.class);

                    Exercises onClickExercise = exerciseList.get(adapterPosition);

                    Singleton singleton = Singleton.getInstance();
                    singleton.setSelectedExercise(onClickExercise);
                    intent.putExtra("selectedWorkout",onClickExercise);

                    holder.itemView.getContext().startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return typeTitles.size();
    }

    public class MusclelogHolder extends RecyclerView.ViewHolder {

        RecyclerRowBinding binding;

        public MusclelogHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}