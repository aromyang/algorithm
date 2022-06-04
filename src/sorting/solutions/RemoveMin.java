package sorting.solutions;

import java.util.Arrays;

public class RemoveMin {
    public static void main(String[] args) {

    }
    public int[] removeMinimumNumber(int[] arr){
        if(arr.length<=1) return new int[]{-1};
        int min = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr).filter(i -> i!=min).toArray();
    }
}
