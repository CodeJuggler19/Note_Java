package org.test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int m = 4; // 가로
        int n = 3; // 세로
        int[][] puddles = {{2, 2}}; // 물웅덩이 위치

        // Solution 클래스의 메서드 호출
        Solution sol = new Solution();
        int result = sol.solution(m, n, puddles);
        System.out.println("결과: " + result); // 최종 경로 수 출력
    }
}

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int [][]dp = new int[n][m];

        // 물웅덩이를 -1로 표시
        for (int[] i : puddles)
            dp[i[1] - 1][i[0] - 1] = -1;

        dp[0][0] = 1; // 출발점 초기화

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == 0) {
                    if (i != 0 && dp[i - 1][j] != -1)
                        dp[i][j] += dp[i - 1][j]; // 위쪽에서 오는 경로
                    if (j != 0 && dp[i][j - 1] != -1)
                        dp[i][j] += dp[i][j - 1]; // 왼쪽에서 오는 경로
                    dp[i][j] %= 1000000007; // 큰 수 처리
                }
            }
        }
        System.out.println(Arrays.deepToString(dp)); // 최종 경로 수 출력
        return dp[n - 1][m - 1]; // 도착점의 값 반환
    }
}

