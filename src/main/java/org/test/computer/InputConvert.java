package org.test.computer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class InputConvert {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] list = new int[8][8];
        while(true){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            if(from == 9){
                break;
            }
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[from][to] = cost;

        }

        for(int i = 0; i < 8; i++){
            System.out.print("memory[" + i + "] <= {");
            for(int j = 0; j < 7; j++){
                System.out.print("4'd" + list[i][j] + ", ");
            }
            System.out.print("4'd" + list[i][7] + "}; // node" + i);
            System.out.println();
        }

    }
}
