package com.sketch.Drawing.Utility;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import java.io.FileReader;
import java.io.IOException;


public class GrammarSettingsLoader {

    public static <T> T parseJsonFromFile(String filePath, Class<T> classOfT) {
        Gson gson = new Gson();
        T data = null;

        try (FileReader reader = new FileReader(filePath)) {
            data = gson.fromJson(reader, classOfT);
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static GrammarSettings loadGrammarFromConfigFile() {
        GrammarSettings settings = parseJsonFromFile("./resources/grammarConfig.json", GrammarSettings.class);
        return settings;
    }
}
