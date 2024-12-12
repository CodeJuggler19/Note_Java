package org.problem.prob9020;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[10001];
        prime[0] = prime[1] = true;
        for(int i = 2; i < Math.sqrt(10000); i++){
            if(prime[i]){
                continue;
            }
            for(int j = i * i; j < prime.length; j = j + i){
                prime[j] = true;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 2; i < prime.length; i++){
            if(!prime[i]){
                list.add(i);
            }
        }
        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());
            int temp = N / 2;

            int lower = 0;
            int upper = 0;
            for(int i = 0; i < list.size() - 1; i++){
                if(list.get(i) <= temp && list.get(i+1) > temp){
                    lower = i;
                    upper = i;
                    break;
                }
            }

            while(true){
                int sum = list.get(lower) + list.get(upper);
                if(sum == N){
                    break;
                }else if(sum < N){
                    upper++;
                }else{ // memo sum > N
                    lower--;
                }
            }



            bw.write(list.get(lower) + " " + list.get(upper) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
