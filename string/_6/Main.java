package string._6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// *중복문자제거
public class Main {
    public String solution(String input) {
        // indexOf로 찾는 방법: indexOf가 처음으로 발견한 문자의 위치를 반환하는 것을 이용
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<input.length(); i++) {
            if(input.indexOf(input.charAt(i)) == i) sb.append(input.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String answer = main.solution(input);
        System.out.println(answer);
    }
}
