package org.problem.prob9663;

import java.io.*;

public class Main {

    static int N; // 체스판의 크기 (N x N)
    static int resultCount; // 가능한 퀸 배치의 경우의 수
    static int[] board; // 각 행에 퀸이 놓인 열의 위치를 저장하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 사용자로부터 N 값을 입력받음

        board = new int[N]; // 체스판 배열 초기화

        backTracking(0); // 백트래킹 시작 (0번째 행부터)

        br.close();
        System.out.println("총 경우의 수: " + resultCount); // 가능한 경우의 수 출력
    }

    static void backTracking(int queenCount) {
        if (queenCount == N) {
            resultCount++; // 모든 퀸을 놓았으므로 경우의 수 증가
            printBoard(); // 생성된 경우를 출력
            return;
        }

        for(int i = 0; i < N; i++) {
            board[queenCount] = i; // 현재 행의 i번째 열에 퀸을 놓음

            if (checkQueen(queenCount)) { // 놓을 수 있는 위치인지 검사
                backTracking(queenCount + 1); // 다음 행으로 이동
            }
        }
    }

    static boolean checkQueen(int col){
        for (int i = 0; i < col; i++) {
            if (board[col] == board[i]) {
                return false; // 같은 열에 다른 퀸이 있음
            } else if (Math.abs(col - i) == Math.abs(board[col] - board[i])) {
                return false; // 대각선 상에 다른 퀸이 있음
            }
        }
        return true; // 배치 가능
    }

    // 생성된 경우를 출력하는 메서드 추가
    static void printBoard() {
        for (int i = 0; i < N; i++) {
            // 각 행에 대한 출력
            for (int j = 0; j < N; j++) {
                if (board[i] == j) {
                    System.out.print("Q "); // 퀸이 있는 위치
                } else {
                    System.out.print(". "); // 빈 칸
                }
            }
            System.out.println(); // 다음 행으로 이동
        }
        System.out.println(); // 각 경우 사이에 빈 줄 추가
    }
}
