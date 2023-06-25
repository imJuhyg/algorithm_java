package dp._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 돌다리 건너기
public class Main {
    static int[] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // D[N] = 한칸뛰기 + 두칸뛰기
        // ex) N=4일때 N=2지점에서 올 수 있는 경우의 수 + N=3지점에서 올 수 있는 경우의 수
        // D[N] = D[N-1] + D[N-2]
        // 단, 문제의 정답은 개울을 건너는 방법의 수라고 했으므로 답은 D[N+1]을 구해야한다.

        int N = Integer.parseInt(br.readLine());
        D = new int[N+2];
        D[1] = 1;
        D[2] = 2;

        solution(N+1);
        System.out.println(D[N+1]);
    }

    static int solution(int N) {
        if(D[N] > 0) return D[N];
        D[N] = solution(N-1) + solution(N-2);

        return D[N];
    }
}
