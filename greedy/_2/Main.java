package greedy._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// 회의실 배정

/**
설명

한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표를 만들려고 한다.

각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라.

단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.


입력
첫째 줄에 회의의 수 n(1<=n<=100,000)이 주어진다. 둘째 줄부터 n+1 줄까지 각 회의의 정보가 주어지는데

이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 회의시간은 0시부터 시작한다.

회의의 시작시간과 끝나는 시간의 조건은 (시작시간 <= 끝나는 시간)입니다.


출력
첫째 줄에 최대 사용할 수 있는 회의 수를 출력하여라.


예시 입력 1              예시 출력 1

5                       3
1 4
2 3            
3 5
4 6
5 7

예시 입력 2              예시 출력 2

3                       2
3 3
1 3
2 3

*/

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
