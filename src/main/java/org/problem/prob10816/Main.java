package org.problem.prob10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> temp = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (temp.get(value) == null) temp.put(value, 1);
            else temp.put(value, temp.get(value) + 1);
        }
        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (temp.get(value) == null) sb.append(0).append(" ");
            else sb.append(temp.get(value)).append(" ");
        }
        System.out.println(sb);
    }
}
