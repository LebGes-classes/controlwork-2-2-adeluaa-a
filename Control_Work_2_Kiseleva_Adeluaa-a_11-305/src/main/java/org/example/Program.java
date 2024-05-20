package org.example;

import java.util.ArrayList;
import java.util.Comparator;

public class Program {
    private String canal;
    private BroadcastsTime time;
    private String name;
    public Program(String canal, BroadcastsTime time, String name ) {
        this.canal = canal;
        this.time = time;
        this.name = name;
    }
    public BroadcastsTime getTime() {
        return time;
    }
    public String getCanal() {
        return canal;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Program{" +
                "chanel='" + canal + '\'' +
                ", time=" + time +
                ", name='" + name + '\'' +
                '}';
    }
    public static ArrayList <Program> sortTime(ArrayList <Program> allPrograms) {
        allPrograms.sort(Comparator.comparing(Program::getTime));
        return allPrograms;
    } //вывести все программы в порядке возрастания канал, время показа
    public  static ArrayList <Program> currentPrograms(ArrayList <Program> allProgram, String currentTime){
        BroadcastsTime currentBroadTime = new BroadcastsTime(currentTime);
        ArrayList <Program> currentProga = new ArrayList<>();
        for (int i = 0; i < allProgram.size(); i++) {
            if (allProgram.get(i).getTime().compareTo(currentBroadTime) == 0){
                currentProga.add(allProgram.get(i));
            }
        }
        return currentProga;
    } //вывести все программы, которые идут сейчас
    public static ArrayList<Program> programBetween(ArrayList<Program> allProgram, String time_1, String time_2, String canal){
        BroadcastsTime broadTime1 = new BroadcastsTime(time_1);
        BroadcastsTime broadTime2 = new BroadcastsTime(time_2);
        ArrayList<Program> progaBetween = new ArrayList<>();
        for (Program program : allProgram) {
            if (program.getTime().between(broadTime1, broadTime2) && (program.getCanal().equals(canal))){
                progaBetween.add(program);
            }

        }return progaBetween;
    } //найти все программы определенного канала, которые будут идти в некотором промежутке времени
    public static ArrayList<Program> getProgramsWithName(ArrayList<Program> programs, String name) {
        ArrayList<Program> programsWithName = new ArrayList<>();
        for(Program program: programs) {
            if (program.name.equals(name)) {
                programsWithName.add(program);
            }
        }
        return programsWithName;
    } //найти все программы по некоторому названию

    public static Program getCanalNameCurrentTime(ArrayList <Program> programs, String canal, String time ) {
        BroadcastsTime broadcastsTime = new BroadcastsTime(time);
        for (Program program: programs) {
            if (program.getName().equals(canal)){
                return program;
            }
        }
        return null;
    }//найти все программы определенного канала, которые идут сейчас
}
