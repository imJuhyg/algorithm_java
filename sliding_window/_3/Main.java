package sliding_window._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// *연속된 자연수의 합
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int m = N/2+1;
        int[] arr = new int[m]; // N 절반의 자연수 만으로도 모든 경우수를 만들 수 있음
        for(int i=0; i<arr.length; i++) {
            arr[i] = i+1;
        }

        int answer = 0;
        int sum = 0;
        int start = 0;
        for(int end=0; end<m; end++) {
            sum += arr[end]; // end 값을 증가시키면서 sum에 더한다.
            if(sum == N) answer++;
            while(sum >= N) { // 만약 sum이 m보다 커지면 start를 늘리면서 sum 값을 뺀다.
                sum -= arr[start++];
                if(sum == N) answer++;
            }
        }
        System.out.println(answer);
    }
}
