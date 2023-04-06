package string._9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 숫자만 추출
public class Main {
    public String solution(String input) {
        char[] arr = input.toCharArray();
        ArrayList<Integer> list = new ArrayList<>();
        for(char c : arr) {
            if(c >= '0' && c <= '9') {
                list.add(c - '0');
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(int i=0; i<list.size(); i++) {
            if(list.get(i) == 0 && !flag) continue;
            flag = true;
            sb.append(list.get(i));
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
