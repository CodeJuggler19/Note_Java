package org.problem.prob10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄: 명령어의 수 N
        int N = Integer.parseInt(br.readLine());

        stack = new Stack<>();
        // N개의 명령어 입력
        String[] commands = new String[N];
        for (int i = 0; i < N; i++) {
            commands[i] = br.readLine();
            doCommand(commands[i]);
        }
    }
    public static void doCommand(String command) {
        if ("pop".equals(command)) {
            if (!stack.isEmpty()) {
                System.out.println(stack.pop());
            } else {
                System.out.println(-1);
            }
        } else if ("size".equals(command)) {
            System.out.println(stack.size());
        } else if ("empty".equals(command)) {
            System.out.println(stack.empty() ? 1 : 0);
        } else if ("top".equals(command)) {
            if (!stack.isEmpty()) {
                System.out.println(stack.peek());
            } else {
                System.out.println(-1);
            }
        } else if (command.startsWith("push")) {
            // "push X"에서 X 추출
            int num = Integer.parseInt(command.split(" ")[1]);
            stack.push(num);
        }
    }
}
