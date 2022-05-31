package list_solutions;

public class PermutationTest {

    public boolean permutationTest(int[] arr) {
        boolean answer;
        int max = arr[0];

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) return false;
            if (arr[i + 1] > max) max = arr[i + 1];
        }
        if (arr.length != max) answer = false;
        else answer = true;

        return answer;
    }

}
