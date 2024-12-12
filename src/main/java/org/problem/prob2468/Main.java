package org.problem.prob2468;

import java.util.Scanner;

public class Main {
    static int N;
    static int[][] heights;
    static int[][] check;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int result = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        heights = new int[N + 1][N + 1];
        int maxHeight = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                heights[i][j] = scanner.nextInt();
                maxHeight = Math.max(maxHeight, heights[i][j]);
            }
        }
        for (int i = 0; i <= maxHeight; i++) {
            check = new int[N + 1][N + 1];
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (heights[j][k] - i <= 0) check[j][k] = -1;
                }
            }
            result = Math.max(result, cal());
        }
        System.out.println(result);
        scanner.close();
    }

    static int cal() {
        int cnt = 0;
        for (int i = 1; i<=N ; i++) {
            for (int j = 1; j <=N ; j++) {
                if(check[i][j] != -1){
                    dfs(i,j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void dfs(int x, int y) {
        check[x][y] = -1;
        for (int i = 0; i <4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>0 && nx<=N && ny>0 && ny<=N && check[nx][ny] == 0){
                dfs(nx,ny);
            }
        }
    }
}
