public class MinMovesToEvenFollowedByOdd{

static int minMovesToEvenFollowedByOdd(int[] arr) {
    int moves = 0;
    int totalLength = arr.length;
    for (int i = 0; i <= totalLength / 2; i++) {
        if (arr[i] % 2 != 0) {
            for (int j = totalLength / 2; j < totalLength; j++) {
                if (arr[j] % 2 == 0) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    moves++;
                    break;
                } else {
                    continue;
                }
            }
        } else {
            continue;
        }
    }
    return moves;

    // public static void main(String[] args){
    //     System.out.println(minMovesToEvenFollowedByOdd);
    }

}