package array._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// *소수(에라토스테네스의 체)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[N+1];
        arr[0] = true;
        arr[1] = true;

        for(int i=2; i<arr.length; i++) {
            if(arr[i]) continue;
            for(int j=2; i*j<arr.length; j++) {
                arr[i*j] = true; // 소수
            }
        }

        int answer = 0;
        for(boolean b : arr) {
            if(!b) answer++;
        }
        System.out.println(answer);
    }
}
