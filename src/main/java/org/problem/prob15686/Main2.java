package org.problem.prob15686;

import java.util.*;
import java.io.*;

public class Main2 {
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

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
    // memo 가게 선택 로직
    static void combination(List<Node> list, int start){
        if(list.size() == M){
            find();
            return;
        }

        for(int i = start; i < chickens.size(); i++){
            list.add(chickens.get(i));
            combination(list, i);
            list.remove(list.size() -1);
        }
    }


    static void find(){

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