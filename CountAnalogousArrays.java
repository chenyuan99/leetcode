import java.util.Arrays;
import java.util.List;

public class CountAnalogousArrays {

    public static int countAnalogousArrays(List<Integer> consecutiveDifference, int lowerBound, int upperBound) {

        if (consecutiveDifference == null || consecutiveDifference.isEmpty() || upperBound < lowerBound) {
            return 0;
        }
        int count = 0;
        int n = consecutiveDifference.size();
        for (int start = lowerBound; start <= upperBound; start++) {
            // we have n+1 numbers for n differences
            int[] candidate = new int[n + 1];
            // we fix the start
            candidate[0] = start;
            boolean valid = true;
            for (int i = 1; i <= n; i++) {
                int temp = candidate[i - 1] - consecutiveDifference.get(i - 1);
                // check for lower and upper bound
                if (temp < lowerBound || temp > upperBound) {
                    valid = false;
                    break;
                } else {
                    candidate[i] = temp;
                }
            }
            count += valid ? 1 : 0;
        }
        return count;
    }


    public static void main(String[] args){
        List<Integer> l = Arrays.asList(-2, -1, -2, 5);
        System.out.println(countAnalogousArrays(l,3,10));
    }
}

// https://leetcode.com/discuss/interview-question/1332322/amazon-online-assessment-july-2021-secret-array