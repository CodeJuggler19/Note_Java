package org.softeer.선물배달;

import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] map;
    static List<List<Node>> tpList = new ArrayList<>();
    static Map<Integer, Integer> tpIndex = new HashMap<>();
    static Node gift;
    static Node endPoint;
    static int n, m;
    static boolean[][] visited;
    static boolean g_check = false;
    static int tp_cnt = Integer.MAX_VALUE;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        endPoint = new Node(n - 1, m - 1);
        map = new int[n][m];

        int idx = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -2) {
                    gift = new Node(i, j);
                } else if (map[i][j] >= 10) {
                    if (!tpIndex.containsKey(map[i][j])) {
                        tpIndex.put(map[i][j], idx++);
                        tpList.add(new ArrayList<>());  // 추가: 각 tpList 인덱스에 빈 리스트 초기화
                    }
                }
            }
        }

        // tp 위치 기록
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] >= 10) {
                    int index = tpIndex.get(map[i][j]);
                    tpList.get(index).add(new Node(i, j));
                }
            }
        }

        // dfs로 그냥 갈 수 있는지 확인
        visited = new boolean[n][m];
        dfs(0, 0, gift);

        // 안되면 tp 사용해서
        if (g_check) {
            g_check = false;
            dfs(gift.x, gift.y, endPoint);
            if (g_check) {
                bw.write(0 + "\n"); // tp를 한번도 사용 안한 경우
            } else {
                // tp 사용
                bfs(gift.x, gift.y, endPoint);
                g_check = false;
                bw.write(tp_cnt + "\n");
            }
        } else { // tp 사용
            g_check = false;

            bfs(0, 0, gift);
            g_check = false;
            int temp = tp_cnt;
            cnt = 0;
            tp_cnt = Integer.MAX_VALUE;

            dfs(gift.x, gift.y, endPoint);
            if (g_check) {
                bw.write(temp + "\n");
            } else {
                // tp 사용
                bfs(gift.x, gift.y, endPoint);
                g_check = false;
                tp_cnt += temp;
                bw.write(tp_cnt + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static void dfs(int x, int y, Node end) {
        if (end.x == x && end.y == y) {
            g_check = true;
            return;
        }
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] != -1 && !visited[nx][ny]) {
                dfs(nx, ny, end);
                visited[nx][ny] = false;
            }
        }
    }

    static void bfs(int x, int y, Node end) { // 시작 지점의 좌표 및 도착 지점 노드, 처음에는 선물, 그 다음에는 endPoint
        Queue<Node> q = new LinkedList<>();
        visited = new boolean[n][m];
        q.add(new Node(x, y));

        while (!q.isEmpty()) {
            Node c = q.poll();
            visited[c.x][c.y] = true;
            if (map[c.x][c.y] >= 10) {
                tp(c.x, c.y, end); // 수정: 현재 위치로 tp 호출
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] != -1 && !visited[nx][ny]) {
                    q.add(new Node(nx, ny));
                }
            }
        }
    }

    static void tp(int x, int y, Node end) {
        Integer index = tpIndex.get(map[x][y]); // tpIndex에서 값을 가져올 때 null 체크
        if (index == null) return; // null인 경우 함수 종료

        for (Node node : tpList.get(index)) {
            int nx = node.x;
            int ny = node.y;
            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                cnt++;
                dfs(nx, ny, end); // 텔레포트 후 dfs로 경로 찾기
                if (g_check) {
                    tp_cnt = Math.min(tp_cnt, cnt);
                    return;
                } else {
                    bfs(nx, ny, end); // 다시 bfs로 탐색
                }
                cnt--; // 다른 경로를 탐색하기 위해 텔레포트 횟수 복원
                visited[nx][ny] = false;
            }
        }
    }
}
