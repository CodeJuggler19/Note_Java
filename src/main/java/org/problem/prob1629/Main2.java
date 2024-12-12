package org.problem.prob1629;

import java.io.*;
import java.util.*;

public class Main2 {
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());


        bw.write(String.valueOf(modulation(A, C, B)));
        bw.flush();
        bw.close();
        br.close();
    }

    static long modulation(long A, long C, long pow) {
        if (pow == 1) {
            return A % C;
        }

        long temp = modulation(A, C, pow / 2);

        if (pow % 2 == 1) {
            return (((temp * temp) % C) * A) % C;
        }

        return (temp * temp) % C;
    }

}
