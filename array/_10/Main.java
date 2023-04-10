package array._10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 봉우리
public class Main {
    static int[] dx = {0, 0, -1, 1}; // 상 하 좌 우
    static int[] dy = {-1, 1, 0, 0};

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

        int count = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                boolean isAnswer = true;
                for(int k=0; k<4; k++) {
                    int nx = j + dx[k];
                    int ny = i + dy[k];

                    // 가장자리
                    if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                    if(arr[ny][nx] >= arr[i][j]) {
                        isAnswer = false;
                        break;
                    }
                }

                if(isAnswer) count++;
            }
        }
        System.out.println(count);
    }
}
