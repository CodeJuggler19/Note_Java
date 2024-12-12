package org.problem.prob1316;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄: 단어의 개수 N
        int N = Integer.parseInt(br.readLine());
        int count =0;
        // N개의 단어를 입력받음
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
            if(isGroup(words[i])){
                count++;
            }
        }
        System.out.println(count);

    }

    public static boolean isGroup(String word) {
        boolean[] a = new boolean[26];
        char pword =' ';
        for (int i = 0; i <word.length() ; i++) {
            char cword= word.charAt(i);
            if (cword != pword){
                if(a[cword - 'a']){
                    return false;
                }
                a[cword-'a'] = true;
            }
            pword = cword;
        }
    return true;
    }
}
