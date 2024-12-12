package org.problem.prob1629;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int result = A % C;
        Set<Integer> sets = new LinkedHashSet<>();
        result = (result * A) % C;
        while (!sets.contains(result)) {
            sets.add(result);
            result = (result * A) % C;
        }
        if(B < 2){
            bw.write(String.valueOf(A % C));
        }else{
            int target = (B-2) % sets.size();
            int cnt = 0;
            for (Integer set : sets) {
                if(target == cnt){
                    bw.write(String.valueOf(set));
                    break;
                }
                cnt ++;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
