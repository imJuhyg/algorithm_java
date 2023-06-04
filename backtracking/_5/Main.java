package backtracking._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 최대점수 구하기(Backtracking DFS)
public class Main {
    static int M;
    static int max = Integer.MIN_VALUE; // answer
    static class Question {
        int score;
        int time;

        public Question(int score, int time) {
            this.score = score;
            this.time = time;
        }

        @Override
        public String toString() {
            return "(Score: " + score + ", time: " + time + ")";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 문제 수
        M = Integer.parseInt(input[1]); // 제한 시간
        ArrayList<Question> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            String[] input2 = br.readLine().split(" ");
            int score = Integer.parseInt(input2[0]);
            int time = Integer.parseInt(input2[1]);
            list.add(new Question(score, time));
        }
        Backtracking(list, 0, new ArrayList<>());
        System.out.println(max);
    }

    static void Backtracking(ArrayList<Question> list, int pos, ArrayList<Question> result) {
        int sScore = 0;
        int sTime = 0;
        /**
         * 제한 시간(M)이 초과된 경우 직전까지의 점수 합을 저장한다.
         */
        for(Question q : result) {
            sScore += q.score;
            sTime += q.time;
            if(sTime > M) {
                sScore -= q.score;
                max = Math.max(max, sScore);
                return;
            }
        }

        // 모든 조합에 대해 제한 시간이 초과되지 않는 경우를 예외 처리한다.
        if(pos == list.size()) {
            max = Math.max(max, sScore);
            return;
        }

        Question next = list.get(pos);
        result.add(next);
        Backtracking(list, pos+1, result);

        result.remove(result.size()-1);
        Backtracking(list, pos+1, result);
    }
}
