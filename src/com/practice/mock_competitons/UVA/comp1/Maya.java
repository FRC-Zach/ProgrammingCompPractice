package com.practice.mock_competitons.UVA.comp1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Maya {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int amount = Integer.parseInt(sc.nextLine());

        List<String> output = new ArrayList<String>();
        System.out.println(amount);
        for  (int i = 0; i < amount; i++) {
            String line = sc.nextLine();
            int day = Integer.parseInt(line.split("\\.")[0]);
            String month = line.split(" ")[1];
            int year = Integer.parseInt(line.split(" ")[2]);
            int realDay = getRealDay(day, month, year);

            String[] tzolMonths = new String[]{
                    "imix", "ik", "akbal", "kan", "chicchan", "cimi", "manik", "lamat", "muluk",
                    "ok", "chuen", "eb", "ben", "ix", "mem", "cib", "caban", "eznab", "canac", "ahau"
            };
            int outputMonthInt = realDay % tzolMonths.length;
            int outputDay = (realDay % 13) + 1;
            int outputYear = realDay / 260;

            output.add(outputDay + " " + tzolMonths[outputMonthInt] + " " + outputYear);
        }


        System.out.print(output.stream().collect(Collectors.joining("\n")));
    }


    static int getRealDay(int dayNum, String month, int year) {
        String[] inputMonths = new String[] {
                "pop", "no", "zip", "zotz", "tzec",  "xul", "yoxkin", "mol",
                "chen", "yax", "zac", "ceh", "mac", "kankin",  "muan", "pax",
                "koyab", "cumhu", "uayet"
        };
        int monthNum = 0;
        for (int i = 0; i < inputMonths.length; i++){
            if (inputMonths[i].equals(month)){
                monthNum = i;
                break;
            }
        }
        int realDay = ((monthNum * 20) + dayNum) + (year * 365);

        return realDay;
    }
}
