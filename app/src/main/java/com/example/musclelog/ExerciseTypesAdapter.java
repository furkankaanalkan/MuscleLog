package com.example.musclelog;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;


import com.example.musclelog.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class ExerciseTypesAdapter extends RecyclerView.Adapter<ExerciseTypesAdapter.ExerciseTypesHolder> {

    ArrayList<ArrayList<Exercises>> typeList;
    ArrayList<String> typeStringName;


    public ExerciseTypesAdapter (ArrayList<ArrayList<Exercises>> typeList , ArrayList<String> typeStringName) {
        this.typeList = typeList;
        this.typeStringName = typeStringName;
    }


    @NonNull
    @Override
    public ExerciseTypesAdapter.ExerciseTypesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ExerciseTypesAdapter.ExerciseTypesHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(ExerciseTypesAdapter.ExerciseTypesHolder holder, int position) {

        String name = typeStringName.get(position);
        holder.binding.layoutRow.setText(name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPosition = holder.getAdapterPosition();

                if (adapterPosition != RecyclerView.NO_POSITION) {
                    Intent intent = new Intent(holder.itemView.getContext(), ExerciseActivity.class);
                    ArrayList<Exercises> onClickExercise = typeList.get(adapterPosition);

                    Singleton singleton = Singleton.getInstance();
                    singleton.setExerciseList(onClickExercise);

                    holder.itemView.getContext().startActivity(intent);
                }

            }
        });

        Context context = holder.itemView.getContext();

        if (name.equalsIgnoreCase("Pull Day") || name.equalsIgnoreCase("Push Day") || name.equalsIgnoreCase("Leg Day")){
            holder.binding.getRoot().setCardBackgroundColor(ContextCompat.getColor(context, R.color.pastel_lilac));
        }
        else if (name.equalsIgnoreCase("Upper Body Day") || name.equalsIgnoreCase("Lower Body Day")) {
            holder.binding.getRoot().setCardBackgroundColor(ContextCompat.getColor(context, R.color.pastel_mint));
        }
        else if (name.equalsIgnoreCase("Full Body Day")) {
            holder.binding.getRoot().setCardBackgroundColor(ContextCompat.getColor(context, R.color.pastel_peach));
        }
        else if (name.equalsIgnoreCase("Arm Day") || name.equalsIgnoreCase("Arnold Chest Back Day") || name.equalsIgnoreCase("Arnold Shoulders Arms Day")) {
            holder.binding.getRoot().setCardBackgroundColor(ContextCompat.getColor(context, R.color.pastel_blue));
        }
        else {

            holder.binding.getRoot().setCardBackgroundColor(ContextCompat.getColor(context, R.color.white));
        }

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
