package org.problem.prob15686;

import java.util.*;
import java.io.*;

public class Main {
    static int M;
    static List<Node> chickens = new ArrayList<>();

    static List<Node> houses = new ArrayList<>();

    static boolean[] visited;

    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) houses.add(new Node(i, j));
                if(map[i][j] == 2) chickens.add(new Node(i, j));
            }
        }
        combination(new ArrayList<>(), 0);
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
    // memo 가게 선택 로직

    static void combination(List<Node> selected, int start) {
        if (selected.size() == M) {
            System.out.println("선택된 치킨집들:");
            for (Node chicken : selected) {
                System.out.println("치킨집 좌표: (" + chicken.r + ", " + chicken.c + ")");
            }
            find(selected);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected.add(chickens.get(i));
            combination(selected, i + 1);
            selected.remove(selected.size() - 1);
        }
    }

    static void find(List<Node> selected){
        int sum = 0;
        for(Node house : houses){
            int temp = Integer.MAX_VALUE;
            for(Node chickens : selected){
                int distance = Math.abs(house.r - chickens.r)
                        + Math.abs(house.c - chickens.c);
                if(distance < temp){
                    temp = distance;
                }
            }
            sum += temp;
        }
        if(sum < result){
            result = sum;
        }
    }

    static class Node{
        int r;
        int c;

        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
