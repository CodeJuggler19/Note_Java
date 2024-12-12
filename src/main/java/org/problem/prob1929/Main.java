package org.problem.prob1929;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        boolean[] prime = new boolean[1000001];

        prime[0] = prime[1] = true;

        for (int i = 2; i <= (int)Math.sqrt(1000000); i++) {
            if (prime[i]) {
                continue;
            }
            for (int j = i * i; j < prime.length; j = j + i){
                prime[j] = true;
            }
        }
        for(int i = s; i <= e; i++){
            if(!prime[i]){
                bw.write(i + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
