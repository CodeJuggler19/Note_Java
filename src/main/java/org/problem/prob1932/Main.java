package org.problem.prob1932;

import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 삼각형의 크기 입력
        int n = Integer.parseInt(br.readLine());

        // 삼각형을 저장할 배열
        int[][] t = new int[n][n];
        // DP 테이블 초기화
        int[][] dp = new int[n][n];

        // 삼각형 입력
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                t[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // DP 초기값 설정
        dp[0][0] = t[0][0];

        // DP를 이용한 최대 합 계산
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    // 맨 왼쪽의 경우 위에서 내려오는 경우만 존재
                    dp[i][j] = dp[i - 1][j] + t[i][j];
                } else if (j == i) {
                    // 맨 오른쪽의 경우 위에서 내려오는 경우만 존재
                    dp[i][j] = dp[i - 1][j - 1] + t[i][j];
                } else {
                    // 가운데 있는 경우, 두 가지 경로 중 최대값을 선택
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + t[i][j], dp[i - 1][j] + t[i][j]);
                }
            }
        }

        // 마지막 줄에서 최대값 출력
        int max = 0;
        for (int j = 0; j < n; j++) {
            max = Math.max(max, dp[n - 1][j]);
        }

        System.out.println(max);
    }
}
