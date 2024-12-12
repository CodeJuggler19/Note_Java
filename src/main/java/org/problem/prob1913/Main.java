package org.problem.prob1913;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[][] snail = new int[n + 1][n + 1];

        // 시작 지점의 좌표
        int x = 1;
        int y = 1;

        int direction = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int resultX = 0;
        int resultY = 0;
        for (int i = n * n; i >= 1; i--) {
            if (k == i) {
                resultX = x;
                resultY = y;
            }

            if (i == n * n) {
                snail[x][y] = i;
                x += dx[direction];
                y += dy[direction];
            } else {
                snail[x][y] = i;
                int nx = x + dx[direction];
                int ny = y + dy[direction];
                if (nx > 0 && nx <= n && ny > 0 && ny <= n && snail[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                } else {
                    direction++;
                    if (direction > 3) {
                        direction = 0;
                        x += dx[direction];
                        y += dy[direction];
                    } else {
                        x += dx[direction];
                        y += dy[direction];
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(snail[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print(resultX + " " + resultY);
    }
}
