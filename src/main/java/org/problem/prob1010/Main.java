package org.problem.prob1010;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[31][31];
        for (int i = 1; i <= 30; i++) {
            for (int j = 1; j <= i; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else if( j == 1) {
                    dp[i][j] = i;
                }else{
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(dp[b][a]);
        }

    }
}
