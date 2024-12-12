package org.problem.prob17144;

import java.util.*;
import java.io.*;

public class Answer {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] map = new int[r][c];
        int[][] cleaner = new int[2][2];

        int temp = 0;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    cleaner[temp][0] = i;
                    cleaner[temp][1] = j;
                    temp++;
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};


        while (t-- > 0) {
            int[][] check = new int[r][c];

            // 확산 상태 채크
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (map[i][j] > 0) {
                        check[i][j] = map[i][j];
                    }
                }
            }
            // 확산
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (check[i][j] > 0) {
                        for (int k = 0; k < 4; k++) {
                            int nr = i + dr[k];
                            int nc = j + dc[k];
                            if (nr >= 0 && nr < r && nc >= 0 && nc < c && map[nr][nc] != -1) {
                                map[nr][nc] = map[nr][nc] + check[i][j] / 5;
                                map[i][j] = map[i][j] - (check[i][j] / 5);
                            }
                        }
                    }
                }
            }
            int upper = cleaner[0][0];
            for (int i = upper - 1; i > 0; i--) {
                map[i][0] = map[i - 1][0];
            }
            for (int i = 0; i < c - 1; i++) {
                map[0][i] = map[0][i + 1];
            }
            for (int i = 0; i< upper; i++){
                map[i][c-1] = map[i+1][c-1];
            }
            for(int i = c-1; i>1; i--){
                map[upper][i] = map[upper][i-1];
            }
            map[upper][1] =0;

            int lower = cleaner[1][0];
            for (int j = lower + 1; j < r - 1; j++) {
                map[j][0] = map[j + 1][0];
            }
            for (int j = 0; j < c - 1; j++) {
                map[r - 1][j] = map[r - 1][j + 1];
            }
            for (int j = r - 1; j > lower; j--) {
                map[j][c - 1] = map[j - 1][c - 1];
            }
            for (int j = c - 1; j > 1; j--) {
                map[lower][j] = map[lower][j - 1];
            }
            map[lower][1] = 0;
        }
        int result = 0;

        for(int i=0; i< r; i++){
            for(int j=0; j< c; j++){
                if(map[i][j] != -1){
                    result += map[i][j];
                }
            }
        }
        System.out.println(result);

        br.close();
    }
}

