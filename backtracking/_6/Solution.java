package backtracking._6;

// 타겟넘버(백트래킹 DFS)
public class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        backtracking(numbers, 0, 0, target);

        return answer;
    }

    public void backtracking(int[] arr, int pos, int sum, int target) {
        if(pos == arr.length) {
            if(sum == target) answer++;
            return;
        }

        /**
         * 타겟넘버를 만들수 있는 방법
         * 더하거나 / 빼거나
         */

        // 더하고
        sum += arr[pos];
        backtracking(arr, pos+1, sum, target);
        // 돌아와서
        sum -= arr[pos];
        // 빼고
        sum -= arr[pos];
        backtracking(arr, pos+1, sum, target);
    }

    public static void main(String[] args) {
        Solution t = new Solution();
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        int answer = t.solution(numbers, target);
        System.out.println(answer);
    }
}
