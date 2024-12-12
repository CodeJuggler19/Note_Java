package org.problem.prob7795;

import java.util.*;
import java.io.*;

public class Main {

    static int result;
    static int[] a;
    static int[] b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a_size = Integer.parseInt(st.nextToken());
            int b_size = Integer.parseInt(st.nextToken());

            a = new int[a_size + 1];
            b = new int[b_size + 1];

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= a_size; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= b_size; j++) {
                b[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(a);
            Arrays.sort(b);
            for (int j = 0; j < a.length; j++) {
                eat(1, b_size, a[j]);
            }
            System.out.println(result);
        }
    }

    static void eat(int start, int end, int a) {
        if (start == end) {
            if (b[start] < a) result++;
            return;
        }
        if(start +1 == end){
            if(b[start] < a) result++;
            if(b[end] < a) result++;
            return;
        }
//        if(start> end){
//            return;
//        }
        int mid = (start + end) / 2;

        if (b[mid] < a) {
            result += mid - start + 1;
            eat(mid + 1, end, a);
        } else {
            eat(start, mid - 1, a);
        }

    }
}
