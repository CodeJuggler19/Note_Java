package org.problem.prob17089;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[501][501];
        int[][] matrix = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j > 0; j--) {
                dp[j][i] = Integer.MAX_VALUE;
                for (int s = j; s < i; s++) {
                    dp[j][i] = Math.min(dp[j][i],
                            dp[j][s] + dp[s + 1][i] + matrix[j][0] * matrix[s][1] * matrix[i][1]);
                }
            }
        }
    }
}
