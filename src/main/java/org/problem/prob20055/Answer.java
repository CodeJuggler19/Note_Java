package org.problem.prob20055;

import java.io.*;
import java.util.*;

public class Answer {
    static int n;
    static int k;
    static int[][] belt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        belt = new int[2 * n + 1][2];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= 2 * n; i++) {
            // 벨트의 내구도
            belt[i][0] = Integer.parseInt(st.nextToken());
            // 벨트 위 로봇의 유무
            belt[i][1] = 0;
        }
        int lv = 1;
        while (true) {

            level_1();
            level_2();
            level_3();
            if (k <= 0) {
                System.out.println(lv);
                break;
            } else {
                lv++;
            }
        }
    }

    public static void level_1() {
        int before_0 = belt[1][0];
        int before_1 = belt[1][1];

        belt[1][0] = belt[2 * n][0];
        belt[1][1] = belt[2 * n][1];
        int after_0, after_1;
        for (int i = 2; i <= 2 * n; i++) {
            if (i == n) {
                after_0 = belt[i][0];
                after_1 = 0;
                belt[i][0] = before_0;
                belt[i][1] = before_1;
                before_0 = after_0;
                before_1 = after_1;
            } else {
                after_0 = belt[i][0];
                after_1 = belt[i][1];
                belt[i][0] = before_0;
                belt[i][1] = before_1;
                before_0 = after_0;
                before_1 = after_1;
            }

        }
    }

    public static void level_2() {
        for (int i = n-1; i >=1; i--) {
            if (belt[i + 1][0] >= 1 && belt[i + 1][1] == 0  && belt[i][1] == 1) {
                belt[i][1] = 0;
                belt[i + 1][1] = 1;
                belt[i + 1][0]--;
                if (belt[i + 1][0] == 0) {
                    k--;
                }
            }

        }
    }

    public static void level_3() {
        if (belt[1][0] != 0) {
            belt[1][1] = 1;
            belt[1][0]--;
            if (belt[1][0] == 0) {
                k--;
            }
        }
    }

}
