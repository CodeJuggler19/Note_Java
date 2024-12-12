package org.problem.prob2293;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[k + 1][n];
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                if (i - coin[j] > 0) {
                    for (int t = j; t >= 0; t--) {
                        dp[i][j] += dp[i - coin[j]][t];
                    }
                } else if (i - coin[j] == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println(dp[k][0] + dp[k][1] + dp[k][2]);
    }
}
