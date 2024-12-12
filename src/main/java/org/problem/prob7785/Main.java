package org.problem.prob7785;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> employees = new TreeSet<>(Collections.reverseOrder());

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            String[] employ = temp.split(" ");

            if(employ[1].charAt(0) == 'e'){
                employees.add(employ[0]);
            }else{
                employees.remove(employ[0]);
            }
//            if(employ[1].equals("enter")){
//                employees.add(employ[0]);
//            }else{
//                employees.remove(employ[0]);
//            }
        }

        for (String employee : employees) {
            System.out.println(employee);
        }

//        Iterator<String> iter = employees.iterator();
//
//        while(iter.hasNext()){
//            System.out.println(iter.next());
//        }
    }

}
