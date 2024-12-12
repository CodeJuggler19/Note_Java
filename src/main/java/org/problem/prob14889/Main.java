//package org.problem.prob14889;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Main {
//    static int[][] S;
//    static int N;
//    static int result = Integer.MAX_VALUE;
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        N = scanner.nextInt();
//
//        S = new int[N + 1][N + 1];
//
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                S[i][j] = scanner.nextInt();
//            }
//        }
//        for (int i = 1; i <= N; i++) {
//            team(i, 0);
//        }
//        System.out.println(result);
//        scanner.close();
//    }
//
//    static void team(ArrayList<Integer> players, int ab) {
//        if (players.size() == N / 2) {
//            int[] check = new int[N];
//            for (int i = 0; i < players.size(); i++) {
//
//            }
//            result = Math.min(result, ab);
//            return;
//        }
//        for (int i = players.get(players.size() - 1) + 1; i <= N; i++) {
//            ArrayList<Integer> newteam = players;
//            newteam.add(i);
//            team(newteam, ab + S[players.get(players.size() - 1)][i]);
//        }
//    }
//}
