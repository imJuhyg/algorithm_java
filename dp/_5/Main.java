package dp._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// *최대점수 구하기(Knapsack problem) - 중복으로 담을 수 없는 문제
// 같은 문제를 또 풀 수는 없기 때문에 점화식 D[M] = D[i - time] + score 를 M부터 시작하여 ime 까지 순회해야한다.
public class Main {
    static class Problems {
        int score;
        int time;

        public Problems(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int D[] = new int[M+1]; // D[M] = M분 안에 풀 수 있는 문제의 최대 점수
        Problems[] problems = new Problems[N];
        for(int i=0; i<N; i++) {
            String[] input2 = br.readLine().split(" ");
            int score = Integer.parseInt(input2[0]);
            int time = Integer.parseInt(input2[1]);
            problems[i] = new Problems(score, time);
        }

        for(Problems problem : problems) {
            for(int i=M; i>=problem.time; i--) {
                D[i] = Math.max(D[i], D[i - problem.time] + problem.score);
                // 이전에 풀었던 문제들은 모두 다른 문제들이다.
            }
        }

        int answer = D[M];
        System.out.println(answer);
    }
}
