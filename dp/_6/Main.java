package dp._6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static class Knapsack {
        int w;
        int v;
        public Knapsack(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        int K = Integer.parseInt(input1[1]);

        int[] D = new int[K+1]; // D[K] = K 무게까지 담을 수 있는 물건의 최대 가치
        Knapsack[] knaps = new Knapsack[N];
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            int w = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            knaps[i] = new Knapsack(w, v);
        }

        for(Knapsack knap : knaps) {
            for(int i=K; i>=knap.w; i--) {
                D[i] = Math.max(D[i], D[i - knap.w] + knap.v);
            }
        }
        
        System.out.println(D[K]);
    }
}
