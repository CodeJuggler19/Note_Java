package org.problem.prob1920;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1920 - 수 찾기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] A_array = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A_array[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());

        Arrays.sort(A_array);

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int value = Integer.parseInt(st.nextToken());
            bw.write(temp(A_array, value) + " ");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static int temp(int[] array, int value) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (value < array[middle]) {
                right = middle - 1;
            } else if (value > array[middle]) {
                left = middle + 1;
            } else {
                return 1;
            }
        }

        return 0;
    }
}
