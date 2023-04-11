package sliding_window._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 연속 부분수열
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        int M = Integer.parseInt(input1[1]);
        String[] input2 = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }

        int start = 0;
        int end = 0;
        int answer = 0;
        while(true) {
            if(end >= N) break;
            int sum = 0;

            for(int i=start; i<=end; i++) { // window 크기만큼 더한다
                sum += arr[i];
            }

            if(sum == M) { // == M 조건을 충족하면 window를 그대로 한 칸 이동한다.
                start++;
                end++;
                answer++;
            }

            else if(sum < M) { // M보다 작으면 윈도우 크기를 늘린다.(오른쪽으로)
                end++;
            }

            else { // M보다 크면 윈도우 크기를 줄인다.(왼쪽을)
                if(end-start == 0) { // 윈도우를 더이상 못줄이면 그대로 옆으로 옮긴다.
                    start++;
                    end++;
                } else {
                    start++;
                }
            }
        }
        System.out.println(answer);
    }
}
