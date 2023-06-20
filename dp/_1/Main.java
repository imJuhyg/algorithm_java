package dp._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 계단오르기
public class Main {
    static int[] D = new int[36];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 계단을 오르는 방법: +1, +2
        // D[N] = 한 번에 한 계단 또는 두 계단을 올라서 N계단 까지 가는 방법의 수
        // D[N] = D[N-1] + D[N-2]: 두 계단 전의 경우의 수 + 한 계단 전의 경우의 수

        int N = Integer.parseInt(br.readLine());

        int answer = topDown(N);
        System.out.println(answer);
        bottomUp(N);
        System.out.println(D[N]);
    }

    static int topDown(int N) {
        // D[1] = 1, D[2] = 1+1, 0+2 = 2, ...
        if(N <= 2) return N;

        D[N] = topDown(N-1) + topDown(N-2);

        return D[N];
    }

    static void bottomUp(int N) {
        D[1] = 1;
        D[2] = 2;

        for(int i=3; i<=N; i++) {
            D[i] = D[i-1] + D[i-2];
        }
    }
}
