package org.problem.prob9663;

import java.io.*;
import java.util.*;

public class Main2 {

    static boolean[] map;

    static int result = 0;

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new boolean[N];

        bw.flush();
        bw.close();
        br.close();
    }

    static void backTracking(int count) {
        if(count == N){
            result++;
            return;
        }

        for(int i = 0; i < N; i++){
            map[count] = true;

        }

    }

}
