package org.problem.prob2470;

import java.util.*;
import java.io.*;

public class Main {
    static int[] num;
    static int result = Integer.MAX_VALUE;

    static int n;
    static int a = 0;
    static int b = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        num[0] = Integer.MIN_VALUE;
        Arrays.sort(num);
        // 모두 같은 부호 일 때
        if (num[1] >= 0 && num[n] > 0) {
            System.out.println(num[1] + " " + num[2]);
        } else if (num[1] <= 0 && num[n] < 0) {
            System.out.println(num[n - 1] + " " + num[n]);
        } else {
            // 이분 탐색 동작
            for (int i = 1; i <= n / 2; i++) {
                sort_2(num[i], 1, n, Integer.MAX_VALUE);
            }
        }

        if(a  < b){
            System.out.println(a + " " + b);
        }else{
            System.out.println(b + " " + a);
        }

    }

    static void sort_2(int target, int s, int e, int before) {
        int middle = s + e / 2;

        if (s + 1 == e || s == e  || middle + 2 > n) {
            if (Math.abs(target + num[s]) > Math.abs(target + num[e])) s = e;
            if (Math.abs(target + num[s]) <= result) {
                result = Math.abs(target + num[s]);
                a = target;
                b = num[s];
            }
            return;
        }


        int add = 1;
        if (num[middle] == target) {
            middle -= 1;
            add += 1;
        }
        boolean check = true;
        if (Math.abs(target + num[middle]) > Math.abs(target + num[middle + add])) {
            middle += add;
            check = false;
        }

        if (Math.abs(target + num[middle]) < before) {
            if (check) {
                sort_2(target, s, middle, Math.abs(target + num[middle]));
            } else {
                sort_2(target, middle, e, Math.abs(target + num[middle]));
            }
        } else {
            if (Math.abs(target + num[middle]) <= result) {
                result = Math.abs(target + num[middle]);
                a = target;
                b = num[middle];
            }
        }


    }

}
