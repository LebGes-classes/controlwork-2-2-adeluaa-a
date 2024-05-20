package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Deserialization {
    public static ArrayList <String> deserialize (String nameOfFile) {
        ArrayList <String> programs = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(nameOfFile))) {
            String stroka;
            while ((stroka = buffer.readLine()) != null){
                programs.add(stroka);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return programs;
    }
}
