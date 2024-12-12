package org.problem.prob12996;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k + 1];

        ArrayList<Integer> coins = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            coins.add(value);
        }
        dp[0] =1;
        for (Integer coin : coins) {
            for (int i = coin; i <= k; i++) {
                dp[i] += dp[i-coin];
            }
        }
        System.out.println(dp[k]);

    }
}
