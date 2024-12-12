package org.softeer.성적평균;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] grade = new int[n + 1];
        grade[1] = Integer.parseInt(st.nextToken());
        for(int i = 2; i <= n; i++){
            grade[i] = (Integer.parseInt(st.nextToken()) + grade[i - 1]);
        }

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            double result = (double) (grade[end] - grade[start - 1]) / (end - start + 1);

            bw.write(String.format("%.2f",result) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
