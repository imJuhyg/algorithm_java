package array._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 피보나치 수열
public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        arr[1] = 1;

        fibo(N);
        StringBuilder answer = new StringBuilder();
        for(int i=1; i<arr.length; i++) {
            answer.append(arr[i]).append(" ");
        }
        System.out.println(answer);
    }

    public static int fibo(int n) {
        if(n <= 1) return n;
        if(arr[n] != 0) return arr[n];
        arr[n] = fibo(n-2) + fibo(n-1);

        return arr[n];
    }
}
