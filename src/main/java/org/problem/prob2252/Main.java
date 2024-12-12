package org.problem.prob2252;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> students = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            students.add(new ArrayList<>());
        }

        int[] degree = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            students.get(a).add(b);

            degree[b]++;
        }
        Queue<Integer> q = new LinkedList<>();

        // top노드 넣고 시작
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int current = q.poll();
            System.out.print(current + " ");
            for(int next : students.get(current)){
                degree[next] --;
                if(degree[next] ==0){
                    q.add(next);
                }
            }
        }
    }
}
