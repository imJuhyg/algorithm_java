package stack_queue._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 쇠막대기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int stick = 0;
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(char c : input.toCharArray()) {
            if(c == '(') {
                stick++;
                stack.push(c);
            }
            else if(c == ')') {
                if(stack.peek() == '(') {
                    stick--;
                    answer += stick;
                }
                else {
                    stick--;
                    answer++;
                }
                stack.push(c);
            }
        }
        System.out.println(answer);
    }
}
