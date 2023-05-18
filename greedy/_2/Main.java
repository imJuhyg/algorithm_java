package greedy._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// 회의실 배정
public class Main {
    static class Times {
        int s;
        int e;
        public Times(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public String toString() {
            return String.format("(s: %d, e: %d)\n", s, e);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        Times[] times = new Times[N];
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            times[i] = new Times(s, e);
        }

        Arrays.sort(times, new Comparator<Times>() {
            // 회의가 빨리 끝나는 시간 순 정렬
            @Override
            public int compare(Times t1, Times t2) {
                if(t1.e == t2.e) { // 끝나는 시간이 같으면
                    if(t1.e - t1.s < t2.e - t2.s) return -1; // 회의 시간이 짧은 회의를 우선순위로 둔다.
                    else return 1;
                }
                else return t1.e - t2.e;
            }
        });

        int pre = -1; // 이전 회의 종료시간
        for(int i=0; i<N; i++) {
            if(times[i].s == times[i].e) { // 회의 시작시간과 종료시간이 같으면 없는 회의로 치자.
                answer++;
                continue;
            }
            if(pre == -1) {
                answer++;
                pre = times[i].e;
            }
            else {
                if(times[i].s >= pre) {
                    answer ++;
                    pre = times[i].e;
                }
            }
        }

        System.out.println(answer);

        ///System.out.println(Arrays.toString(times));
    }
}
