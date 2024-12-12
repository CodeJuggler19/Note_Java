package org.softeer.염기서열;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<String> dnaSequences = new ArrayList<>();
    static int minSetSize = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // DNA 염기서열 입력 받기
        for (int i = 0; i < N; i++) {
            dnaSequences.add(br.readLine());
        }

        // 비트마스크로 모든 부분 집합 탐색
        for (int mask = 1; mask < (1 << N); mask++) {
            if (coversAllSequences(mask)) {
                minSetSize = Math.min(minSetSize, Integer.bitCount(mask));
            }
        }

        System.out.println(minSetSize);
    }

    // 비트마스크로 표현된 조합이 모든 DNA 염기서열을 덮을 수 있는지 확인하는 함수
    static boolean coversAllSequences(int mask) {
        boolean[] covered = new boolean[N];

        // 선택된 초기 서열로 다른 모든 염기서열을 덮을 수 있는지 확인
        for (int i = 0; i < N; i++) {
            if ((mask & (1 << i)) != 0) {  // i번째 초기 서열이 선택된 경우
                for (int j = 0; j < N; j++) {
                    if (matches(dnaSequences.get(i), dnaSequences.get(j))) {
                        covered[j] = true;
                    }
                }
            }
        }

        // 모든 염기서열이 덮였는지 확인
        for (boolean c : covered) {
            if (!c) return false;
        }
        return true;
    }

    // 두 염기서열이 덮을 수 있는지 확인하는 함수
    static boolean matches(String s1, String s2) {
        for (int i = 0; i < M; i++) {
            if (s1.charAt(i) != '.' && s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
