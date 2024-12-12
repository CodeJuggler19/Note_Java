package org.problem.prob2056;

import java.io.*;
import java.util.*;

public class Try {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[] degree = new int[n + 1];
        int[] time = new int[n + 1];

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
            }
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            for (int i = 0; i < q.size(); i++) {
                int t = q.poll();
                time[t]--;
                if (time[t] == 0) {
                    List<Integer> nodes = graph.get(t);
                    for(Integer node: nodes){
                        degree[node]--;
                        if(degree[node] == 0){
                            q.add(node);
                        }
                    }
                } else {
                    q.add(t);
                }
            }
            cnt++;
        }
        System.out.println(cnt);

    }
}
