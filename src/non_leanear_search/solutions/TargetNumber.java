package non_leanear_search.solutions;

public class TargetNumber {
    static int count;

    public static void main(String[] args) {
        TargetNumber t = new TargetNumber();
        int[] numbers = {4, 1, 2, 1};
        System.out.println(t.targetNumbers(numbers, 4));
        System.out.println(t.solution(numbers, 4));

    }

    public int targetNumbers(int[] numbers, int target) {
        counting(numbers, target, 0, 0);
        return count;
    }

    public int counting(int[] numbers, int target, int sum, int depth) {
        if (depth == numbers.length) {
            if (sum == target) count++;
            return count;
        }

        counting(numbers, target, sum + numbers[depth], depth + 1);
        counting(numbers, target, sum - numbers[depth], depth + 1);

        return count;
    }

    public int solution(int[] numbers, int target){
        return sumCount(numbers, target, 0, 0);
    }
    int sumCount(final int[] numbers, final int target, int index, int sum){
        if(index==numbers.length){
            if(sum==target) return 1;
            return 0;
        }

        return sumCount(numbers, target, index+1, sum + numbers[index])
               + sumCount(numbers, target, index+1, sum - numbers[index]);
    }

}
