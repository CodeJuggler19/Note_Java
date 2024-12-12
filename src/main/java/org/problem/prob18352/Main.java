package org.problem.prob18352;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 도시 개수
        int n = Integer.parseInt(st.nextToken());
        // 경로 개수
        int m = Integer.parseInt(st.nextToken());
        // 최단 거리
        int k = Integer.parseInt(st.nextToken());
        // 출발 위치
        int x = Integer.parseInt(st.nextToken());

        int[] len = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            len[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        len[x] = 0;
        visited[x] = true;
        int start;
        int end;

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
        }

        // 각 노드의 거리 계산
        Queue<Integer> q = new LinkedList<>();
        q.add(x);

        while (!q.isEmpty()) {
            int current = q.poll();
            for (int i = 0; i < graph.get(current).size(); i++) {
                if (!visited[graph.get(current).get(i)]) {
                    len[graph.get(current).get(i)] =
                            Math.min(len[graph.get(current).get(i)], len[current] + 1);
                    q.add(graph.get(current).get(i));
                    visited[graph.get(current).get(i)] = true;
                }
            }
        }


        boolean found = false;
        for (int i = 1; i <= n; i++) {
            if (len[i] == k) {
                System.out.println(i);
                found = true;
            }
        }
        if (!found) {
            System.out.println(-1);
        }
    }
}
