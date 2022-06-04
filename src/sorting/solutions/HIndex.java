package sorting.solutions;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class HIndex {
    public static void main(String[] args) {

    }
    public int hIndex(int[] citations){
        Arrays.sort(citations);

        for(int i=0; i<citations.length; i++){
            if(citations[i] >= citations.length-i) return citations.length-i;
        }

        return 0;
    }
}
