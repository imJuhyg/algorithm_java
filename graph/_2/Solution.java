package graph._2;

import java.util.*;

// [Programmers]네트워크(DFS)
// 1. 0번 노드부터 N번 노드까지 순차적으로 탐색
// 1-1. 탐색이 가능한 노드면 answer+1
// 2. n번 노드에서 부터 갈 수 있는 곳 까지 모두 탐색하고 방문한 노드는 visited 배열에 추가
// 3. 처음으로 되돌아와서 다음노드를 탐색하는데, 해당 노드가 이미 방문했던 적이 있다면 스킵
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<computers.length; i++) {
            if(visited[i]) continue;
            stack.push(i);
            answer++;

            while(!stack.isEmpty()) {
                int node = stack.pop();
                for(int j=0; j<computers[node].length; j++) {
                    if(node != j && computers[node][j] == 1) { // 자기자신으로 가는 경우 제외, 갈 수 있으면
                        if(visited[j]) continue;
                        stack.push(j);
                        visited[j] = true;
                    }
                }
            }
        }

        return answer;
    }
}