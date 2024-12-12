package org.problem.prob2231;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] carN = br.readLine().toCharArray();

        int sum = 1;


        for (int i = 0; i < carN.length; i++) {
            if (i == 0) {
                if (carN[i] == 'd') {
                    sum *= 10;
                } else {
                    sum *= 26;
                }
            } else {
                if (carN[i] == carN[i - 1]) {
                    if (carN[i] == 'd') {
                        sum *= 9;
                    } else {
                        sum *= 25;
                    }
                } else {
                    if (carN[i] == 'd') {
                        sum *= 10;
                    } else {
                        sum *= 26;
                    }
                }
            }
        }
        System.out.println(sum);

    }
}
