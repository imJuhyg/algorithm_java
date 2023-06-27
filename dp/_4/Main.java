package dp._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// *동전교환(Knapsack problem)
// 1. 거슬러줄 금액 M의 길이만큼 배열을 만들고 0을 제외한 모든 원소에 최대값을 저장한다.
// 2. 거스름돈의 가장 적은 동전 단위부터 시작하여 그 돈으로 거슬러줄 수 있는 동전의 수를 배열에 기록한다.
// 3. 최종적으로 D[M]의 값은 이전에 거슬러줬던 금액의 최소 동전 갯수 + 1이 된다.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] coins = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            coins[i] = Integer.parseInt(input[i]);  // 동전의 종류
        }
        int M = Integer.parseInt(br.readLine());    // 거슬러줄 금액
        int[] D = new int[M+1];
        Arrays.fill(D, 1, D.length, Integer.MAX_VALUE);

        for(int coin : coins) {                     // coin: 동전의 종류
            for(int i=coin; i<=M; i++) {            // i: 거슬러줄 금액(거슬러줄 금액이 거스름돈의 종류보다 작으면 안되기 때문에 i는 coin부터 시작한다.)
                D[i] = Math.min(D[i], D[i - coin] + 1);
                /**
                 * 동전의 종류 coin=2일 때, 거슬러줄 금액 i가 4라면,
                 * D[4] = D[4 - 2] + 1 => 2원을 거슬러줄 때 동전의 갯수(D[2]) + '2원'(+1)
                 * = D[2] = D[2 - 2] + 1 => 0원을 거슬러 줄 때 동전의 갯수(D[0]) + '2원'(+1)
                 * = D[0] = 0
                 * 재귀적으로 다시 거슬러 올라가면 D[2] = 0+1, D[4] = 1+1 = 2원이 된다.
                 */
            }
        }
        // System.out.println(Arrays.toString(D));
        int answer = D[M];
        System.out.println(answer);
    }
}
