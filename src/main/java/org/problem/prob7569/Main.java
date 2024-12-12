package org.problem.prob7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토
public class Main {

    static int m, n, h;
    static int[][][] graph;
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 0, -1, 1};
    static int[] dz = {-1, 1, 0, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());  // 가로 칸 수
        n = Integer.parseInt(st.nextToken());  // 세로 칸 수
        h = Integer.parseInt(st.nextToken());  // 높이

        graph = new int[h][n][m];

        Queue<int[]> queue = new LinkedList<>();

        // 그래프 초기화 및 익은 토마토 위치 저장
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    graph[i][j][k] = Integer.parseInt(st.nextToken());
                    if (graph[i][j][k] == 1) {
                        queue.add(new int[]{i, j, k});  // 익은 토마토의 위치를 큐에 추가
                    }
                }
            }
        }

        // BFS 실행
        bfs(queue);

        int maxDays = 0;

        // 익지 않은 토마토가 있는지 확인 및 최장 기간 계산
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (graph[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    maxDays = Math.max(maxDays, graph[i][j][k]);
                }
            }
        }

        System.out.println(maxDays - 1);
    }

    public static void bfs(Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] location = queue.poll();
            int z = location[0];
            int x = location[1];
            int y = location[2];

            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 내에 있고, 익지 않은 토마토가 있으면 익게 만든다
                if (nz >= 0 && nz < h && nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (graph[nz][nx][ny] == 0) {
                        graph[nz][nx][ny] = graph[z][x][y] + 1;
                        queue.add(new int[]{nz, nx, ny});
                    }
                }
            }
        }
    }
}
