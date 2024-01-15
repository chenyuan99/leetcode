public class LC666PathSumIV {
    public int pathSum(int[] nums) {
        int[][] arr = new int[5][8];

        for (int num : nums) {
            int depth = num / 100;
            int index = (num / 10) % 10 - 1;
            int value = num % 10;
            arr[depth][index] = arr[depth - 1][index / 2] + value;
        }

        int res = 0;
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 4 || (arr[i][j] != 0 && arr[i + 1][j * 2] == 0 && arr[i + 1][j * 2 + 1] == 0)){
                    res += arr[i][j];
                }
            }
        }

        return res;
    }
}
