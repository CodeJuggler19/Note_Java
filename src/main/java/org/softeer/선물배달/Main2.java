package org.softeer.선물배달;

import java.io.*;
import java.util.*;

public class Main2 {

    static class Node {
        int x, y;

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
    static int tp_cnt = Integer.MAX_VALUE;

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

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
                        tpList.add(new ArrayList<>());
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

        // 선물까지 최소 텔레포트 사용 횟수를 계산
        int tpToGift = bfsWithTp(0, 0, gift);
        // 선물에서 도착 지점까지 최소 텔레포트 사용 횟수를 계산
        int tpToEnd = bfsWithTp(gift.x, gift.y, endPoint);

        if (tpToGift == Integer.MAX_VALUE || tpToEnd == Integer.MAX_VALUE) {
            bw.write("-1\n"); // 도달 불가능한 경우
        } else {
            bw.write((tpToGift + tpToEnd) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // BFS를 사용한 텔레포트 포함 최단 거리 탐색
    static int bfsWithTp(int startX, int startY, Node end) {
        Queue<Node> q = new LinkedList<>();
        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[startX][startY] = 0;
        q.add(new Node(startX, startY));

        while (!q.isEmpty()) {
            Node current = q.poll();
            int x = current.x;
            int y = current.y;

            // 도착 지점에 도달하면 최소 텔레포트 횟수를 반환
            if (x == end.x && y == end.y) {
                return dist[x][y];
            }

            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] != -1) {
                    if (dist[nx][ny] > dist[x][y]) {
                        dist[nx][ny] = dist[x][y];
                        q.add(new Node(nx, ny));
                    }
                }
            }

            // 텔레포트 사용
            if (map[x][y] >= 10) {
                int tpIndexKey = tpIndex.get(map[x][y]);
                for (Node tpNode : tpList.get(tpIndexKey)) {
                    if (dist[tpNode.x][tpNode.y] > dist[x][y] + 1) {
                        dist[tpNode.x][tpNode.y] = dist[x][y] + 1;
                        q.add(new Node(tpNode.x, tpNode.y));
                    }
                }
            }
        }

        return Integer.MAX_VALUE; // 도달 불가능한 경우
    }
}
