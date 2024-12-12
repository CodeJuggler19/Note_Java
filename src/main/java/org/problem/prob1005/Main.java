package org.problem.prob1005;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] times = new int[N + 1];
            int[][] parents = new int[N + 1][2];
            List<List<Integer>> list = new ArrayList<>();

            list.add(new ArrayList<>());
            // memo 시간 입력
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                times[j] = Integer.parseInt(st.nextToken());
                list.add(new ArrayList<>());
            }

            // memo 연결 관계 입력
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                parents[end][0]++;
                list.get(start).add(end);
            }

            int goal = Integer.parseInt(br.readLine());

            List<Integer> starts = new ArrayList<>();

            // memo 시작 지점 찾기
            for (int j = 1; j <= N; j++) {
                if (parents[j][0] == 0) {
                    starts.add(j);
                    parents[j][1] = times[j];
                }
            }

            Queue<Integer> q = new LinkedList<>();
            for(int start : starts){
                q.add(start);
            }

            while (!q.isEmpty()) {
                int current = q.poll();

                if (current == goal) {
                    break;
                }

                for (int node : list.get(current)) {
                    parents[node][0]--;
                    if (parents[node][0] == 0) {
                        q.add(node);
                    }
                    parents[node][1] = Math.max(parents[node][1], parents[current][1] + times[node]);
                }
            }


            bw.write(parents[goal][1] + "\n");


        }

        bw.flush();
        bw.close();
        br.close();

    }
}
