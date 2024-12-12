package org.problem.prob1091;

import java.io.*;
import java.util.*;

public class Main {
    static int[] S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        StringTokenizer st_2;
        st = new StringTokenizer(br.readLine());
        st_2 = new StringTokenizer(br.readLine());

        int[] P = new int[N];
        S = new int[N];

        List<Set<Integer>> pCard = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            pCard.add(new HashSet<>());
        }

        int[] card = new int[N];

        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
            pCard.get(P[i]).add(i);
            S[i] = Integer.parseInt(st_2.nextToken());
            card[i] = i;
        }
        int cnt = 0;

//        for (int i = 0; i < 3 ; i++) {
//            System.out.println(pCard.get(i));
//        }
//
//        Set<Integer> test = pCard.get(0);
//        test.remove(3);
//
//        for (int i = 0; i < 3 ; i++) {
//            System.out.println(pCard.get(i));
//        }

        // memo 안되는 경우 순서가 0~ N 다시 돌아올 경우
        while (true) {
            boolean check = true;
            for (int i = 0; i < 3; i++) {
                Set<Integer> temp = pCard.get(i);
                for (int j = 0; i + j * 3 < N; j++) {  // 조건 추가
                    if (!temp.contains(card[i + j * 3])) {
                        check = false;
                        break;
                    }
                }
            }

            if (check) {
                break;
            } else {
                card = swap(card);
                cnt++;
            }


            int sameCheck = 0;
            for (int i = 0; i < N; i++) {
                if (card[i] == i) {
                    sameCheck++;
                }
            }
            if (sameCheck == N) {
                bw.write(-1 + "");
                bw.flush();
                return;
            }
        }
        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static int[] swap(int[] card) {
        int[] result = new int[card.length];

        for (int i = 0; i < card.length; i++) {
            result[S[i]] = card[i];
        }
        return result;
    }
}
