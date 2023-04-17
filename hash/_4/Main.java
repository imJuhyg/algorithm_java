package hash._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// 모든 아나그램 찾기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int answer = 0;
        for(int i=0; i<T.length(); i++) {
            map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0)+1);
        }
        answer += check(map, T);

        for(int end=T.length(); end<S.length(); end++) {
            map.put(S.charAt(end), map.getOrDefault(S.charAt(end), 0)+1);
            map.put(S.charAt(start), map.get(S.charAt(start))-1);
            if(map.get(S.charAt(start)) <= 0) map.remove(S.charAt(start));
            start++;
            answer += check(map, T);
        }
        System.out.println(answer);
    }

    static int check(HashMap<Character, Integer> _map, String T) {
        HashMap<Character, Integer> map = new HashMap<>(_map);
        for(char c : T.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)-1);
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() != 0) {
                return 0;
            }
        }

        return 1;
    }
}