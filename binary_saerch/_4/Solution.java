package binary_saerch._4;

import java.util.Arrays;

// *입국심사
/**
 * 1. mid를 모든 사람이 심사를 받는데 걸리는 시간의 최소값이라고 가정
 * 2. times 배열을 순차적으로 돌면서 각 심사관당 심사한 사람의 수(sum) += mid/time
 * 3. sum이 n을 넘었으면 정답 후보가 될 수 있다. => 최소값을 찾기 위해 간격을 좁힌다.(end = mid-1)
 * 3-1. sum이 n을 넘지못했으면 정답이 될 수 없다. => 정답 후보를 찾기 위해 간격을 넓힌다.(start = mid+1)
 */
public class Solution {
    public static void main(String[] args) {
        Solution t = new Solution();
        int n = 6;
        int[] times = {7, 10};

        long answer = t.solution(n, times);
        System.out.println(answer);
    }

    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        Arrays.sort(times);

        // 범위 지정
        long start = times[0];
        long end = (long)times[times.length-1]*n; // 최악의 경우: 모든 사람이 가장 오래걸리는 심사대에서 기다리는 경우

        while(start <= end) {
            long mid = (start+end)/2;
            long sum = 0;

            for(int time : times) {
                sum += mid/time;
            }

            if(sum >= n) {
                answer = Math.min(answer, mid);
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }

        return answer;
    }
}
