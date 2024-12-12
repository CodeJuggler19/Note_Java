package org.problem.prob14496;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄 입력: 문자 a와 b, 치환 가능한 문자쌍의 수 M
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // M개의 줄에 걸쳐 문자 치환 가능한 문자쌍 입력
        int[][] pairs = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            pairs[i][0] = Integer.parseInt(st.nextToken());
            pairs[i][1] = Integer.parseInt(st.nextToken());
        }
        int answer = answer(a,b,pairs, n);
        if(answer != Integer.MAX_VALUE){
            System.out.println(answer);
        }else{
            System.out.println(-1);
        }

        br.close();
    }

    static int answer(int a, int b, int[][] pairs, int n) {
        List<List<Integer>> nodes = new ArrayList<>();

        //memo node의 정보들을 1-> 2,3,4 이런식으로 저장하기 위한 로직
        for (int i = 0; i <= n; i++) {
            nodes.add(new ArrayList<>());
        }
        //memo 2 -> 3 , 3 -> 2 두 방향 모두 치환이 가능하기 때문에 두개 저장
        for (int i = 0; i < pairs.length; i++) {
            nodes.get(pairs[i][0]).add(pairs[i][1]);
            nodes.get(pairs[i][1]).add(pairs[i][0]);
        }

        int[] costs = new int[n + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(a);
        costs[a] = 0;
        while(!q.isEmpty()){
            int current = q.poll();

            for(Integer node: nodes.get(current)){
                // memo visited를 쓰지 않았는데
                //  이유는 costs(비용 저장하는 배열)을 max로 채워두고 첫 방문시에만 q에 add하게 했기 때문이다.

                if(costs[node] == Integer.MAX_VALUE){
                    q.add(node);
                }
                // memo 딱히 cost에 대한 추가 정보가 없기 때문에 이전 값에 +1을 한다.
                costs[node] = Math.min(costs[node], costs[current] + 1);
            }

        }

        return costs[b];
    }
}

