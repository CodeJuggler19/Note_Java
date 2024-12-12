package org.problem.prob14501;


import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N; // 퇴사 전까지 남은 일수
    static int[] T; // 상담에 필요한 기간
    static int[] P; // 상담을 했을 때 받을 수 있는 금액
    static int[] dp; // 최대 이익을 저장하는 배열

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // N 입력받기
        N = sc.nextInt();

        // 상담에 필요한 기간과 금액을 저장할 배열 초기화
        T = new int[N + 1];
        P = new int[N + 1];
        dp = new int[N + 1];

        // N일 동안 상담 일정 입력받기
        for (int i = 1; i <= N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }
        for (int i = 1; i <= N; i++) {
            if (i + T[i] <= N + 1) {
                dp[i] += P[i];
            }
            int max = 0;
            for (int j = i - 1; j >= 1; j--) {
                if (T[j] <= i - j) {
                    max = Math.max(max, dp[j] + dp[i]);
                }
            }
            if(max != 0){
                dp[i] = max;
            }
        }
        int result =0;
        for (int i = 1; i <=N ; i++) {
            if(dp[i] > result){
                result = dp[i];
            }
        }
        System.out.println(result);
    }

}