import java.util.Map;
import java.util.TreeMap;

public class LC2158NewAreaPainted {
    
    public int[] amountPainted(int[][] paint) {
        int[] amountPainted = new int[paint.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(paint[0][0], paint[0][1]);
        amountPainted[0] = paint[0][1] - paint[0][0];
        for (int day = 1; day < paint.length; day++) {
            int start = paint[day][0], end = paint[day][1], amount = end - start;
            Map.Entry<Integer, Integer> prevWork;
            while ((prevWork = map.lowerEntry(end)) != null) {
                int prevStart = prevWork.getKey(), prevEnd = prevWork.getValue();
                if (prevEnd <= start)
                    break;
                amount -= Math.min(end, prevEnd) - Math.max(start, prevStart);
                start = Math.min(start, prevStart);
                end = Math.max(end, prevEnd);
                map.remove(prevStart);
            }
            map.put(start, end);
            amountPainted[day] = amount;
        }
        return amountPainted;
    }
}