package org.problem.prob1916;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<Node>> graph = new ArrayList<>();

        StringTokenizer st;

        boolean[] visited = new boolean[n + 1];
        int[] costs = new int[n + 1];

        Arrays.fill(costs, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, cost));
        }

        PriorityQueue<Node> q = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        costs[start] = 0;

        q.add(new Node(start, 0));
        while (!q.isEmpty()) {
            Node curNode = q.poll();
            int current = curNode.getEnd();
            if (!visited[current]) {
                visited[current] = true;
                for (Node node : graph.get(current)) {
                    if (!visited[node.getEnd()]) {
                        costs[node.getEnd()] =
                                Math.min(costs[node.getEnd()], costs[current] + node.getCost());
                        q.add(new Node(node.getEnd(), costs[node.getEnd()]));
                    }
                }

            }
        }
        System.out.println(costs[end]);
    }

    public static class Node implements Comparable<Node> {
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

        @Override
        public int compareTo(Node node) {
            return cost - node.cost;
        }
    }
}
