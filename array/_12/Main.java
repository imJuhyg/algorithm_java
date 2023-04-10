package array._12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// *멘토링
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[][] arr = new int[M][N];
        for(int i=0; i<M; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[][] scores = new int[N+1][N+1];

        // M마다 가능한 짝 조합을 찾는다.
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                for(int k=j+1; k<N; k++) {
                    // 짝 조합을 (행, 열)로 보고 그 위치에 1씩 증가시킨다.
                    scores[arr[i][j]][arr[i][k]] += 1;
                }
            }
        }

        int answer = 0;
        for(int i=0; i<scores.length; i++) {
            for(int j=0; j< scores.length; j++) {
                // 짝 조합이 모든 수학테스트 횟수(M)이면 멘토-멘티 가능
                if(scores[i][j] == M) answer++;
            }
        }

        System.out.println(answer);
    }
}
