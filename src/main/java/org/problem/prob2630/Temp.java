package org.problem.prob2630;

import java.io.*;

public class Temp {

    public static int[][] paper;
    public static int white = 0;
    public static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            str = str.replace(" ", "");
            for (int j = 0; j < N; j++) {
                paper[i][j] = str.charAt(j) - '0';
            }
        }
        cutPaper(0,0,N);
        System.out.println(white);
        System.out.println(blue);

    }

    public static void cutPaper(int x, int y, int N) {
        int init = paper[x][y];

        if (N == 1) {
            if (init == 0) {
                white++;
                return;
            } else {
                blue++;
                return;
            }
        }

        boolean cut = true;

        for (int i = x; i < x + N; i++) {
            for (int j = y; j < y + N; j++) {
                if (init != paper[i][j]) {
                    cut = false;
                    break;
                }
            }
        }

        if (cut) {
            if (init == 0) {
                white++;
            } else {
                blue++;
            }
        } else {
            cutPaper(x, y, N / 2);
            cutPaper(x + (N / 2), y, N / 2);
            cutPaper(x, y + (N / 2), N / 2);
            cutPaper(x + (N / 2), y + (N / 2), N / 2);
        }
    }
}
