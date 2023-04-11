package hash._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// 아나그램(해쉬)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String arr1 = br.readLine();
        String arr2 = br.readLine();

        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<arr1.length(); i++) {
            map.put(Character.toString(arr1.charAt(i)), map.getOrDefault(Character.toString(arr1.charAt(i)), 0)+1);
            map.put(Character.toString(arr2.charAt(i)), map.getOrDefault(Character.toString(arr2.charAt(i)), 0)-1);
        }

        boolean isAnswer = true;
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() != 0) {
                System.out.println("NO");
                isAnswer = false;
                break;
            }
        }

        if(isAnswer) System.out.println("YES");

    }
}
