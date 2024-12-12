package org.problem.prob11659;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);

        int[] numbers = new int[N + 1];  // 1-based index 사용
        String[] secondLine = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(secondLine[i - 1]);
        }

        int[] sum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            sum[i] = numbers[i] + sum[i - 1];
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(sum[end] - sum[start - 1]);
        }

        br.close();
    }

}
