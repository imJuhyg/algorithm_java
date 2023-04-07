package string._2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 대소문자 변환
public class Main {
    public String solution(String str) {
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()) {
            if(c > 'Z') { // 소 -> 대
                sb.append((char)(c-32));
            } else if(c < 'a') { // 대 -> 소
                sb.append((char)(c+32));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String answer = main.solution(str);

        System.out.println(answer);
    }
}