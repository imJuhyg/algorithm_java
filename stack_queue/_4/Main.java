package stack_queue._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 후위식 연산(postfix)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        Stack<Integer> stack = new Stack<>();

        for(char c : input.toCharArray()) {
            if(c >= '0' && c <= '9') {
                stack.push(c - '0');
            }
            else {
                int item1 = stack.pop();
                int item2 = stack.pop();
                if(c == '+') stack.push(item2 + item1);
                else if(c == '-') stack.push(item2 - item1);
                else if(c == '*') stack.push(item2 * item1);
                else stack.push(item2 / item1);
            }
        }
        System.out.println(stack.peek());
    }
}
