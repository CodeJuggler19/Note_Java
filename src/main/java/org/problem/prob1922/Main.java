package org.problem.prob1922;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int M = Integer.parseInt(br.readLine());


        Set<Integer> set = new HashSet<>();

        Queue<Node> q = new PriorityQueue<>();

        List<List<Node>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        int min = Integer.MAX_VALUE;
        int min_a = 0;
        int min_b = 0;
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(cost, end, end));
            list.get(end).add(new Node(cost, start, start));

            if (cost < min) {
                min = cost;
                min_a = start;
                min_b = end;
            }
        }

        q.add(new Node(min, min_a, min_b));

        int cnt = 0;
        int result = 0;

        while (!q.isEmpty() || cnt < N -1) {
            Node current = q.poll();

            // memo 순환되는 것을 찾는 방법 수정 필요
            if (set.contains(current.a) && set.contains(current.b)) {
                continue;
            }
            set.add(current.a);
            set.add(current.b);

            result += current.cost;
            cnt++;

            for (Node node : list.get(current.a)){
                q.add(new Node(node.cost, current.a, node.b));
            }

            for (Node node : list.get(current.b)){
                q.add(new Node(node.cost, current.b, node.a));
            }

        }
        System.out.println(result);

        bw.flush();
        bw.close();
        br.close();

    }
    static class Node implements Comparable<Node> {
        int cost;
        int a;
        int b;

        public Node(int cost, int a, int b) {
            this.cost = cost;
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Node node) {
            return this.cost - node.cost;
        }
    }

}

