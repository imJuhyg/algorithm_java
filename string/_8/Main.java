package string._8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 유효한 팰린드롬
public class Main {
    public String solution(String input) {
        input = input.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(char c : input.toCharArray()) {
            if(Character.isAlphabetic(c)) sb.append(c);
        }

        for(int i=0; i<sb.length(); i++) {
            if(sb.charAt(i) != sb.charAt(sb.length()-1-i)) return "NO";
        }

        return "YES";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main main = new Main();
        String input = br.readLine();

        String answer = main.solution(input);
        System.out.println(answer);
    }
}
