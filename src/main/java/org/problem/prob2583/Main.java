package org.problem.prob2583;

import java.io.*;
import java.util.*;

public class Main {
    static int m; // memo y
    static int n; // memo x
    static int k;

    static int[][] map;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int num = 0;
    static int cnt = 0;
    static ArrayList<Integer> cnt_list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // memo 오른쪽 위쪽은 좌표값을 하나씩 빼서 한칸을 하나의 좌표로 생각하면 될 것 같다.
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = 0;
            }
        }

        int x_l, y_l, x_r, y_r;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            x_l = Integer.parseInt(st.nextToken());
            y_l = Integer.parseInt(st.nextToken());
            x_r = Integer.parseInt(st.nextToken());
            y_r = Integer.parseInt(st.nextToken());

            for (int j = x_l; j < x_r; j++) {
                for (int l = y_l; l < y_r; l++) {
                    map[j][l] = 1;
                }
            }
//            map[x_l][y_l] = 1;
//            map[x_r - 1][y_r - 1] = 1;
//            dfs_filled(x_l, y_l, x_r, y_r);
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    dfs(i, j);
                    cnt_list.add(cnt);
                    cnt = 0;
                    num++;
                }
            }
        }

        System.out.println(num);
        Collections.sort(cnt_list);
        for (int i = 0; i < cnt_list.size(); i++) {
            System.out.print(cnt_list.get(i));
            if (i != cnt_list.size() - 1) {
                System.out.print(" ");
            }
        }

    }

//    public static void dfs_filled(int x_l, int y_l, int x_r, int y_r) {
//        map[x_l][y_l] = 1;
//
//        if (x_l == x_r - 1 && y_l == y_r - 1) {
//            return;
//        }
//        for (int i = 0; i < 2; i++) {
//            int nx = x_l + dx[i];
//            int ny = y_l + dy[i];
//
//            if (nx < x_r && ny < y_r && map[nx][ny] != 1) {
//                dfs_filled(nx, ny, x_r, y_r);
//            }
//        }
//    }

    public static void dfs(int x, int y) {
        map[x][y] = 1;
        cnt++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != 1) {
                dfs(nx, ny);
            }
        }
    }
}
