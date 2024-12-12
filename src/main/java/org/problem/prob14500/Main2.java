package org.problem.prob14500;

import java.util.*;
import java.io.*;

// memo  시간 초과
public class Main2 {
    static int n;
    static int m;
    static int[][] paper;
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

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                bfs(i, j);
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int x, int y) {
        boolean[][] visited = new boolean[n + 1][m + 1];
        Queue<Node> q = new PriorityQueue<>();

        q.add(new Node(x, y, paper[x][y]));
        int cnt = 4;
        int temp = 0;

        while (!q.isEmpty()) {
            Node curNode = q.poll();
            temp += curNode.cost;
            cnt--;
            if (cnt == 0) {
                result = Math.max(result, temp);
                break;
            }

            visited[curNode.x][curNode.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = curNode.x + dx[i];
                int ny = curNode.y + dy[i];
                if (nx > 0 && nx <= n && ny > 0 && ny <= m && !visited[nx][ny]) {
                    q.add(new Node(nx, ny, paper[nx][ny]));
                }
            }
        }
    }
    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return this.cost <= node.cost ? 1 : -1;
        }
    }
}