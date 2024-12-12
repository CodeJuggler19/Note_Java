package org.problem.prob2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int blue = 0;
    public static int white = 0;
    public static int[][] paper;

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

        cutPaper(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void cutPaper(int x, int y, int N) {
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

        for (int i = x; i < N + x; i++) {
            for (int j = y; j < N + y; j++) {
                if (init != paper[i][j]) {
                    cut = false;
                    break;
                }
            }
            if (!cut) {
                break;
            }
        }

        if (cut) { // 쪼개 필요 없을 때
            if (init == 0) {
                white++;
            } else {
                blue++;
            }
        } else {    // 쪼개야 할 때
            cutPaper(x, y, N / 2);
            cutPaper(x + (N / 2), y, N / 2);
            cutPaper(x, y + (N / 2), N / 2);
            cutPaper(x + (N / 2), y + (N / 2), N / 2);

        }


    }
}
