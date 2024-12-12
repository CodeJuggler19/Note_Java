package org.test.computer;

import java.util.HashMap;
import java.util.Map;

public class temp {
    public static void main(String[] args) {
        Map<Integer, String> instructionMap = new HashMap<>();
        instructionMap.put(1, "ADDI NM ZERO 0");
        instructionMap.put(2, "ADDI NP ZERO 10");
        instructionMap.put(3, "ADDI CNM NM 8");
        instructionMap.put(4, "LDUR DCN CNM");
        instructionMap.put(5, "ADD CNP NP DCN");
        instructionMap.put(6, "STOR CNP ZERO");

        instructionMap.put(7, "ADDI MIN ZERO 262143");
        instructionMap.put(8, "ADDI CNT ZERO 0");
        instructionMap.put(9, "ADD CNP NP DCN");
        instructionMap.put(10, "changeMSB CNP 1");
        instructionMap.put(11, "LDURC NPD CNP");
        instructionMap.put(12, "ADD BNP NPD ZERO");

        instructionMap.put(13, "LDURB CAL DCN CNT");
        instructionMap.put(14, "BEQ CAL ZERO 27");
        instructionMap.put(15, "ADD CNP NP CNT");

        instructionMap.put(16, "LDURC NPD CNP");
        instructionMap.put(17, "ADD CAL NPD CAL");
        instructionMap.put(18, "BEQ NPD ZERO 60");

        instructionMap.put(19, "SLT NPD CAL NPD");
        instructionMap.put(20, "STORC CNP NPD");
        instructionMap.put(21, "ADDI TMP ZERO 1");
        instructionMap.put(22, "BEQ bc TMP 27");


        instructionMap.put(60, "ADD NPD NPD CAL");
        instructionMap.put(61, "JUMP 19");



        instructionMap.put(23, "ADD TMP MIN ZERO");
        instructionMap.put(24, "SLT MIN NPD MIN");
        instructionMap.put(25, "BEQ MIN TMP 27");
        instructionMap.put(26, "ADDI NNO CNT 0");

        instructionMap.put(27, "ADDI CNT CNT 1");
        instructionMap.put(28, "ADDI TMP ZERO 8");
        instructionMap.put(29, "BEQ CNT TMP 31");
        instructionMap.put(30, "JUMP 13");

        instructionMap.put(31, "BEQ NNO DCN 34");
        instructionMap.put(32, "ADDI DCN NNO 0");
        instructionMap.put(33, "JUMP 7");
        instructionMap.put(34, "END");

    }
}
