package string._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// *특정 문자 뒤집기
public class Main {
    public String solution(String input) {
        StringBuilder answer = new StringBuilder();
        char[] s = input.toCharArray();
        int lt = 0;
        int rt = input.length()-1;

        while(lt < rt) {
            if(!Character.isAlphabetic(s[lt])) { // 알파벳이 아닐 때
                lt++;
            }
            else if(!Character.isAlphabetic(s[rt])) {
                rt--;
            }
            else {
                char temp = s[lt];
                s[lt] = s[rt];
                s[rt] = temp;
                lt++;
                rt--;
            }
        }

        for(char c : s) {
            answer.append(c);
        }
        return answer.toString();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String answer = main.solution(input);
        System.out.println(answer);
    }
}