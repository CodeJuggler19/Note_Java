package org.problem.prob1011;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = end - start;

            int sqrtD = (int) Math.sqrt(distance);
            if (sqrtD * sqrtD == distance) {
                bw.write((2 * sqrtD - 1) + "\n");
            } else if (distance <= sqrtD * sqrtD + sqrtD) {
                bw.write((2 * sqrtD) + "\n");
            } else {
                bw.write((2 * sqrtD + 1) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
