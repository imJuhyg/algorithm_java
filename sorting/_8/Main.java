package sorting._8;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

// *[Programmers]가장 큰 수(compareTo)
public class Main {
    public static void main(String[] args) throws IOException {
        String answer = solution(new int[] {3, 30, 34, 5, 9});
        System.out.println(answer);
    }

    public static String solution(int[] numbers) {
        Integer[] copy = Arrays.stream(numbers).boxed().toArray(Integer[]::new);

        // 붙이고/반대로 붙였을 때 더 큰거 찾기  
        Arrays.sort(copy, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Integer a = Integer.parseInt(o1.toString() + o2.toString());
                Integer b = Integer.parseInt(o2.toString() + o1.toString());

                /**
                 * Object.compareTo(o)
                 * 앞의 값이 더 크면 양수(1), 작으면 음수(-1) 반환
                 */
                return -a.compareTo(b);
                // 오름차순 출력시 음수 리턴
            }
        });
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<copy.length; i++) {
            if(answer.length() == 0 && copy[0] == 0) continue;
            answer.append(copy[i]);
        }
        if(answer.length() == 0) answer.append(0);


        return answer.toString();
    }
}
