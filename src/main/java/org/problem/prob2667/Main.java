package org.problem.prob2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
// 단지 번호 붙이기
public class Main {

    static int n;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 지도 크기 입력
        n = Integer.parseInt(br.readLine());

        // 그래프 및 방문 배열 초기화
        graph = new int[n][n];
        visited = new boolean[n][n];

        // 지도 입력
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        // 모든 좌표를 순회하면서 DFS 실행
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    dfs(i, j);
                    result.add(count);
                }
            }
        }

        // 단지별 크기를 오름차순으로 정렬
        Collections.sort(result);

        // 출력
        System.out.println(result.size());
        for (int complexSize : result) {
            System.out.println(complexSize);
        }
    }

    // DFS 메서드 정의
    public static void dfs(int x, int y) {
        visited[x][y] = true;  // 현재 위치 방문 처리
        count++;  // 단지 내 집의 수 증가

        // 상하좌우 인접한 노드 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 내에 있고, 방문하지 않았으며, 집이 있는 경우 DFS 실행
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && graph[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}