package org.problem.prob1446;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] shortcut = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            shortcut[i][0] = Integer.parseInt(st.nextToken());
            shortcut[i][1] = Integer.parseInt(st.nextToken());
            shortcut[i][2] = Integer.parseInt(st.nextToken());
        }
        solution(shortcut, d);
    }

    static void solution(int[][] shortcut, int d) {
        int[] dp = new int[d + 1];

        for (int i = 1; i <= d; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < shortcut.length; j++) {
                if (shortcut[j][1] == i) {
                    dp[i] = Math.min(dp[i], dp[shortcut[j][0]] + shortcut[j][2]);
                }
            }
        }
        System.out.println(dp[d]);
    }


}
