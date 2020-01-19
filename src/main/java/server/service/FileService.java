package server.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileService {

    public void savedDataToFile(File file, Map<String,List<String>> result) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            JsonArray ja = new JsonArray();
            ja.add(result.toString());
            bw.write(ja.toString());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void recoveryDataFromFile(File file, Gson gson) {
        List<String> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            JsonReader reader = gson.newJsonReader(br);
            reader.beginArray();
            while (reader.hasNext()) {
                String str = gson.fromJson(reader, String.class);
                data.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
