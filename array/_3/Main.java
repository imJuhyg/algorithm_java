package array._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 가위 바위 보
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] temp1 = br.readLine().split(" ");
        String[] temp2 = br.readLine().split(" ");
        int[] A = new int[N];
        int[] B = new int[N];

        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(temp1[i]);
            B[i] = Integer.parseInt(temp2[i]);
        }

        for(int i=0; i<N; i++) {
            System.out.println(solution(A[i], B[i]));
        }
    }

    public static String solution(int a, int b) {
        // 1: 가위, 2: 바위, 3: 보
        if(a == b) return "D";
        else if(a == 1 && b == 3) return "A";
        else if(a == 2 && b == 1) return "A";
        else if(a == 3 && b == 2) return "A";
        else return "B";
    }
}
