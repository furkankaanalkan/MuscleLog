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
import java.util.List;

public class MusclelogAdapter extends RecyclerView.Adapter<MusclelogAdapter.MusclelogHolder> {

    ArrayList<Exercises> selectedWorkout;


    public MusclelogAdapter(ArrayList<Exercises> selectedWorkout) {
        this.selectedWorkout = selectedWorkout;
    }



    @NonNull
    @Override
    public MusclelogHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MusclelogHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MusclelogAdapter.MusclelogHolder holder, int position) {

        String name = selectedWorkout.get(position).name;
        holder.binding.explainTitle.setText(name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPosition = holder.getAdapterPosition();

                if (adapterPosition != RecyclerView.NO_POSITION) {
                    Intent intent = new Intent(holder.itemView.getContext(), ExplainActivity.class);

                    Exercises onClickExercise = selectedWorkout.get(adapterPosition);

                    Singleton singleton = Singleton.getInstance();
                    singleton.setSelectedexercise(onClickExercise);

                    holder.itemView.getContext().startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        // Hata buradaydı: Listenin boş olma ihtimaline karşı koruma ekleyip asıl listenin boyutunu döndürüyoruz
        if (selectedWorkout == null) {
            return 0;
        }
        return selectedWorkout.size();
    }

    public class MusclelogHolder extends RecyclerView.ViewHolder {

        RecyclerRowBinding binding;

        public MusclelogHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}