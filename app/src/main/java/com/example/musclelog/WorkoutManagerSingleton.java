package com.example.musclelog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class WorkoutManagerSingleton {
    private static WorkoutManagerSingleton instance;
    private ArrayList<String> typesKeys = new ArrayList<>();
    private ArrayList<ArrayList<Exercises>> typesValues = new ArrayList<>();

    private WorkoutManagerSingleton() {
        Exercises deadlift = new Exercises("Deadlift",R.string.deadlift, R.drawable.deadlift);
        Exercises dumbbell_curl = new Exercises("Dumbbell Curl", R.string.dumbbell_curl, R.drawable.dumbbellcurl);
        Exercises chest_supported_dumbbell_row = new Exercises("Chest Supported Dumbbell Row",R.string.chest_supported_dumbbell_row, R.drawable.chestsupporteddumbbellrow);
        Exercises hummer_Curl = new Exercises("Hammer Curl", R.string.hummer_Curl, R.drawable.hummercurl);
        Exercises lat_pull_down = new Exercises("Lat Pull Down",R.string.lat_pull_down, R.drawable.latpulldown);
        Exercises face_pull = new Exercises("Face Pull",R.string.face_pull, R.drawable.facepull);

        ArrayList<Exercises> pull_day = new ArrayList<>();
        pull_day.addAll(Arrays.asList(deadlift,dumbbell_curl,chest_supported_dumbbell_row,hummer_Curl, lat_pull_down,face_pull));

        Exercises benchPress = new Exercises("Bench Press",R.string.benchPress, R.drawable.benchpress);
        Exercises inclineDumbbellPress = new Exercises("Incline Dumbbell Press",R.string.inclineDumbbellPress, R.drawable.inclinedumbbellpress);
        Exercises machineChestPress = new Exercises("Machine Chest Press",R.string.machineChestPress, R.drawable.machinechestpress);
        Exercises overHeadPress = new Exercises("Overhead Press",R.string.overHeadPress, R.drawable.overheadpress);
        Exercises lateralRaise = new Exercises("Lateral Raise",R.string.lateralRaise, R.drawable.lateralraise);
        Exercises tricepsPushDown = new Exercises("Triceps Pushdown",R.string.tricepsPushDown, R.drawable.tricepspushdown);
        Exercises dumbbellSkullCrusher = new Exercises("Dumbbell Skull Crusher",R.string.dumbbellSkullCrusher, R.drawable.dumbbellskullcrusher);

        ArrayList<Exercises> push_day = new ArrayList<>();
        push_day.addAll(Arrays.asList(benchPress,inclineDumbbellPress,machineChestPress,overHeadPress,lateralRaise,tricepsPushDown,dumbbellSkullCrusher));

        LinkedHashMap<String, ArrayList<Exercises>> types = new LinkedHashMap<>();
        types.put("Pull Day",pull_day);
        types.put("Push Day",push_day);


        for (String key : types.keySet()){
            typesKeys.add(key);
        }

        for (ArrayList<Exercises> value : types.values()){
            typesValues.add(value);
        }
    }

    public static WorkoutManagerSingleton getInstance() {
        if (instance == null) {
            instance = new WorkoutManagerSingleton();
        }
        return instance;
    }

    public ArrayList<String> getTypesKeys() {
        return typesKeys;
    }

    public ArrayList<ArrayList<Exercises>> getTypesValues() {
        return typesValues;
    }
}
