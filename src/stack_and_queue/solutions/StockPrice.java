package stack_and_queue.solutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StockPrice {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(stockPrice(prices)));
    }

    static int[] stockPrice(int[] prices) {
        List<Integer> list = Arrays.stream(prices).boxed().collect(Collectors.toList());
        List<Integer> result = new LinkedList<>();

        //순회
        while(!list.isEmpty()){
            for(int i=0; i<list.size(); i++){
                if(list.get(0)>list.get(i)){
                    result.add(i);
                    list = list.subList(1, list.size());
                    break;
                }
                else if(i==list.size()-1){
                    result.add(list.size()-1);
                    list = list.subList(1, list.size());
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    //배열로 풀기 > 훨씬 간단
    static int[] solution(int[] prices){
        int[] result = new int[prices.length];

        for(int i=0; i<prices.length; i++){
            int price = prices[i];
            int seconds = 0;
            for(int j=i+1; j<prices.length; j++){
                seconds++;
                if(price > prices[j]) break;
            }
            result[i] = seconds;
        }
        return result;
    }
}
