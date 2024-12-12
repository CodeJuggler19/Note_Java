package org.problem.prob4195;

import java.io.*;
import java.util.*;

public class Main {
    static Map<String, Integer> cnt;
    static Set<String> people;
    static Map<String, String> parent;

    static int con = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            people = new HashSet<>();
            parent = new HashMap<>();
            cnt = new HashMap<>();
            for (int j = 0; j < num; j++) {
                String[] name = br.readLine().split(" ");

                for (int z = 0; z < 2; z++) {
                    if (!people.contains(name[z])) {
                        people.add(name[z]);
                        parent.put(name[z], name[z]);
                        cnt.put(name[z], 1);
                    }
                }
                union(name[0], name[1]);

                bw.write((cnt.get(find(name[1]))) + "\n");
            }
        }
        System.out.println("실행 결과: " + con);
        bw.flush();
        bw.close();
        br.close();

    }

    static String find(String x){
        if (!x.equals(parent.get(x))) {
            con++;
            parent.replace(x, find(parent.get(x))); // Path compression
        }
        return parent.get(x);
//        if (x.equals(parent.get(x))) return x;
//
//        return parent.put(x, find(parent.get(x)));
    }
    static void union(String x, String y){
        x = find(x);
        y = find(y);

        if(!x.equals(y)){
            parent.replace(y, x);
            cnt.replace(x, cnt.get(x) + cnt.get(y));
        }
    }
}
