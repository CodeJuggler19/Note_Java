package org.problem.prob1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    // 상하좌우 이동을 위한 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] graph;
    static int M, N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수 입력

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 배추밭의 가로 크기
            N = Integer.parseInt(st.nextToken()); // 배추밭의 세로 크기
            K = Integer.parseInt(st.nextToken()); // 배추가 심어진 위치의 개수

            // 배추밭 초기화
            graph = new int[N][M];

            // 배추 위치 입력
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[y][x] = 1;
            }

            int result = 0;

            // 배추밭 전체를 순회하며 DFS로 연결된 배추를 찾는다
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (graph[i][j] == 1) { // 배추가 있는 경우
                        dfs(i, j); // DFS 수행
                        result++; // 필요한 배추흰지렁이 수 증가
                    }
                }
            }

            System.out.println(result);
        }
    }

    // DFS 메서드 정의
    public static void dfs(int x, int y) {
        // 현재 위치 방문 처리
        graph[x][y] = 0;

        // 상하좌우 인접한 배추 확인
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 배추밭 범위 내에 있고, 아직 방문하지 않은 배추가 있는 경우 DFS 수행
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && graph[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
}