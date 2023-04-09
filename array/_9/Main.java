package array._9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 격자판 최대합
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
        int max = 0;
        int sum1, sum2;
        sum1=sum2=0;
        // 대각
        for(int i=0; i<N; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][N-1-i];
        }
        max = Math.max(max, sum1);
        max = Math.max(max, sum2);

        // 행 열
        for(int i=0; i<N; i++) {
            sum1=sum2=0;
            for(int j=0; j<N; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            max = Math.max(max, sum1);
            max = Math.max(max, sum2);
        }

        System.out.println(max);
    }
}
