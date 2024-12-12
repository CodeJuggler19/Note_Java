package org.problem.prob1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용해 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력받을 테스트 케이스 개수
        int t = Integer.parseInt(br.readLine());

        // DP 배열 초기화 (dp[n][0]은 0이 호출된 횟수, dp[n][1]은 1이 호출된 횟수)
        int[][] dp = new int[41][2];

        // 초기값 설정
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        // 케이스 입력받기
        int[] cases = new int[t];
        for (int i = 0; i < t; i++) {
            cases[i] = Integer.parseInt(br.readLine());
        }

        // 피보나치 함수 호출 횟수 계산하는 메소드
        for (int i = 0; i < t; i++) {
            fibo(cases[i], dp);
            System.out.println(dp[cases[i]][0] + " " + dp[cases[i]][1]);
        }
    }

    public static void fibo(int n, int[][] dp) {
        if (n == 0 || n == 1) {
            return;
        }

        // 아직 계산되지 않은 경우 재귀 호출을 통해 계산
        if (dp[n - 1][0] == 0 && dp[n - 1][1] == 0) {
            fibo(n - 1, dp);
        }
        if (dp[n - 2][0] == 0 && dp[n - 2][1] == 0) {
            fibo(n - 2, dp);
        }

        // 현재 값 계산
        dp[n][0] = dp[n - 1][0] + dp[n - 2][0];
        dp[n][1] = dp[n - 1][1] + dp[n - 2][1];
    }
}