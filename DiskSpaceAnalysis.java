import java.util.Scanner;

public class DiskSpaceAnalysis {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // Store the length of segment
        int x = sc.nextInt();
        // Store the length of space array
        int n = sc.nextInt();
        // Store the elements of space array
        long space[] = new long[n];
        for (int i = 0; i < n; i++) {
            space[i] = sc.nextLong();
        }
        // The minimal array stores the minimum value of each segment
        long minimal[] = new long[n - x + 1];
        // max stores the max value of minimal array
        long max = Long.MIN_VALUE;
        for (int i = 0; i <= n - x; i++) {
            minimal[i] = Long.MAX_VALUE;
            for (int j = i; j < i + x; j++) {
                // if minimal[i] is greater than space[j] than update minimal to space[j]
                if (minimal[i] > space[j])
                    minimal[i] = space[j];
            }
            // if max is less than the minimal[i] then update max to minimal[i]
            if (max < minimal[i])
                max = minimal[i];
        }
        System.out.println(max);
        sc.close();
    }
}