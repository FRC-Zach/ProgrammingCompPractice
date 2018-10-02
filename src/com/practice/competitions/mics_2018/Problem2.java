package com.practice.competitions.mics_2018;

import java.util.*;
import java.util.stream.Collectors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author reunion
 */
public class Problem2 {
    
    public static class Point{
        public double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
        
        
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String in = scanner.nextLine();
        
        List<Point> points = new ArrayList<>();
        
        String[] split = in.split(" ");
        for (int i = 0; i < split.length; i+= 2) {
            points.add(new Point(Double.parseDouble(split[i]), Double.parseDouble(split[i + 1])));
        }
        
        List<Point> xAxis = points.stream().filter(point -> point.y == 0).collect(Collectors.toList());
        xAxis.sort(Comparator.comparingDouble(t -> t.x));
        
        for (int i = 0; i < xAxis.size(); i+= 2) {
            Point p1 = xAxis.get(i);
            Point p2 = xAxis.get(i + 1);
            
            List<Point> query = points.stream().filter(point -> point.x > p1.x && point.x < p2.x).collect(Collectors.toList());
            
            List<Point> pos = query.stream().filter(point -> point.y > 0).collect(Collectors.toList());
            pos.sort(Comparator.comparingDouble(t -> t.x));
            List<Point> neg = query.stream().filter(point -> point.y < 0).collect(Collectors.toList());
            neg.sort((t, t1) -> {
            return Double.compare(t1.x, t.x);
            });
            
            
            
            String out = "Ring " + ((i / 2) + 1) + ": ";
            out += p1;
            
            for(Point p : pos) {
                out += " " + p ;
            }
            
            out += " " + p2;
            
            for(Point p : neg) {
                out += " " + p;
            }
            
       
            System.out.println(out.trim());
        }
        
        
    }
}
