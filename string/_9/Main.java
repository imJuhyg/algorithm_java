package string._9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 숫자만 추출
public class Main {
    public int solution(String input) {
        StringBuilder answer = new StringBuilder();
        for(char c : input.toCharArray()) {
            if(Character.isDigit(c)) answer.append(c);
        }

        return Integer.parseInt(answer.toString());
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int answer = main.solution(input);
        System.out.println(answer);
    }
}
