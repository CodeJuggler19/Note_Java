package org.AdventOfCode.prob2;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int result = 0;

        while (true) {
            try {
                st = new StringTokenizer(br.readLine());
                int before = Integer.parseInt(st.nextToken());
                int increase = 2;
                int current = Integer.parseInt(st.nextToken());
                if(before > current && (before - current) <= 3){
                    increase = 0;
                }else if(before < current && (current - before) <= 3){
                    increase = 1;
                }
                if(increase == 2){
                    continue;
                }
                before = current;
                boolean check = true;
                while(st.hasMoreTokens()){
                    current = Integer.parseInt(st.nextToken());

                    if(increase == 0){
                        if(before > current && (before - current) <= 3){
                            before = current;
                        }else{
                            check = false;
                            break;
                        }
                    }else{
                        if(before < current && (current - before) <= 3){
                            before = current;
                        }else{
                            check = false;
                            break;
                        }
                    }
                }
                if(check){
                    result ++;
                }

            } catch (Exception e) {
                break;
            }
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }



}
