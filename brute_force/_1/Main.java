package brute_force._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// N과 M(Permutation)
public class Main {
    static boolean[] checked;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        checked = new boolean[N+1];
        result = new int[M];

        permutation(0, N, M);
    }

    static void permutation(int pos, int N, int M) {
        if(pos == M) {
            StringBuilder answer = new StringBuilder();
            for(int num : result) {
                answer.append(num).append(" ");
            }
            System.out.println(answer);
            return;
        }

        for(int i=1; i<=N; i++) {
            if(checked[i]) continue;
            result[pos] = i;
            checked[i] = true;
            permutation(pos+1, N, M);
            checked[i] = false;
        }
    }
}
