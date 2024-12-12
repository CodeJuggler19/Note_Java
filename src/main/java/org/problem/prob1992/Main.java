package org.problem.prob1992;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        // 영상의 크기 입력
        int N = Integer.parseInt(br.readLine());

        // 영상의 픽셀 입력
        String[] stArray = new String[N];
        for (int i = 0; i < N; i++) {
            stArray[i] = sc.nextLine();
        }

        String[][] array = new String[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = String.valueOf(stArray[i].charAt(j));
            }
        }
        if (N == 1) {
            System.out.println("(" + array[0][0] + ")");
        } else {
            System.out.println("(" + pixel(array, N) + ")");
        }

    }

    private static String pixel(String[][] array, int N) {
        if (N == 2) {
            return array[0][0] + array[0][1] + array[1][0] + array[1][1];
        } else {
            String[][] temp = new String[N / 2][N / 2];
            int count_row = 0;
            int count_col = 0;
            for (int i = 0; i < N; i += 2) {
                for (int j = 0; j < N; j += 2) {
                    if (array[i][j].equals(array[i + 1][j])
                            && array[i][j].equals(array[i][j + 1])
                            && array[i][j].equals(array[i + 1][j + 1])
                    ) {
                        if (j + 1 == N - 1) {
                            temp[count_col++][count_row] = array[i][j];
                            count_row = 0;
                        } else {
                            temp[count_col][count_row++] = array[i][j];
                        }
                    } else {
                        if (array[i][j].length() != 1) {
                            array[i][j] = "(" + array[i][j] + ")";
                        }
                        if (array[i + 1][j].length() != 1) {
                            array[i + 1][j] = "(" + array[i + 1][j] + ")";
                        }
                        if (array[i][j + 1].length() != 1) {
                            array[i][j + 1] = "(" + array[i][j + 1] + ")";
                        }
                        if (array[i + 1][j + 1].length() != 1) {
                            array[i + 1][j + 1] = "(" + array[i + 1][j + 1] + ")";
                        }

                        if (j + 1 == N - 1) {
                            temp[count_col++][count_row] = "(" + array[i][j] + array[i][j + 1] + array[i + 1][j] + array[i + 1][j + 1] + ")";
                            count_row = 0;
                        } else {
                            temp[count_col][count_row++] = "(" + array[i][j] + array[i][j + 1] + array[i + 1][j] + array[i + 1][j + 1] + ")";
                        }
                    }
                }
            }
            return pixel(temp, N / 2);
        }
    }
}