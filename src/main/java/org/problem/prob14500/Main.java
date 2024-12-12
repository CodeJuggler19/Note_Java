package org.problem.prob14500;

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int[][] paper;

    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        paper = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, paper[i][j]);
                visited[i][j] = false;
                check(i, j);
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    static void check(int x, int y){
        if((x - 1) > 0 && (y - 1) > 0 && (y + 1) <= m){
            result = Math.max(result,
                    paper[x][y] + paper[x - 1][y] + paper[x][y - 1] + paper[x][y + 1]
            );
        }

        if((x + 1) <= n && (y - 1) > 0 && (y + 1) <= m){
            result = Math.max(result,
                    paper[x][y] + paper[x + 1][y] + paper[x][y - 1] + paper[x][y + 1]
            );
        }

        if((x - 1) > 0 && (x + 1) <= n && (y + 1) <= m){
            result = Math.max(result,
                    paper[x][y] + paper[x - 1][y] + paper[x + 1][y] + paper[x][y + 1]
            );
        }

        if((x - 1) > 0 && (x + 1) <= n && (y - 1) > 0){
            result = Math.max(result,
                    paper[x][y] + paper[x - 1][y] + paper[x + 1][y] + paper[x][y - 1]
            );
        }
    }

    static void dfs(int x, int y, int cnt, int sum){

        if(cnt == 4){
            result = Math.max(result, sum);
            return;
        }

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx > 0 && nx <= n && ny > 0 && ny <= m && !visited[nx][ny]){
                visited[nx][ny] = true;
                dfs(nx, ny, cnt + 1, sum + paper[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }
}