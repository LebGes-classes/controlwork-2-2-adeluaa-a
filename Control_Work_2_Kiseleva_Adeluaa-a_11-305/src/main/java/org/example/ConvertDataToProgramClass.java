package org.example;

import java.util.ArrayList;

public class ConvertDataToProgramClass {
    static String canal = "";
    static BroadcastsTime time = null;

    public static ArrayList<Program> convertAllPrograms(ArrayList<String> data) {
        ArrayList<Program> allPrograms = new ArrayList<>();
        for (String program : data) {
            if (program.contains("#")){
                canal = program.split("#")[1];
            }
            else if (program.contains(":") && (program.length() == 5)){
                time = new BroadcastsTime(Byte.parseByte(program.split(":")[0]), Byte.parseByte(program.split(":")[1]));
            }
            else {
                Program p = new Program(canal, time, program);
                allPrograms.add(p);
            }
        }
        return allPrograms;
    }
}
