package org.problem.prob10799;

import java.io.*;
import java.util.*;

public class Temp {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        String stick = br.readLine();

        Stack<Character> stack = new Stack<>();

        int result = 0;

        for (int i = 0; i < stick.length(); i++) {

            if (stick.charAt(i) == '('){
                stack.push('(');
                continue;
            }
            if (stick.charAt(i) == ')'){
                stack.pop();
                if (stick.charAt(i-1) == '('){
                    result += stack.size();
                }else{
                    result++;
                }

            }

        }
        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
