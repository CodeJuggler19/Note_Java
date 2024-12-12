package org.problem.prob1013;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        String REGEXP_PATTERN = "(100+1+|01)+";

        while(T-- > 0){
            String signal = br.readLine();
            if(signal.matches(REGEXP_PATTERN)){
                bw.write("YES\n");
            }else{
                bw.write("NO\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
