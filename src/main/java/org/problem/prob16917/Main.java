package org.problem.prob16917;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        //앙념 치킨 가격
        int a = Integer.parseInt(st.nextToken());
        //후라이드 치킨 가격
        int b = Integer.parseInt(st.nextToken());
        //반반 치킨 가격
        int c = Integer.parseInt(st.nextToken());

        // 양념치킨 최소 개수
        int x = Integer.parseInt(st.nextToken());
        // 후라이드 최소 개수
        int y = Integer.parseInt(st.nextToken());

        int sum = 0;
        int cnt = Math.min(x, y);

        if (a + b > 2 * c) {
            sum = 2 * c * cnt;
        } else {
            sum = (a + b) * cnt;
        }

        if (cnt == x) {
            cnt = y - cnt;
            sum += Math.min(cnt * b, 2 * c * cnt);
        } else {
            cnt = x - cnt;
            sum += Math.min(cnt * a, 2 * c * cnt);
        }

        System.out.println(sum);
    }
}
