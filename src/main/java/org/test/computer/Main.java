package org.test.computer;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static String[][] inputMem = new String[8][8]; // 0 ~ 7
    static String start = "0000"; // 8
    static String end; // memo 일단 보류
    static String[] npMem = new String[8]; // 10 ~ 17
    static String NM;
    static String CNM;
    static String NP;
    static String CNP;
    static String DCN;
    static String MIN;
    static String CNT;
    static String DEN;
    static String CAL;
    static String NPD;
    static String TMP;
    static String bc;
    static String BNP;
    static String ZERO = "00000000000000000000000000000000";
    static String NNO;
    static boolean check = true;
    static int jumpNum = 0;
    static void functionGenerator(String instruction){
        String[] parts = instruction.split(" ");

        if(parts[0].equals("changeMSB")){
            changeMSB(parts[1], Integer.parseInt(parts[2]));
        }else if(parts[0].equals("LDUR")){
            LDUR(parts[1], parts[2]);
        }else if(parts[0].equals("LDURC")){
            LDURC(parts[1], parts[2]);
        }else if(parts[0].equals("STOR")){
            STOR(parts[1], parts[2]);
        }else if(parts[0].equals("STORC")){
            STORC(parts[1], parts[2]);
        }else if(parts[0].equals("ADD")){
            ADD(parts[1], parts[2], parts[3]);
        }else if(parts[0].equals("LDURB")){
            LDURB(parts[1], parts[2], parts[3]);
        }else if(parts[0].equals("SLT")){
            SLT(parts[1], parts[2], parts[3]);
        }else if(parts[0].equals("ADDI")){
            ADDI(parts[1], parts[2], Integer.parseInt(parts[3]));
        }else if(parts[0].equals("BEQ")){
            BEQ(parts[1], parts[2], Integer.parseInt(parts[3]));
        }else if(parts[0].equals("JUMP")){
            JUMP(Integer.parseInt(parts[1]));
        }else{
            check =false;
            System.out.println("존재하지 않은 Opfunc");
        }

    }
    public static void main(String[] args) {
        // memo  초기 NP 배열 값 전부 무한대로 초기화
        Arrays.fill(npMem, "00000000000000000000000000000000");
        // memo case 1
        int[][] values = {
                {0, 3, 4, 0, 0, 0, 0, 0},   // Node 0r
                {3, 0, 5, 10, 0, 9, 0, 0},  // Node 1
                {4, 5, 0, 8, 5, 0, 0, 0},   // Node 2
                {0, 10, 8, 0, 6, 10, 7, 3}, // Node 3
                {0, 0, 5, 6, 0, 0, 4, 0},   // Node 4
                {0, 9, 0, 10, 0, 0, 2, 2},  // Node 5
                {0, 0, 0, 7, 4, 0, 0, 5},   // Node 6
                {0, 0, 0, 3, 0, 2, 6, 0}    // Node 7
        };
        // memo case 2
//        int[][] values = {
//                {0, 5, 0, 0, 9, 0, 0, 8},   // Node 0
//                {5, 0, 12, 15, 0, 0, 0, 4},  // Node 1
//                {0, 12, 0, 3, 0, 1, 11, 7},   // Node 2
//                {0, 15, 3, 0, 0,0, 9, 0}, // Node 3
//                {9, 0, 0, 0, 0, 4, 15, 5},   // Node 4
//                {0, 0, 1, 0, 4, 0, 13, 6},  // Node 5
//                {0, 0, 11, 9, 15, 13, 0, 0},   // Node 6
//                {8, 4, 7, 0, 5, 6, 0, 0}    // Node 7
//        };

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // 값을 4비트 2진수 문자열로 변환
                inputMem[i][j] = String.format("%4s", Integer.toBinaryString(values[i][j]))
                        .replace(' ', '0'); // 빈 공간을 0으로 채움
            }
        }
        System.out.println("inputMem = " + Arrays.deepToString(inputMem));

        // memo init
//        ADDI("NM", "ZERO", 0);
//        ADDI("NP", "ZERO", 10);
//        ADDI("CNM", "NM", 8);
//        LDUR("DCN", "CNM");
//        ADD("CNP", "NP", "DCN");
//        STOR("CNP", "ZERO");
//        // 시작 노드의 방문처리
//        changeMSB("CNP", 1);
//
//        //memo Dijkstra
//        ADDI("MIN", "ZERO", 262143);
//        ADDI("CNT", "ZERO", 0);
//        ADD("CNP", "NP", "DCN");
//        LDUR("NPD", "CNP");
//        ADD("BNP", "NPD", "ZERO");
//        changeMSB("CNP", 1);
//
//        LDURB("CAL", "CNM", "CNT");
//        BEQ("CAL", "ZERO", 23);
//        ADD("CNP", "NP", "CNT");
//        LDURC("NPD", "CNP");
//        ADD("CAL", "BNP", "CAL");
//        SLT("NPD", "CAL", "NPD");
//        STORC("CNP", "NPD");
//
//        // memo MIN 설정
//        ADDI("TMP", "ZERO", 1);
//        BEQ("bc", "TMP", 23);
//        LDUR("TMP", "MIN");
//        SLT("MIN", "NPD", "MIN");
//        BEQ("MIN", "TMP", 23);
//        ADDI("DCN", "CNT",0);
//
//        ADDI("CNT", "CNT", 1);
//        ADDI("TMP", "ZERO", 8);
//        BEQ("CNT", "TMP", 27);
//        JUMP(10);

        Map<Integer, String> instructionMap = new HashMap<>();
        // memo init
        instructionMap.put(1, "ADDI NM ZERO 0");
        instructionMap.put(2, "ADDI NP ZERO 10");
        instructionMap.put(3, "ADDI CNM NM 8");
        instructionMap.put(4, "LDUR DCN CNM");
        instructionMap.put(5, "ADD CNP NP DCN");
        instructionMap.put(6, "STOR CNP ZERO");

        instructionMap.put(7, "ADDI MIN ZERO 262143");
        instructionMap.put(8, "ADDI CNT ZERO 0");
        instructionMap.put(9, "ADD CNP NP DCN");


        instructionMap.put(10, "LDURC NPD CNP");
        instructionMap.put(11, "ADD BNP NPD ZERO");
        instructionMap.put(12, "changeMSB CNP 1");


        instructionMap.put(13, "LDURB CAL DCN CNT");
        instructionMap.put(14, "BEQ CAL ZERO 29");
        instructionMap.put(15, "ADD CNP NP CNT");
        instructionMap.put(16, "LDURC NPD CNP");

        instructionMap.put(17, "ADDI TMP ZERO 1");
        instructionMap.put(18, "BEQ bc TMP 29");
        instructionMap.put(19, "ADD CAL BNP CAL");
        instructionMap.put(20, "BEQ NPD ZERO 60");

        instructionMap.put(21, "SLT NPD CAL NPD");
        instructionMap.put(22, "STORC CNP NPD");
        instructionMap.put(23, "ADDI TMP ZERO 1");
        instructionMap.put(24, "BEQ bc TMP 29");


        instructionMap.put(60, "ADD NPD NPD CAL");
        instructionMap.put(61, "JUMP 21");

        instructionMap.put(25, "ADD TMP MIN ZERO");
        instructionMap.put(26, "SLT MIN NPD MIN");
        instructionMap.put(27, "BEQ MIN TMP 29");
        instructionMap.put(28, "ADDI NNO CNT 0");

        instructionMap.put(29, "ADDI CNT CNT 1");
        instructionMap.put(30, "ADDI TMP ZERO 8");
        instructionMap.put(31, "BEQ CNT TMP 33");
        instructionMap.put(32, "JUMP 13");

        instructionMap.put(33, "BEQ NNO DCN 36");
        instructionMap.put(34, "ADDI DCN NNO 0");
        instructionMap.put(35, "JUMP 7");
        instructionMap.put(36, "END");

        int num = 1;
        while(check){
            functionGenerator(instructionMap.get(num));
//            if(num == 8){
//                System.out.println("number 8 check");
//                System.out.println("DCN : " + DCN);
//                System.out.println("NNO : " + NNO);
//            }
//            if(num == 24){
//                System.out.println("number 24 check");
//                System.out.println("MIN : " + MIN);
//
//            }
//            System.out.println(instructionMap.get(num));
//            System.out.println("bc = " + bc);
//            System.out.println("CAL = " + CAL);
//            System.out.println("TMP = " + TMP);
//            System.out.println("NPD = " + NPD);
//            System.out.println("MIN = " + MIN);
//            System.out.println("CNT = " + CNT);
//            System.out.println("NNO = " + NNO);
//            System.out.println("DCN = " + DCN);
            if(jumpNum == 0){
                num ++;
            }else{
                num = jumpNum;
                jumpNum = 0;
            }
            if(!check){
                break;
            }
        }
        System.out.println(Arrays.toString(npMem));
    }


    // memo inst에 추가해야할듯
    static void changeMSB(String rd, int value){
        int addr = Integer.parseInt(getRegValue(rd), 2);
        String result = null;
        if(addr  < 8){
            // todo inputMem 여기서는 필요 없음 사실
            result = "";
        }else if(addr >= 10){
            // npMem
            result = npMem[addr - 10];
        }else if(addr == 8){
            result = start;
        }

        if(value == 1){
            result = '1' + result.substring(1);
        }else{
            result = '0' + result.substring(1);
        }

        int intAddr = Integer.parseInt(getRegValue(rd),2);
        if (intAddr < 8) { // memo input 데이터 저장하는건데 사실 쓸모 없을듯
            // 저장 로직
        } else if (intAddr >= 10) { //
            npMem[intAddr - 10] = result;
        }

    }
    static void LDUR(String rd, String rs) {
        int addr = Integer.parseInt(getRegValue(rs), 2);
        String result = null;
        if(addr  < 8){
            // todo inputMem 여기서는 필요 없음 사실
            result = "";
        }else if(addr >= 10){
            // npMem
            result = npMem[addr - 10];
        }else if(addr == 8){
            result = start;
        }
        putRegValue(rd, result);
    }

    static void LDURC(String rd, String rs) {
        int addr = Integer.parseInt(getRegValue(rs), 2);

        String value = null;
        if(addr  < 8){
            // todo inputMem 여기서는 필요 없음 사실
            value = "";
        }else if(addr >= 10){
            // npMem
            value = npMem[addr - 10];
        }else if(addr == 8){
            value = start;
        }

//        //todo 전부 111 ~ 로 해놨기 떄문에 0으로 한번 바꿔줘야함
//        if(value.equals("11111111111111111111111111111111")){
//            value = "00000000000000000000000000000000";
//            //todo 문제는 처음에 1111~로 저장되는데 그러면 불러 올때 문제가 되고
//            // 000~ 으로 하게되면 SLT에서 NPD = 000~ CAL = 값 이기 때문에 최소가 업데이트가 안된다.
//        }

        char msb = value.charAt(0);
        String result;
        if(msb == '1'){
            bc = "1";
            result = '0' + value.substring(1);
        }else{
            bc = "0";
            result = value;
        }
        putRegValue(rd, result);
    }

    static void STOR(String rs, String rt) {
        // memo rs 는 mem.dest
        String addr = getRegValue(rs);
        String value = getRegValue(rt);
        int intAddr = Integer.parseInt(addr,2);
        if (intAddr < 8) { // memo input 데이터 저장하는건데 사실 쓸모 없을듯
            // 저장 로직
        } else if (intAddr >= 10) { //
            npMem[intAddr - 10] = value;
        }
    }

    static void STORC(String rs, String rt) {
        // memo rs 는 mem.dest
        String binary = getRegValue(rt);
        String result = "";
        if (bc.equals("1")) {
            result = '1' + binary.substring(1);
        }else{
            result = binary;
        }

        String addr = getRegValue(rs);
        int intAddr = Integer.parseInt(addr,2);
        if (intAddr < 8) { // memo input 데이터 저장하는건데 사실 쓸모 없을듯
            // 저장 로직
        } else if (intAddr >= 10) { //
            npMem[intAddr - 10] = result;
        }
    }

    static void ADD(String rd, String rs, String rt) {
        int rsValue = Integer.parseInt(getRegValue(rs), 2);
        int rtValue = Integer.parseInt(getRegValue(rt), 2);
        String result = String.format("%32s",Integer.toBinaryString(rsValue + rtValue)) .replace(" ", "0");
//        String result = Integer.toBinaryString(rsValue + rtValue);
        putRegValue(rd, result);
    }

    static void LDURB(String rd, String rs, String rt) {
        String index = getRegValue(rt);
        String addr = getRegValue(rs);
        putRegValue(rd, inputMem[Integer.parseInt(addr, 2)][Integer.parseInt(index, 2)]);
    }

    static void SLT(String rd, String rs, String rt) {
        int rsValue = Integer.parseInt(getRegValue(rs), 2);
        int rtValue = Integer.parseInt(getRegValue(rt), 2);
        int minValue = Math.min(rsValue, rtValue);
        putRegValue(rd,String.format("%32s",Integer.toBinaryString(minValue)) .replace(" ", "0"));
//        putRegValue(rd,Integer.toBinaryString(minValue));
    }

    static void ADDI(String rd, String rs, int immediate) {
        int value = Integer.parseInt(getRegValue(rs),2) + immediate;
        putRegValue(rd, String.format("%32s",Integer.toBinaryString(value)) .replace(" ", "0"));
//        putRegValue(rd, Integer.toBinaryString(value));
    }

    static void BEQ(String rd, String rs, int jta) {
        int rdValue = Integer.parseInt(getRegValue(rd), 2);
        int rtValue = Integer.parseInt(getRegValue(rs), 2);
        if (rdValue == rtValue) {
            // memo 여기서 점프 -> inst 짜면서 생각해보자
            jumpNum = jta;
        }
    }

    static void JUMP(int jta) {
        // todo 점프 로직을 어떻게 하지?
        jumpNum = jta;
    }

    static void putRegValue(String regName, String value) {
        if ("NM".equals(regName)) {
            NM = value;
        } else if ("CNM".equals(regName)) {
            CNM = value;
        } else if ("NP".equals(regName)) {
            NP = value;
        } else if ("CNP".equals(regName)) {
            CNP = value;
        } else if ("DCN".equals(regName)) {
            DCN = value;
        } else if ("MIN".equals(regName)) {
            MIN = value;
        } else if ("CNT".equals(regName)) {
            CNT = value;
        } else if ("DEN".equals(regName)) {
            DEN = value;
        } else if ("CAL".equals(regName)) {
            CAL = value;
        } else if ("NPD".equals(regName)) {
            NPD = value;
        } else if ("TMP".equals(regName)) {
            TMP = value;
        } else if ("bc".equals(regName)) {
            bc = value;
        }else if("BNP".equals(regName)){
            BNP = value;
        } else if("NNO".equals(regName)){
            NNO = value;
        }
        else {
            System.out.println("Register name not found: " + regName);
        }
    }

    static String getRegValue(String regName) {
        if ("NM".equals(regName)) {
            return NM;
        } else if ("CNM".equals(regName)) {
            return CNM;
        } else if ("NP".equals(regName)) {
            return NP;
        } else if ("CNP".equals(regName)) {
            return CNP;
        } else if ("DCN".equals(regName)) {
            return DCN;
        } else if ("MIN".equals(regName)) {
            return MIN;
        } else if ("CNT".equals(regName)) {
            return CNT;
        } else if ("DEN".equals(regName)) {
            return DEN;
        } else if ("CAL".equals(regName)) {
            return CAL;
        } else if ("NPD".equals(regName)) {
            return NPD;
        } else if ("TMP".equals(regName)) {
            return TMP;
        } else if ("bc".equals(regName)) {
            return bc;
        } else if ("ZERO".equals(regName)) {
            return ZERO;
        } else if ("BNP".equals(regName)) {
            return BNP;
        }else if ("NNO".equals(regName)) {
            return NNO;
        } else {
            throw new IllegalArgumentException("Register name not found: " + regName);
        }
    }

}
