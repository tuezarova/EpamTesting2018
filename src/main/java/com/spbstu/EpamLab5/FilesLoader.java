package com.spbstu.EpamLab5;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.spbstu.EpamLab5.data.MetalsAndColorsDataSet;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

public class FilesLoader {
    /************************FOR LOAD A FILE**************************/
    private static Map<String, MetalsAndColorsDataSet> DATA;
    static {
        try {
            load();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void load() throws FileNotFoundException {
        FileReader fileReader = new FileReader(FilesLoader.class.getClassLoader().getResource("metalsAndColorsDataSet.json").getFile());
        JsonReader jsonReader = new JsonReader(fileReader);

        Type type = new TypeToken<Map<String, MetalsAndColorsDataSet>>() {
        }.getType();

        DATA = new Gson().fromJson(jsonReader, type);

    }

    public static MetalsAndColorsDataSet getData(String subData) {
        return DATA.get(subData);
    }

    public static Object[] getAllData() {
            //System.out.println(DATA.values());
        return DATA.values().toArray();
    }
/*********************************************************************/
}
