package org.problem.prob10799;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = 0;

        int start = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] string = st.nextToken().toCharArray();
        for (int i = 0; i < string.length; i++) {
            if (string[i] == '(') {
                start++;
            } else if (string[i] == ')') {
                if (string[i - 1] == ')') {
                    result += 1;
                    start--;
                } else {
                    start--;
                    result += start;
                }
            }
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
