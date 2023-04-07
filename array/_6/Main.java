package array._6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 뒤집은 소수
public class Main {
    static boolean[] arr = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        setPrimeNumber();
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<input.length; i++) {
            int num = solution(input[i]);
            if(num != 0) answer.append(num).append(" ");
        }
        System.out.println(answer);
    }

    public static void setPrimeNumber() {
        arr[0] = true;
        arr[1] = true;

        for(int i=2; i<arr.length; i++) {
            if(arr[i]) continue;
            for(int j=2; j*i<arr.length; j++) {
                arr[i*j] = true;
            }
        }
    }

    public static int solution(String str) {
        // 뒤집고 소수인지 확인
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        int reversed = Integer.parseInt(sb.toString());

        if(!arr[reversed]) return reversed;
        else return 0;
    }
}
