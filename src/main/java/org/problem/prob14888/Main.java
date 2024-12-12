package org.problem.prob14888;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static int[] numbers;   // 주어진 숫자 배열
    static int[] operators; // 덧셈, 뺄셈, 곱셈, 나눗셈의 개수를 저장하는 배열
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 첫 번째 입력: N개의 수열
        N = sc.nextInt();
        numbers = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            numbers[i] = sc.nextInt();
        }
        // 두 번째 입력: 연산자의 개수
        operators = new int[4]; // 덧셈, 뺄셈, 곱셈, 나눗셈
        for (int i = 0; i < 4; i++) {
            operators[i] = sc.nextInt();
        }
        cal(numbers[1],1, operators );

        System.out.println(max);
        System.out.println(min);


    }

    static void cal(int value, int current, int[] op) {
        if (op[0] + op[1] + op[2] + op[3] == 0 || current >= N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (op[i] != 0) {
                if (i == 0) {
                    cal(value + numbers[current + 1], current + 1, new int[]{op[0] - 1, op[1], op[2], op[3]});
                } else if (i == 1) {
                    cal(value - numbers[current + 1], current + 1, new int[]{op[0], op[1] - 1, op[2], op[3]});
                } else if (i == 2) {
                    cal(value * numbers[current + 1], current + 1, new int[]{op[0], op[1], op[2] - 1, op[3]});
                } else {
                    cal(value / numbers[current + 1], current + 1, new int[]{op[0], op[1], op[2], op[3] - 1});
                }
            }
        }

    }
}