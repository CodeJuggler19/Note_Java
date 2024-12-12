package org.problem.prob18352;

import java.util.*;
import java.io.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // node 개수
        int N = Integer.parseInt(st.nextToken());
        // 간선의 개수
        int M = Integer.parseInt(st.nextToken());
        // 출력할 거리 정보
        int K = Integer.parseInt(st.nextToken());
        // 출발할 도시 번호
        int X = Integer.parseInt(st.nextToken());


        // 각 노드의 비용정보
        int[] costs = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        // 노드간의 연결정보 저장
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list.get(s).add(e);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(X);
        costs[X] = 0;
        while (!q.isEmpty()) {
            int current = q.poll();
            visited[current] = true;
            for (Integer node : list.get(current)) {
                costs[node] = Math.min(costs[node], costs[current] + 1);
                if (!visited[node]) {
                    q.add(node);
                }
            }

        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if(costs[i] == K){
                result.add(i);
            }
        }

        if(result.isEmpty()){
            bw.write(String.valueOf(-1));
        }else{
            for(Integer num : result){
                bw.write(num + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
