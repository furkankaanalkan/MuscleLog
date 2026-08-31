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
        Exercises dumbbellcurl = new Exercises("Dumbbell Curl", R.string.dumbbell_curl, R.drawable.dumbbellcurl);
        Exercises chestsupporteddumbbellrow = new Exercises("Chest Supported Dumbbell Row",R.string.chest_supported_dumbbell_row, R.drawable.chestsupporteddumbbellrow);
        Exercises hummercurl = new Exercises("Hammer Curl", R.string.hummer_Curl, R.drawable.hummercurl);
        Exercises latpulldown = new Exercises("Lat Pull Down",R.string.lat_pull_down, R.drawable.latpulldown);
        Exercises facepull = new Exercises("Face Pull",R.string.face_pull, R.drawable.facepull);


        Exercises benchPress = new Exercises("Bench Press",R.string.benchPress, R.drawable.benchpress);
        Exercises inclineDumbbellPress = new Exercises("Incline Dumbbell Press",R.string.inclineDumbbellPress, R.drawable.inclinedumbbellpress);
        Exercises machineChestPress = new Exercises("Machine Chest Press",R.string.machineChestPress, R.drawable.machinechestpress);
        Exercises overHeadPress = new Exercises("Overhead Press",R.string.overHeadPress, R.drawable.overheadpress);
        Exercises lateralRaise = new Exercises("Lateral Raise",R.string.lateralRaise, R.drawable.lateralraise);
        Exercises tricepsPushDown = new Exercises("Triceps Pushdown",R.string.tricepsPushDown, R.drawable.tricepspushdown);
        Exercises dumbbellSkullCrusher = new Exercises("Dumbbell Skull Crusher",R.string.dumbbellSkullCrusher, R.drawable.dumbbellskullcrusher);


        Exercises squat = new Exercises("Squat",R.string.squat, R.drawable.squat);
        Exercises legPress = new Exercises("Leg Press",R.string.legPress, R.drawable.legpress);
        Exercises romanianDeadlift = new Exercises("Romanian Deadlift",R.string.romanianDeadlift, R.drawable.romaniandeadlift);
        Exercises legExtension = new Exercises("Leg Extension",R.string.legExtension, R.drawable.legextension);
        Exercises legCurl = new Exercises("Leg Curl",R.string.legCurl, R.drawable.legcurl);
        Exercises calfRaise = new Exercises("Calf Raise",R.string.calfRaise, R.drawable.calfraise);


        Exercises pullUp = new Exercises("Pull Up",R.string.pullUp, R.drawable.pullup);
        Exercises barbellRow = new Exercises("Barbell Row",R.string.barbellRow, R.drawable.barbellrow);


        Exercises crunch = new Exercises("Crunch",R.string.crunch, R.drawable.crunch);
        Exercises plank = new Exercises("Plank",R.string.plank, R.drawable.plank);


        Exercises barbellCurl = new Exercises("Barbell Curl",R.string.barbellCurl, R.drawable.barbellcurl);
        Exercises tricepsExtension = new Exercises("Overhead Triceps Extension",R.string.overHeadPress, R.drawable.tricepsextension);
        Exercises concentrationCurl = new Exercises("Concentration Curl",R.string.concentrationCurl, R.drawable.concentrationcurl);
        Exercises cableKickback = new Exercises("Cable Kickback",R.string.cableKickback, R.drawable.cablekickback);




        ArrayList<Exercises> pull_day = new ArrayList<>();
        pull_day.addAll(Arrays.asList(deadlift,dumbbellcurl,chestsupporteddumbbellrow,hummercurl,latpulldown,facepull));

        ArrayList<Exercises> push_day = new ArrayList<>();
        push_day.addAll(Arrays.asList(benchPress,inclineDumbbellPress,machineChestPress,overHeadPress,lateralRaise,tricepsPushDown,dumbbellSkullCrusher));

        ArrayList<Exercises> leg_day = new ArrayList<>();
        leg_day.addAll(Arrays.asList(squat, legPress, romanianDeadlift, legExtension, legCurl, calfRaise));

        ArrayList<Exercises> upper_body_day = new ArrayList<>();
        upper_body_day.addAll(Arrays.asList(benchPress, pullUp, overHeadPress, barbellRow, lateralRaise, dumbbellcurl, tricepsPushDown));

        ArrayList<Exercises> lower_day = new ArrayList<>();
        lower_day.addAll(Arrays.asList(squat, legPress, romanianDeadlift, legExtension, legCurl, calfRaise, crunch, plank));

        ArrayList<Exercises> full_body_day = new ArrayList<>();
        full_body_day.addAll(Arrays.asList(squat, benchPress, latpulldown, overHeadPress, deadlift));

        ArrayList<Exercises> arm_day = new ArrayList<>();
        arm_day.addAll(Arrays.asList(barbellCurl, dumbbellSkullCrusher, hummercurl, tricepsExtension, concentrationCurl, cableKickback));

        ArrayList<Exercises> arnold_chest_back = new ArrayList<>();
        arnold_chest_back.addAll(Arrays.asList(benchPress, latpulldown, inclineDumbbellPress, barbellRow, machineChestPress, chestsupporteddumbbellrow));

        ArrayList<Exercises> arnold_shoulders_arms = new ArrayList<>();
        arnold_shoulders_arms.addAll(Arrays.asList(overHeadPress, lateralRaise, facepull, barbellCurl, dumbbellSkullCrusher, hummercurl, tricepsPushDown));

        LinkedHashMap<String, ArrayList<Exercises>> types = new LinkedHashMap<>();
        types.put("Pull Day",pull_day);
        types.put("Push Day",push_day);
        types.put("Leg Day",leg_day);
        types.put("Upper Body Day",upper_body_day);
        types.put("Lower Body Day",lower_day);
        types.put("Full Body Day",full_body_day);
        types.put("Arm Day",arm_day);
        types.put("Arnold Chest Back Day",arnold_chest_back);
        types.put("Arnold Shoulders Arms Day",arnold_shoulders_arms);


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
