package backtracking._2;

import java.util.*;

// 메뉴 리뉴얼(2021 KAKAO BLIND RECRUITMENT)
class Solution {
    ArrayList<HashMap<String, Integer>> list;
    int[] max;
    int size; // 조합의 최대 길이

    public String[] solution(String[] orders, int[] course) {
        // 1. ArrayList의 인덱스에는 조합의 길이, Map의 키에는 메뉴의 조합, value는 주문된 메뉴 조합의 갯수
        // 1-1. 메뉴 조합은 최소 두 가지 이상의 메뉴가 들어가야한다.
        // 2. 값이 2 이상인 메뉴 조합만을 선정해야한다.
        // * 조합을 구성할 orders 배열은 정렬되지 않았기 때문에 조합을 만들기전에 오름차순 정렬부터 진행한다.

        size = course[course.length-1]+1;
        list = new ArrayList<>(size);
        max = new int[size];

        for(int i=0; i<size; i++) {
            list.add(new HashMap<>());
        }

        for(int i=0; i<orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            combination(arr, 0, new StringBuilder());
        }

        ArrayList<String> answer = new ArrayList<>();
        for(int i=0; i<course.length; i++) {
            HashMap<String, Integer> map = list.get(course[i]);
            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == max[course[i]] && max[course[i]] >= 2) {
                    answer.add(entry.getKey());
                }
            }
        }
        Collections.sort(answer);
        String[] temp = new String[answer.size()];
        for(int i=0; i<temp.length; i++) {
            temp[i] = answer.get(i);
        }

        return temp;
    }

    void combination(char[] arr, int pos, StringBuilder result) {
        // 조합을 구하고 조합의 길이에 맞게 ArrayList 인덱스에 넣는다.
        // 메뉴 조합의 최대값도 계산한다.

        if(pos == arr.length) {
            int len = result.length();
            if(len >= 2 && len < size) {
                String comb = result.toString(); // 조합
                HashMap<String, Integer> map = list.get(len);
                map.put(comb, map.getOrDefault(comb, 0)+1);
                if(max[len] < map.get(comb)) max[len] = map.get(comb); // 최대값 갱신
            }

            return;
        }

        combination(arr, pos+1, result.append(arr[pos]));
        result.setLength(result.length()-1);
        combination(arr, pos+1, result);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] answer = solution.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2,3,4});
        System.out.println(Arrays.toString(answer));
    }
}