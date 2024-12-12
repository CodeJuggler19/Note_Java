package org.problem.prob10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder(br.readLine());

        int check = 0;
        int result = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                check++;
            } else if (sb.charAt(i) == ')') {
                check--;
                if (sb.charAt(i - 1) == '(') {
                    result += check;
                } else {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}