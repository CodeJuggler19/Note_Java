package org.problem.prob1916;

import java.io.*;
import java.util.*;

public class Try {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<Node>> graph = new ArrayList<>();

        StringTokenizer st;

        int[] costs = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            costs[i] = Integer.MAX_VALUE;
        }

        int[] visited = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            visited[end]++;
            graph.get(start).add(new Node(end, cost));
        }
        Queue<Integer> q = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        costs[start] = 0;
        q.add(start);

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int i = 0; i < graph.get(current).size(); i++) {
                costs[graph.get(current).get(i).getEnd()]
                        = Math.min(costs[graph.get(current).get(i).getEnd()],
                        costs[current] + graph.get(current).get(i).getCost());
                visited[end]--;
                if(visited[end] > 0){
                    q.add(graph.get(current).get(i).getEnd());
                }
            }
        }
        System.out.println(costs[end]);
    }

    public static class Node {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        public int getEnd() {
            return end;
        }

        public int getCost() {
            return cost;
        }
    }
}
