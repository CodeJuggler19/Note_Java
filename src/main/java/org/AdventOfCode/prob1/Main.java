package org.AdventOfCode.prob1;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int result = 0;
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();

        while (true) {
            try {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                A.add(a);
                B.add(b);
            } catch (Exception e) {
                break;
            }
        }
        Collections.sort(A);
        Collections.sort(B);

        for(int i = 0; i < A.size(); i++){
            result += Math.abs(A.get(i) - B.get(i));
        }
        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
