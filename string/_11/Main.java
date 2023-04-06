package string._11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// *문자열 압축
public class Main {
    public String solution(String input) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<input.length(); i++) {
            int pointer = i;
            int count = 0;

            // 마지막 요소는 검사 X
            if(i == input.length()-1) {
                sb.append(input.charAt(i));
                break;
            }

            // 옆으로 검사
            while(true) {
                pointer++;
                if(pointer == input.length()) break;
                if(input.charAt(i) == input.charAt(pointer)) {
                    count++;
                    // 비교대상이 마지막이면 끝
                    if(pointer == input.length()-1) {
                        sb.append(input.charAt(i)).append(count+1);
                        i=pointer;
                    }
                }
                else {
                    if(count == 0) sb.append(input.charAt(i));
                    else sb.append(input.charAt(i)).append(count+1);

                    i = pointer-1;
                    break;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main main = new Main();
        String input = br.readLine();
        String answer = main.solution(input);
        System.out.println(answer);
    }
}
