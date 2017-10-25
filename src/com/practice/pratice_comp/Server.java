package com.practice.pratice_comp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Server {


    public static void main(String[] args) {

        try {
            List<String> strings = Files.readAllLines(new File("C:\\Users\\zgh\\Dropbox\\Code\\Code Projects\\AcuityBotting\\ProgrammingCompPractice\\src\\com\\practice\\pratice_comp\\serverInput.txt").toPath());

            String p1 = null;
            String p2 = null;
            int caseI = 0;
            for (String string : strings) {
                if (p1 == null){
                    p1 = string;
                }
                else if (p2 == null){
                    p2 = string;
                }


               if (p1 != null && p2 != null){
                    String[] split = p1.split(" ");

                    int n = Integer.parseInt(split[0]);
                    int t = Integer.parseInt(split[1]);

                    int total = 0;
                    List<Integer> collect = Arrays.stream(p2.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
                    int i;
                    for (i = 0; i < collect.size(); i++) {
                        total += collect.get(i);
                        if (total > t){
                            break;
                        }
                    }

                    System.out.println("Case " + ++caseI + ": " + i);

                    p1 = null;
                    p2 = null;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
