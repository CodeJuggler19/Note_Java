package org.problem.prob4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 섬의 개수
public class Main {

    static int w, h;
    static int[][] graph;
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            // 종료 조건
            if (w == 0 && h == 0) break;

            // 그래프 초기화
            graph = new int[h][w];

            // 그래프 입력
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;

            // 모든 위치를 순회하면서 DFS 실행
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (graph[i][j] == 1) { // 섬을 발견한 경우
                        dfs(i, j);
                        result++;
                    }
                }
            }

            System.out.println(result);
        }
    }

    // DFS 메서드 정의
    public static void dfs(int x, int y) {
        graph[x][y] = 0;  // 방문 처리

        // 8방향으로 인접한 노드 탐색
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 내에 있고, 방문하지 않은 섬이 있는 경우 DFS 실행
            if (nx >= 0 && nx < h && ny >= 0 && ny < w && graph[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
}