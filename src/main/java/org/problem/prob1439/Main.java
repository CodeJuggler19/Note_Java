package org.problem.prob1439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder(br.readLine());
        char before = sb.charAt(0);

        int count = 0;

        for (int i = 1; i < sb.length(); i++) {
            if (before != sb.charAt(i)) {
                before = sb.charAt(i);
                count++;
            }
        }
        System.out.println((count / 2) + (count % 2));
    }
}

// 10         1/2 0 + 1  = 1
// 101        2/2 1 + 0  = 1
// 1010       3/2 1 + 1  = 2
// 10101      4/2 2 + 0  = 2
// 101010     5/2 2 + 1  = 3
// 1010101    6/2 3 + 0  = 3
// 10101010   7/2 3 + 1  = 4
// 101010101  8/2 4 + 0  = 4
