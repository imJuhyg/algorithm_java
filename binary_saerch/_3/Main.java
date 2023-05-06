package binary_saerch._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// *마구간 정하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);
        String[] input2 = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }

        Arrays.sort(arr);
        int answer = 0;
        int lt = arr[0];
        int rt = arr[N-1];

        while(lt <= rt) {
            int mid = (lt+rt)/2; // 말 사이의 거리
            int count = 1;
            int start = arr[0];

            for(int i=1; i<N; i++) {
                int dis = arr[i]-start;
                if(dis >= mid) {
                    count++;        // 말 놓기
                    start = arr[i]; // 현재 위치에서 다음 좌표까지의 거리 계산을 위해
                }
            }

            if(count >= C) { // 말을 C개 이상 놓으면 mid(말 사이 거리)를 좁힌다.
                lt = mid+1;
                answer = mid;
            }
            else {          // 말을 C개 이상 놓지 못하면 mid를 좁힌다.
                rt = mid-1;
            }
        }
        System.out.println(answer);
    }
}