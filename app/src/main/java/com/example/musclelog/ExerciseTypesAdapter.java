package com.example.musclelog;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.musclelog.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class ExerciseTypesAdapter extends RecyclerView.Adapter<ExerciseTypesAdapter.ExerciseTypesHolder> {

    ArrayList<Exercises> typeList;

    public ExerciseTypesAdapter (ArrayList<Exercises> typeList) {
        this.typeList = typeList;

    }


    @NonNull
    @Override
    public ExerciseTypesAdapter.ExerciseTypesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ExerciseTypesAdapter.ExerciseTypesHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(ExerciseTypesAdapter.ExerciseTypesHolder holder, int position) {

        String name = typeList.get(position).name;
        holder.binding.explainTitle.setText(name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            //@Override

            public void onClick(View v) {
                int adapterPosition = holder.getAdapterPosition();

                if (adapterPosition != RecyclerView.NO_POSITION) {
                    Intent intent = new Intent(holder.itemView.getContext(), ExplainActivity.class);

                    Exercises onClickExercise = typeList.get(adapterPosition);

                    Singleton singleton = Singleton.getInstance();
                    singleton.setSelectedExercise(onClickExercise);


                    holder.itemView.getContext().startActivity(intent);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        if (typeList == null) {
            return 0;
        }
        return typeList.size();
    }


    public class ExerciseTypesHolder extends RecyclerView.ViewHolder {

        RecyclerRowBinding binding;

        public ExerciseTypesHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }


}
