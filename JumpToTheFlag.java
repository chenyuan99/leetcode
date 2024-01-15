import java.util.Arrays;
import java.util.Comparator;

public class JumpToTheFlag {

    static int jumps(int k, int j) {
        // k is the height of flag
        // j is the height of second type of jump
        int minimum_jumps = 0;
        minimum_jumps = k / j;
        // finding how many maximum jumps he can make using second type of jump
        minimum_jumps = minimum_jumps + k % j;
        // remaining jumps of height "1" are added to get the result
        return minimum_jumps;
    }

    public static void main(String[] args){
        System.out.println(jumps(3, 1));
        System.out.println(jumps(8, 3));
    }

}
