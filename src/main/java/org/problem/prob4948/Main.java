package org.problem.prob4948;

import java.util.*;
import java.io.*;

public class Main {
    static boolean[] prime;
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        getPrime();

        getCount();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;

            int result = num[2 * n] - num[n];
            bw.write(result + "\n");

        }


        bw.flush();
        bw.close();
        br.close();
    }

    static void getPrime() {
        prime = new boolean[123456 * 2 + 1];
        prime[0] = prime[1] = true;
        for(int i = 2; i < (int) Math.sqrt(123456 * 2); i++){
            if(prime[i]){
                continue;
            }
            for(int j = i * i; j < prime.length; j = j + i){
                prime[j] = true;
            }
        }
    }
    static void getCount() {
        num = new int[123456 * 2 + 1];
        for(int i = 1; i < prime.length; i++ ){
            if(!prime[i]){
                num[i] = num[i-1] + 1;
            }else{
                num[i] = num[i-1];
            }
        }
    }
}
