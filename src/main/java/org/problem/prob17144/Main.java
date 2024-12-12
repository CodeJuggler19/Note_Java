package org.problem.prob17144;

import java.util.*;
import java.io.*;

public class Main {
    static int[][][] map;
    static int[][] cleaner = new int[2][2];

    static Queue<Node> dust = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        map = new int[r][c][2];

        int temp = 0;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j][0] = Integer.parseInt(st.nextToken());
                if (map[i][j][0] == -1) {
                    // 공기 청정기의 위치
                    cleaner[temp][0] = i;
                    cleaner[temp][1] = j;
                    temp++;
                } else if (map[i][j][0] != 0) {
                    dust.add(new Node(i, j));
                }
            }
        }
        // 공기 청정기 위아래 확인
        if (cleaner[0][1] < cleaner[1][1]) {
            temp = cleaner[0][1];
            cleaner[0][1] = cleaner[1][1];
            cleaner[1][1] = temp;
        }
        // n초 후 새로운 Q를 넣기전 먼지가 확산된 상태 list


        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int result = 0;

        for (int i = 0; i < t; i++) {
            Set<Node> check = new HashSet<>();
            while (!dust.isEmpty()) {
                Node current = dust.poll();
                // 값이 업데이트(먼지) 되야하는 list
                int divideValue = map[current.getR()][current.getC()][0] / 5;
                int cnt = 0;
                for (int j = 0; j < 4; j++) {
                    int nr = current.getR() + dr[j];
                    int nc = current.getC() + dc[j];

                    if (nr >= 0 && nr < r && nc >= 0 && nc < c && map[nr][nc][0] != -1) {
                        map[nr][nc][1] += divideValue;
                        check.add(new Node(nr, nc));
                        cnt++;
                    }
                }
                map[current.getR()][current.getC()][0] -= (divideValue * cnt);
                if (map[current.getR()][current.getC()][0] > 0) {
                    check.add(new Node(current.getR(), current.getC()));
                }
            }

            for (Node node : check) {
                int nr = node.getR();
                int nc = node.getC();
                map[nr][nc][0] += map[nr][nc][1];
                map[nr][nc][1] = 0;
            }


            // 공기청정기 작동 (상단 반시계방향)
            int upper = cleaner[0][0];
            for (int j = upper - 1; j > 0; j--) {
                map[j][0][0] = map[j - 1][0][0];
            }
            for (int j = 0; j < c - 1; j++) {
                map[0][j][0] = map[0][j + 1][0];
            }
            for (int j = 0; j < upper; j++) {
                map[j][c - 1][0] = map[j + 1][c - 1][0];
            }
            for (int j = c - 1; j > 1; j--) {
                map[upper][j][0] = map[upper][j - 1][0];
            }
            map[upper][1][0] = 0;  // 공기청정기에서 나오는 바람

            // 공기청정기 작동 (하단 시계방향)
            int lower = cleaner[1][0];
            for (int j = lower + 1; j < r - 1; j++) {
                map[j][0][0] = map[j + 1][0][0];
            }
            for (int j = 0; j < c - 1; j++) {
                map[r - 1][j][0] = map[r - 1][j + 1][0];
            }
            for (int j = r - 1; j > lower; j--) {
                map[j][c - 1][0] = map[j - 1][c - 1][0];
            }
            for (int j = c - 1; j > 1; j--) {
                map[lower][j][0] = map[lower][j - 1][0];
            }
            map[lower][1][0] = 0;  // 공기청정기에서 나오는 바람

            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    if(map[j][k][0] > 0){
                        if(i == t-1){
                            result += map[j][k][0];
                        }else{
                            dust.add(new Node(j, k));
                        }
                    }
                }
            }
        }

        System.out.println(result);
        br.close();
    }


    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        int getR() {
            return this.r;
        }

        int getC() {
            return this.c;
        }

    }

}
