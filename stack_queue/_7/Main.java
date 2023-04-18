package stack_queue._7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 교육과정 설계
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String input2 = br.readLine();

        Queue<Character> queue = new LinkedList<>();
        for(char c : input.toCharArray()) {
            queue.add(c);
        }

        boolean isAnswer = true;
        for(int i=0; i<input2.length(); i++) {
            if(queue.contains(input2.charAt(i)) && queue.peek() == input2.charAt(i)) {
                queue.poll();
            }
            else if(queue.contains(input2.charAt(i)) && queue.peek() != input2.charAt(i)) {
                isAnswer = false;
                break;
            }
        }
        if(queue.size() != 0) isAnswer = false;

        if(isAnswer) System.out.println("YES");
        else System.out.println("NO");
    }
}
