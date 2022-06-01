package set.solutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NoRepeatedNumber {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};

        System.out.println(Arrays.toString(noRepeatedNumberCheck(arr)));
        System.out.println(Arrays.toString(solution(arr)));
    }

    static int[] noRepeatedNumberCheck(int[] arr) {
        //연속해서 같은 숫자가 나온다면 하나만 남기기
        List<Integer> list = new LinkedList<>();
        for(int i=0; i<arr.length-1; i++){
            if(arr[i]!=arr[i+1]) list.add(arr[i]);
        }
        list.add(arr[arr.length-1]);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    static int[] solution(int[] arr){
        List<Integer> list = new LinkedList<>();

        int last = -1; //임의의 값 지정 (배열 원소 범위: 0~9)

        for(int a : arr){
            if(last==a) continue;

            //전의 값과 배열의 원소 값이 같지 않을 때 list에 add
            last = a;
            list.add(a);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
