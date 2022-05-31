package list_solutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class MaxIndex {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 4, 5, 2, 1};

        int[] result = findMaxIndex(arr);
        System.out.println(Arrays.toString(result));
    }

    //배열 원소 중 최댓값의 인덱스를 찾는 메서드
    public static int[] findMaxIndex(int[] arr) {
        int max=0;

        //최댓값 찾기
        for (int j : arr) {
            if (j > max) max = j;
        }
        //인덱스를 더해 저장할 StringBuilder 객체 선언
        StringBuilder index = new StringBuilder();

        //배열의 원소가 max와 같다면 StringBuilder 클래스에 인덱스를 더해주고 " "로 구분
        for(int i=0; i<arr.length; i++){
            if(arr[i]==max) index.append(i).append(" ");
        }

        //인덱스가 저장된 StringBuilder를 " " 단위로 나눠 String 배열에 저장
        String[] indexArr = index.toString().split(" ");
        int[] answer = new int[indexArr.length];

        //String 배열에서 값을 하나씩 가져와 int로 바꿔 answer 배열에 할당
        for(int i=0; i<indexArr.length; i++){
            answer[i] = Integer.parseInt(indexArr[i]);
        }

        return answer;
    }

    public static int[] solution(int[] arr){
        //최댓값
        int max = 0;
        for(int a : arr) if(a>max) max=a;
        //최댓값 개수 확인
        int count = 0;
        for(int a : arr) if(a==max) count++;
        //배열 만들기
        int[] answer = new int[count];
        //배열에 인덱스 할당
        int index = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]==max) answer[index++]=i;
        }
        return answer;
    }
    public static int[] solution2(int[] arr){
        //최댓값
        int max = 0;
        for(int a : arr) if(a>max) max=a;
        //리스트 생성
        List<Integer> list = new LinkedList<>();
        //리스트에 인덱스 할당
        for(int i=0; i<arr.length; i++){
            if(arr[i]==max) list.add(i);
        }
        //리스트를 배열로 변환
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        //스트림 사용
        //int[] answer = list.stream().mapToInt(Integer :: intValue).toArray();

        return answer;
    }
     public static int[] solution3(int[] arr){
        //최댓값 - 스트림
        int max = Arrays.stream(arr).max().getAsInt();

        //요소가 max 값과 같은 인덱스만 배열로 반환
        return IntStream.range(0, arr.length)
                .filter(i -> arr[i]==max)
                .toArray();
    }

}
