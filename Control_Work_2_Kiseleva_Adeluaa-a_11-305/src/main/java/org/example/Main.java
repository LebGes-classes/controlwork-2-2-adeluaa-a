package org.example;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> programs = Deserialization.deserialize("C:\\Users\\user\\Desktop\\data.txt");
        ArrayList<Program> allPrograms = ConvertDataToProgramClass.convertAllPrograms(programs);

        ArrayList<Program> sortedOfTimePrograms = Program.sortTime(allPrograms);
        System.out.println(sortedOfTimePrograms);
//        ArrayList<Program> getProgramsThatInCurrentTime = Program.currentPrograms(allPrograms, "05:20");
//    //    System.out.println(getProgramsThatInCurrentTime);
//        ArrayList<Program> getProgramsWithName = Program.getProgramsWithName(allPrograms, "Смешарики");
//    //    System.out.println(getProgramsWithName);
//    //    ArrayList<Program> getProgramsWithCurrTimeAndChanelName = Program.getCanalNameCurrentTime (allPrograms, "Первый", "05:20");
//    //    System.out.println(getProgramsWithCurrTimeAndChanelName);
//        ArrayList<Program> getProgramWithTimeBetweenAndChanel = Program.programBetween(allPrograms, "00:00", "03:00", "НТВ");
//    //    System.out.println(getProgramWithTimeBetweenAndChanel);
//
        Serialization writer = new Serialization(sortedOfTimePrograms, "программы.xlsx");
        Serialization.saveToExcel(sortedOfTimePrograms, "программы.xlsx");
//    }
    }
}