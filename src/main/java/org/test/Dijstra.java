package org.test;

import java.util.*;

public class Dijstra {
    static class Node implements Comparable<Node> {
        int x, y, cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상, 하, 좌, 우
    static int[][] maze = {
            {0, 1, -1, -1, -1, 3},
            {1, -1, 2, -1, -1, -1},
            {4, 5, 6, -1, -1, -1},
            {-1, -1, 2, 7, 8, -1},
            {9, -1, -1, 10, 11, -1}
    };
    static int n = maze.length;
    static int m = maze[0].length;
    static int[][] dist = new int[n][m];

    static int dijkstra(int startX, int startY, int goalX, int goalY) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startX, startY, 0));
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[startX][startY] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.x == goalX && current.y == goalY) {
                return current.cost;
            }

            for (int[] dir : directions) {
                int newX = current.x + dir[0];
                int newY = current.y + dir[1];

                if (newX >= 0 && newX < n && newY >= 0 && newY < m && maze[newX][newY] != -1) {
                    int newCost = current.cost + maze[newX][newY];
                    if (newCost < dist[newX][newY]) {
                        dist[newX][newY] = newCost;
                        pq.add(new Node(newX, newY, newCost));
                    }
                }
            }
        }
        return -1; // 목표에 도달할 수 없는 경우
    }

    public static void main(String[] args) {
        Map<Integer, Integer> temp = new HashMap<>();

        temp.put(1,2);
        temp.put(2,2);
        temp.put(3,2);
        for(Map.Entry<Integer, Integer> map : temp.entrySet()){
            System.out.println(map);
        }

        for(int j=-1; j>=0; j--){
            System.out.println("test");
        }
    }
}