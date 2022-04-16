package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{
        File inputData = new File("C:\\Users\\karen\\IdeaProjects\\06_AoC_01\\inputData.txt");
        Scanner scanner = new Scanner(inputData);
        ArrayList<String> dataList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            dataList.add(scanner.nextLine());
        }

        int dataListcounter =0;
        while (dataListcounter < dataList.size()-1) {
            if(!Objects.equals(dataList.get(dataListcounter + 1), "")) {
                dataList.set(dataListcounter, dataList.get(dataListcounter)+ "_" + dataList.get(dataListcounter+1));
                dataList.remove(dataListcounter+1);
            } else {
                dataListcounter++;
            }
        }

        int[] countedDataArray = new int[dataList.size()];

        ////// Nur den Teil hier ändern:
        for (int i = 0; i < dataList.size(); i++) {
            int[] alphabetarray = new int[26];
            for (int j = 0; j < dataList.get(i).length(); j++) {
                if(dataList.get(i).charAt(j) != '_') {
                    alphabetarray[(int) (dataList.get(i).charAt(j)) - 97]++;
                }
            }
            for (int k : alphabetarray) {
                if (k == dataList.get(i).split("_").length - 1) {
                    countedDataArray[i]++;
                }
            }
        }
        //////

        int yescounts = 0;
        for (int j : countedDataArray) {
            System.out.println(j);
            yescounts += j;
        }
        System.out.println("Yes-Counts: " + yescounts);

        //aus irgendeinem Grund liefert das Programm nur für die erste Eingabe falsche Werte, kp warum


    }
}
