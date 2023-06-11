package graph._8;

import java.util.*;

// *단어변환(BFS)
class Solution {
    class Node {
        String word;
        int depth;

        public Node(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }
    public int solution(String begin, String target, String[] words) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(begin, 0));
        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(begin, false);
        for(String word : words) {
            visited.put(word, false);
        }

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.word.equals(target)) return node.depth;

            for(String next : words) {
                if(isChange(node.word, next)) {
                    if(visited.get(next)) continue;
                    visited.put(next, true);

                    queue.offer(new Node(next, node.depth+1));
                }
            }
        }

        return 0;
    }

    public boolean isChange(String begin, String target) {
        char[] beginChar = begin.toCharArray();
        char[] targetChar = target.toCharArray();

        int count = 0;
        for(int i=0; i<beginChar.length; i++) {
            if(beginChar[i] == targetChar[i]) count++;
        }

        return beginChar.length-1 == count;
    }

    public static void main(String[] args) {
        Solution t = new Solution();

        int answer = t.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println(answer);
    }
}
