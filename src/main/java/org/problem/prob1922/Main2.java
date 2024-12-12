package org.problem.prob1922;

import java.io.*;
import java.util.*;

public class Main2 {
    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge e){
            return this.weight - e.weight;
        }
    }
    static List<Edge> edgeList;

    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int M = Integer.parseInt(br.readLine());

        StringTokenizer st;

        edgeList = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(start, end, weight));
        }

        Collections.sort(edgeList);

        parent = new int[N + 1];
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }

        int result = 0;
        for(int i = 0; i < edgeList.size(); i++){
            Edge edge = edgeList.get(i);

            if(find(edge.start) != find(edge.end)){
                result += edge.weight;
                union(edge.start, edge.end);
            }

        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int find(int x){
        if(x == parent[x]) return x;

//        return parent[x] = find(parent[x]);
        return find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x != y){
            parent[y] = x;
        }
    }
}
