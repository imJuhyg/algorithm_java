package binary_saerch._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// **공유기 설치(2110)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        int C = Integer.parseInt(input1[1]);
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // ==============
        Arrays.sort(arr);

        int start = 1;               // 최소거리 1
        int end = arr[N-1] - arr[0]; // 최대 거리 = 가장 먼 집 사이의 거리
        int answer = 0;
        while(start <= end) {
            int mid = (start+end)/2; // 정답 후보: 공유기가 설치된 가장 인접한 두 집사이의 최대 거리
            int count = 1;
            int x = arr[0]; // 첫 번째 집을 기준으로
            for(int i=1; i<N; i++) {
                if(arr[i] - x >= mid) { // 공유기가 설치된 두 집 사이의 거리 측정
                    count++;
                    x = arr[i];
                }
            }

            if(count >= C) { // 현재 mid 값이 정답이 될 수 있다.
                start = mid+1;
                answer = Math.max(answer, mid);
            }
            else {
                end = mid-1;
            }
        }
        System.out.println(answer);
    }
}
