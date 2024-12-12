package org.problem.prob1717;

import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];

        for(int i = 0; i <= n; i++){
            parent[i] = i;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int check = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(check == 0){
                union(x, y);
            }else{ // check == 1
                x = find(x);
                y = find(y);
                if(x == y){
                    bw.write("YES\n");
                }else{
                    bw.write("NO\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int find(int x){
        if(x == parent[x]) return x;

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);

        // 작은 쪽이 무조건 x -> 정점이 되도록
        if(x < y){
            parent[y] = x;
        }else{
            parent[x] = y;
        }
    }
}
