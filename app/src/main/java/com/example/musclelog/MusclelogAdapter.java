package com.example.musclelog;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musclelog.databinding.ActivityExplainBinding;

import java.util.ArrayList;

public class MusclelogAdapter extends RecyclerView.Adapter<MusclelogAdapter.MusclelogHolder> {

    ArrayList<Exercises> exerciseList;

    public MusclelogAdapter(ArrayList<Exercises> exerciseList) {
        this.exerciseList = exerciseList;
    }

    @NonNull
    @Override
    public MusclelogHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ActivityExplainBinding  activityExplainBinding = ActivityExplainBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new MusclelogHolder(activityExplainBinding);
    }

    @Override
    public void onBindViewHolder(MusclelogAdapter.MusclelogHolder holder, int position) {
        holder.binding.explainTitle.setText(exerciseList.get(position).name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPosition = holder.getAdapterPosition();

                if (adapterPosition != RecyclerView.NO_POSITION) {
                    Intent intent = new Intent(holder.itemView.getContext(), ExplainActivity.class);
                    Singleton singleton = Singleton.getInstance();

                    singleton.setSingexer(exerciseList.get(adapterPosition));

                    holder.itemView.getContext().startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }

    public class MusclelogHolder extends RecyclerView.ViewHolder {

        private ActivityExplainBinding binding;

        public MusclelogHolder(ActivityExplainBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}