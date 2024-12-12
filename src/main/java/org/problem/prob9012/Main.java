package org.problem.prob9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static String[] str;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        str = new String[N];

        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
            sb.append(vps(str[i])).append("\n");
        }
        System.out.println(sb);
    }

    private static String vps(String str) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            String temp = String.valueOf(str.charAt(i));

            if (temp.equals("(")) {
                stack.push(temp);
            } else {
                try {
                    stack.pop();
                }catch (Exception e){
                    return "NO";
                }
            }
        }
        if (stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
