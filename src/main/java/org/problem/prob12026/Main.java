package org.problem.prob12026;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[] blocks = br.readLine().toCharArray();

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >=0; j--) {
                if (blocks[i] == 'O' && blocks[j] == 'B' && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + (i - j) * (i - j));
                }else if(blocks[i] == 'J' && blocks[j] == 'O' && dp[j] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[j] + (i - j) * (i - j));
                }else if(blocks[i] == 'B' && blocks[j] == 'J' && dp[j] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[j] + (i - j) * (i - j));
                }
            }
        }

        if(dp[n-1] != Integer.MAX_VALUE){
            System.out.println(dp[n-1]);
        }else{
            System.out.println(-1);
        }

    }


}
