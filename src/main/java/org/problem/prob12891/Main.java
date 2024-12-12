package org.problem.prob12891;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int S = Integer.parseInt(firstLine[0]);
        int P = Integer.parseInt(firstLine[1]);

        String dna = br.readLine();

        int result = 0;
        String[] thirdLine = br.readLine().split(" ");
        int[] minCount = new int[4];
        for (int i = 0; i < 4; i++) {
            minCount[i] = Integer.parseInt(thirdLine[i]);
        }

        result = answer(dna, minCount, S, P);
        System.out.println(result);

        br.close();
    }

    static int answer(String dna, int[] minCount, int S, int P) {
        int result = 0;
        int[] checkCount = new int[4];
        boolean check;
        char before = ' ';
        for (int i = 0; i < S - P + 1; i++) {
            if (i == 0) {
                String checkString = dna.substring(i, i + P);
                checkCount = initCheck(checkString);
                before = checkString.charAt(i);
            } else {
                char after = dna.charAt(i + P - 1);
                checkCount = updateCheck(before, after, checkCount);
                before = dna.charAt(i);
            }
            check = checkString(minCount, checkCount);
            if (check) {
                result++;
            }
        }
        return result;
    }

    static int[] initCheck(String checkString) {
        int[] result = new int[4];
        result[0] = checkString.length() - checkString.replace("A", "").length();
        result[1] = checkString.length() - checkString.replace("C", "").length();
        result[2] = checkString.length() - checkString.replace("G", "").length();
        result[3] = checkString.length() - checkString.replace("T", "").length();
        return result;
    }

    static int[] updateCheck(char before, char after, int[] checkCount) {
        if (before == 'A') {
            checkCount[0]--;
        } else if (before == 'C') {
            checkCount[1]--;
        } else if (before == 'G') {
            checkCount[2]--;
        } else {
            checkCount[3]--;
        }

        if (after == 'A') {
            checkCount[0]++;
        } else if (after == 'C') {
            checkCount[1]++;
        } else if (after == 'G') {
            checkCount[2]++;
        } else {
            checkCount[3]++;
        }
        return checkCount;
    }

    static boolean checkString(int[] minCount, int[] checkCount) {
        if (checkCount[0] < minCount[0]) {
            return false;
        }
        if (checkCount[1] < minCount[1]) {
            return false;
        }
        if (checkCount[2] < minCount[2]) {
            return false;
        }
        if (checkCount[3] < minCount[3]) {
            return false;
        }
        return true;
    }
}