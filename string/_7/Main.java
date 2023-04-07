package string._7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 회문 문자열
public class Main {
    public String solution(String input) {
        input = input.toLowerCase();
        for(int i=0; i<input.length()/2; i++) {
            if(input.charAt(i) != input.charAt(input.length()-1-i)) return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String answer = main.solution(input);
        System.out.println(answer);
    }
}