package dp._7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// *최대 부분 증가수열
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int D[] = new int[N]; // D[i] = arr[i]값을 마지막으로 하는 부분 증가수열의 최대값
        D[0] = 1; // 가장 처음 수(arr[0])은 반드시 답이 1이다.
        int answer = 1;

        for(int i=1; i<N; i++) {
            int max = 0;
            for(int j=i-1; j>=0; j--) {
                if(arr[i] > arr[j] && D[j] > max) max = D[j];
            }
            D[i] = max+1;
            answer = Math.max(answer, D[i]);
        }
        System.out.println(answer);
    }
}
