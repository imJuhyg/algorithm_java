package string._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문장 속 단어
public class Main {
    public String solution(String str) {
        String[] arr = str.split(" ");
        int max = 0;
        String answer = "";
        for(String s : arr) {
            if(s.length() > max) {
                max = s.length();
                answer = s;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String answer = main.solution(input);
        System.out.println(answer);
    }
}