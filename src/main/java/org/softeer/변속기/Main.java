package org.softeer.변속기;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[8];
        for (int i = 0; i < 8; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        boolean isAscending = true;
        for(int i=0; i<8; i++){
            if(num[i] != i+1){
                isAscending = false;
            }
        }

        boolean isDscending = true;
        for(int i=0; i<8; i++){
            if(num[i] != 8 - i){
                isDscending = false;
            }
        }

        if(isAscending){
            bw.write("ascending");
        }else if(isDscending){
            bw.write("descending");
        }else{
            bw.write("mixed");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
