package org.problem.prob2056;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[] degree = new int[n + 1];
        int[] time = new int[n + 1];
        int[] cTime = new int[n + 1];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            degree[i] = cnt;
            for (int j = 0; j < cnt; j++) {
                int parent = Integer.parseInt(st.nextToken());
                graph.get(parent).add(i);
            }

        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                q.add(i);
                cTime[i] = time[i];
            }
        }

        while (!q.isEmpty()) {
            int current = q.poll();

            for (Integer next : graph.get(current)) {
                degree[next]--;
                cTime[next] = Math.max(cTime[next], cTime[current] + time[next]);
                if(degree[next] == 0){
                    q.add(next);
                }
            }
        }
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, cTime[i]);
        }
        System.out.println(result);
    }
}
