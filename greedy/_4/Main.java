package greedy._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// **최대 수입 스케쥴
public class Main {
    static class Schedule {
        int M;
        int D;
        public Schedule(int M, int D) {
            this.M = M;
            this.D = D;
        }

        @Override
        public String toString() {
            return String.format("(M: %d, D: %d)\n", M, D);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Schedule> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            String[] temp = br.readLine().split(" ");
            int M = Integer.parseInt(temp[0]);
            int D = Integer.parseInt(temp[1]);
            list.add(new Schedule(M, D));
        }
        list.sort(new Comparator<Schedule>() {
            @Override
            public int compare(Schedule s1, Schedule s2) {
                return s2.D - s1.D;
            }
        });
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());

        int answer = 0;
        int day = list.get(0).D;
        int i = 0;
        while(day > 0) {
            while(i < list.size() && list.get(i).D == day) {
                pQueue.offer(list.get(i).M);
                i++;
            }
            if(!pQueue.isEmpty()) {
                answer += pQueue.poll();
            }
            day--;
        }

        System.out.println(answer);
    }
}
