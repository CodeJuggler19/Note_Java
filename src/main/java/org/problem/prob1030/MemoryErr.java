package org.problem.prob1030;

import java.io.*;
import java.util.StringTokenizer;

public class MemoryErr {
    static int s;
    static int N;
    static int K;
    static int R1;
    static int R2;
    static int C1;
    static int C2;

    static int[][] before;
    static int[][] after;

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

        //memo R1, C1 은 0부터 가능하다.
        before = new int[1][1];
        while (s-- > 0) {
            int before_size = before.length;
            int after_size = before_size * N;

            after = new int[after_size][after_size];

            for (int i = 0; i < before.length; i++) {
                for (int j = 0; j < before[0].length; j++) {
                    fractal(i, j, before[i][j] == 1);
                }
            }

            before = after;

        }
        for (int i = R1; i <= R2; i++) {
            for (int j = C1; j <= C2; j++) {
                bw.write(after[i][j] + "");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void fractal(int x, int y, boolean check) {
        if (check) {//memo 1일 경우
            for (int i = x * N; i < x * N + N; i++) {
                for (int j = y * N; j < y * N + N; j++) {
                    after[i][j] = 1;
                }
            }
            return;
        }

        int start = (N - K) / 2;
        int x_start = x * N + start;
        int y_start = y * N + start;
        for (int i = x_start; i < x_start + K; i++) {
            for (int j = y_start; j < y_start + K; j++) {
                after[i][j] = 1;
            }
        }
    }
}
