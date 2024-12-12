package org.problem.prob1007;

import java.util.*;
import java.io.*;

public class Main {
    static int[][] list;
    static boolean[] positive;

    static double min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            list = new int[N][2];
            positive = new boolean[N];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list[j][0] = x;
                list[j][1] = y;
            }
            min = Double.MAX_VALUE;
            combination(0, N/2);
            bw.write(min+"\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static void combination(int index, int cnt) {
        if (index == list.length) return;
        if (cnt == 0) {
            min = Math.min(min, getValue());
        }

        for (int i = index; i < list.length; i++) {
            positive[i] = true;
            combination(i + 1, cnt - 1);
            positive[i] = false;
        }
    }

    static double getValue() {
        int sum_x = 0;
        int sum_y = 0;

        for (int i = 0; i < list.length; i++) {
            if (positive[i]) {
                sum_x += list[i][0];
                sum_y += list[i][1];
            } else {
                sum_x -= list[i][0];
                sum_y -= list[i][1];
            }
        }
        return Math.sqrt(Math.pow(sum_x, 2) + Math.pow(sum_y, 2));
    }
}
