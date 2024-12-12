package org.study;

import java.io.*;
import java.util.*;

public class UnionFind {
    static int[] parent = {0, 2, 3, 3, 6, 10, 6, 3, 6, 11, 3, 6, 8};
    static int[] node_rank = {0, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1};



    public static void main(String[] args) throws IOException {
//        union_root_optimal(1, 8);
        union_root(1, 8);

        System.out.println(Arrays.toString(parent));
        System.out.println(Arrays.toString(node_rank));

        printTree();
    }

    static int find_root(int x) {
        if (x == parent[x]) return x;

        return find_root(parent[x]);
    }

    static void union_root(int x, int y) {
//        x = find_root(x);
//        y = find_root(y);

        x = find_root_optimal(x);
        y = find_root_optimal(y);

        if (x != y) {
            parent[x] = y;
        }
    }


    static int find_root_optimal(int x){
        if(x == parent[x]) return x;

        //memo 자신 노드를 항상 정점 노드로 설정한다.
        return parent[x] = find_root_optimal(parent[x]);
    }
    static void union_root_optimal(int x, int y) {
//        x = find_root(x);
//        y = find_root(y);
        x = find_root_optimal(x);
        y = find_root_optimal(y);


        if (node_rank[x] < node_rank[y]) {
            parent[x] = y;
        } else if (node_rank[x] > node_rank[y]) {
            parent[y] = x;
        } else {
            parent[y] = x; // y를 x의 자식으로 설정
            node_rank[x]++; // x의 트리 높이를 1 증가
        }
    }

    static void printTree() {
        Map<Integer, List<Integer>> treeMap = new HashMap<>();

        // 각 노드의 자식 노드들을 트리 맵에 저장
        for (int i = 1; i < parent.length; i++) {
            int root = find_root_optimal(i);
            if (root != i) {  // 자기 자신이 루트가 아닌 경우에만 부모 자식 관계 추가
                treeMap.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
            }
        }

        System.out.println("\nTree Structure:");
        // 최상위 루트 노드 찾기
        for (int i = 1; i < parent.length; i++) {
            if (parent[i] == i) { // 루트 노드라면 트리 출력 시작
                printTreeRecursive(i, treeMap, 0);
            }
        }
    }

    // 재귀적으로 트리 구조를 출력하는 함수
    static void printTreeRecursive(int node, Map<Integer, List<Integer>> treeMap, int level) {
        // 들여쓰기를 통해 레벨을 표시
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(node);

        // 자식 노드가 있으면 재귀적으로 출력
        if (treeMap.containsKey(node)) {
            for (int child : treeMap.get(node)) {
                printTreeRecursive(child, treeMap, level + 1);
            }
        }
    }
}
