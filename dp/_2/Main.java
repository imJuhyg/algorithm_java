package dp._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 줄서기(COS Pro 1급)
/**
 * 학생들이 줄을 설 때 혼자 서거나, 짝지어 서는 방법이 있다.
 * 한 반의 학생수를 N 이라고 할 때, N명이 모두 줄을 서는 방법의 수는 몇 가지인가? (3 <= N <= 35)
 * 예시) N=4일 경우, ---- / =-- / -=- / --= / == (총 다섯 가지)
 */
public class Main {
    static int[] D = new int[36];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // D[N] = 총 N 명이 혼자 서거나 짝지어 서는 경우의 수
        // D[N] = D[N-1] + D[N-2] (N-1명이 혼자 서거나 짝지어 서는 경우의 수 + N-2명이 혼자 서거나 짝지어 서는 경우의 수)

        int N = Integer.parseInt(br.readLine());
        int answer = solution(N);

        System.out.println(answer);
    }

    public static int solution(int N) {
        // D[1] = 1, D[2] = 2, ...
        if(N <= 2) return N;

        D[N] = solution(N-1) + solution(N-2);

        return D[N];
    }
}
