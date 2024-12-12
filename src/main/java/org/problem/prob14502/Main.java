package org.problem.prob14502;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static int row;
    static int col;

    static int count = 0;
    static ArrayList<Virus> virus = new ArrayList<>();
    static int result = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Virus {
        int x;
        int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        graph = new int[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 2) {
                    virus.add(new Virus(i, j));
                } else if (graph[i][j] == 0) {
                    count++;
                }
            }
        }
        dfs(0);
        System.out.println(result);
        br.close();
    }

    static void dfs(int cnt) {
        if (cnt == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = 1;
                    dfs(cnt + 1);
                    graph[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        int[][] temp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                temp[i][j] = graph[i][j];
            }
        }

        int check = count - 3;
        Queue<Virus> q = new LinkedList<>();

        q.addAll(virus);
        // 이렇게 간단하게 넣을 수 있음
        // Queue<Virus> q = new LinkedList<>(virus);

        while (!q.isEmpty() && check > 0) {
            Virus current = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if(nx >=0 && nx < row && ny >=0 && ny < col && temp[nx][ny] == 0){
                    temp[nx][ny] = 2;
                    check--;
                    q.add(new Virus(nx, ny));
                }
            }
        }
        result = Math.max(result, check);
    }
}
