package stack_queue._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 올바른 괄호
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();

        for(char c : input.toCharArray()) {
            if(!stack.isEmpty()) {
                char item = stack.peek();
                if(item == '(' && c == ')') stack.pop();
                else stack.push(c);

            } else {
                stack.push(c);
            }
        }

        if(stack.isEmpty()) System.out.println("YES");
        else System.out.println("NO");
    }
}
