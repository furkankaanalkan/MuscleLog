package com.example.musclelog;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.axemple.musclelog.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class MusclelogAdapter extends RecyclerView.Adapter<MusclelogAdapter.MusclelogHolder> {

    ArrayList<Exercises> exerciseList;

    public MusclelogAdapter(ArrayList<Exercises> exerciseList) {
        this.exerciseList = exerciseList;
    }

    @NonNull
    @Override
    public MusclelogHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new MusclelogHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(MusclelogAdapter.MusclelogHolder holder, int position) {
        holder.binding.recyclerViewTextView.setText(exerciseList.get(position).name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(),DetailActivity.class);
                Singleton singleton = Singleton.getInstance();
                singleton.setChosenLandmark(exerciseList.get(position));
                //intent.putExtra("landmark",landmarkList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }

    public class MusclelogHolder extends RecyclerView.ViewHolder {

        private RecyclerRowBinding binding;

        public MusclelogHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}