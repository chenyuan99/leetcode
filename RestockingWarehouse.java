public class RestockingWarehouse {
    public int remainItems(int[] itemCount, int target) {
        if (itemCount == null || itemCount.length == 0 || target < 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < itemCount.length; i++) {
            if (sum >= target) {
                break;
            }
            sum += itemCount[i];
        }
        return Math.abs(sum - target);
    }

    /**
     * public static void main(String[] args) { int[] itemCount = {10,20,30,40,15};
     * int target = 130; restocking test = new restocking();
     * System.out.println(test.remainItems(itemCount, target)); }
     */
}