package two_pointers._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// 학급 회장(해쉬)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : input.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int max = Integer.MIN_VALUE;
        char answer = 'a';
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() > max) {
                max = entry.getValue();
                answer = entry.getKey();
            }
        }
        System.out.println(answer);
    }
}
