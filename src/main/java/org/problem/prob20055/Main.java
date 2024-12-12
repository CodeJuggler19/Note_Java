package org.problem.prob20055;

import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] belt = new int[2 * n + 1];
        boolean[] robot = new boolean[n + 1];
        for (int i = 1; i < n; i++) {
            robot[i] = false;
        }
        for (int i = 1; i <= 2 * n; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }
        int lv = 1;
        while (true) {
            // 1. 회전
            int temp = belt[2 * n];
            for (int i = 2 * n; i > 1; i--) {
                belt[i] = belt[i - 1];
            }
            belt[1] = temp;
            for (int i = n - 1; i > 1; i--) {
                robot[i] = robot[i - 1];
            }
            robot[1] = false;
            robot[n] = false;
            // 2. 로봇 이동
            for (int i = n - 1; i >= 1; i--) {
                if (belt[i + 1] > 0 && robot[i] && !robot[i+1]) {
                    belt[i + 1]--;
                    robot[i] = false;
                    if (i != (n - 1)) {
                        robot[i + 1] = true;
                    }
                    if (belt[i + 1] == 0) {
                        k--;
                    }
                }
            }
            // 3. 로봇 올리기
            if (belt[1] > 0) {
                robot[1] = true;
                belt[1]--;
                if (belt[1] == 0) {
                    k--;
                }
            }
            if (k > 0) {
                lv++;
            } else {
                System.out.println(lv);
                break;
            }
        }
    }
}
