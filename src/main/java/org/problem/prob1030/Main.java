package org.problem.prob1030;

import java.io.*;
import java.util.*;

public class Main {
    static int s;
    static int N;
    static int K;
    static int R1;
    static int R2;
    static int C1;
    static int C2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R1 = Integer.parseInt(st.nextToken());
        R2 = Integer.parseInt(st.nextToken());
        C1 = Integer.parseInt(st.nextToken());
        C2 = Integer.parseInt(st.nextToken());

        for (int i = R1; i <= R2; i++) {
            for (int j = C1; j <= C2; j++) {
                bw.write(fractal(s, i, j) + "");
            }
            bw.write("\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }

    static int fractal(int depth, int x, int y) {
        if (depth == 0) {
            return 0;
        }

        int init = (N - K) / 2;
        int x_start = init + ((x / N) * N);
        int y_start = init + ((y / N) * N);

        if(x_start <= x && x_start + (K - 1) >= x && y_start <= y && y_start + (K - 1) >= y){
            return 1;
        }
        return fractal(depth - 1, x / N, y / N);
    }
}
