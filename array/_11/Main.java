package array._11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ** 임시반장 정하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][6];
        for(int i=1; i<=N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=1; j<=5; j++) {
                arr[i][j] = Integer.parseInt(input[j-1]);
            }
        }

        int answer = 0;
        int max = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++) { // i: 학생 번호
            int cnt = 0;
            for(int j=1; j<=N; j++) { // j: 비교 학생 번호
                for(int k=1; k<=5; k++) { // 학년
                    if(arr[i][k] == arr[j][k]) {
                        cnt++;
                        break; // 이미 한 번 같은 반이었다면 더이상 점수를 주지 않는다.
                    }
                }
            }
            if(cnt > max) {
                max = cnt;
                answer = i;
            }
        }

        System.out.println(answer);
    }
}
