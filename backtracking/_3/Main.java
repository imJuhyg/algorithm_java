package backtracking._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 합이 같은 부분집합(Backtracking DFS) 
// 1. N의 범위가 10이하이므로 조합방식을 이용해본다.
// 2. int selected[11] 배열을 만들고
// 2-1. 0: 예외, 1: 선택당함, 2: 선택안당함
// 3. selected 배열에서 1인 "인덱스"의 합과 2인 "인덱스"의 합이 같은 경우가 존재하면 Yes를 출력한다.
public class Main {
    static String answer = "NO";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] arr = new int[N];
        int[] selected = new int[10000];
        for(int i=0; i<N; i++) {
            int index = Integer.parseInt(input[i]);
            arr[i] = index;
            selected[index] = 2;
        } // 값이 0인 인덱스는 조합 대상에서 제외

        combination(arr, 0, selected);
        System.out.println(answer);
    }

    static void combination(int[] arr, int pos, int[] selected) {
        if(pos == arr.length) { // 모든 선택 완료
            int selectedSum = 0;
            int notSelectedSum = 0;

            for(int i=0; i<selected.length; i++) {
                if(selected[i] != 0) { // 0은 대상에서 제외
                    if(selected[i] == 1 ) selectedSum += i;
                    else notSelectedSum +=  i;
                }
            }

            if(selectedSum == notSelectedSum) answer = "YES";

            return;
        }

        selected[arr[pos]] = 1;     // 선택
        combination(arr, pos+1, selected);
        selected[arr[pos]] = 2;     // 선택안함
        combination(arr, pos+1, selected);
    }
}
