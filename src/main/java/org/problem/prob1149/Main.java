package org.problem.prob1149;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 첫 번째 줄에 집의 수 N 입력
        int N = scanner.nextInt();

        int[][] cost = new int[N + 1][4];

        int[][] dp = new int[N + 1][4];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 3; j++) {
                cost[i][j] = scanner.nextInt();
            }
        }
        dp[1][1] = cost[1][1];
        dp[1][2] = cost[1][2];
        dp[1][3] = cost[1][3];
        for (int i = 2; i <= N; i++) {
            dp[i][1] = cost[i][1] + Math.min(dp[i-1][2],dp[i-1][3]);
            dp[i][2] = cost[i][2] + Math.min(dp[i-1][1],dp[i-1][3]);
            dp[i][3] = cost[i][3] + Math.min(dp[i-1][1],dp[i-1][2]);
        }
        int result =Integer.MAX_VALUE;
        for (int i = 1; i <=3 ; i++) {
            result = Math.min(result, dp[N][i]);
        }
        System.out.println(result);

        scanner.close();
    }
}
