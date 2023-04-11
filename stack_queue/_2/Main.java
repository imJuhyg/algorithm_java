package stack_queue._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();

        for(char c : input.toCharArray()) {
            if(c == ')') {
                while(true) {
                    if(stack.peek() == '(') {
                        stack.pop();
                        break;
                    }
                    stack.pop();
                }
                continue;
            }
            stack.push(c);
        }
        for(Character c : stack) {
            System.out.print(c);
        }
    }
}
