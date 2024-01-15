public class LC0443CompressionString {
    public int compress(char[] chars) {
        // 快慢指针，并记录最后添加的位置
        int slow = 0, fast = 0, count = 0, index = 0;
        while (fast < chars.length) {
            while (fast < chars.length && chars[fast] == chars[slow]) {
                count++;
                fast++;
            }
            if (count == 1) {
                chars[index++] = chars[slow];
                count = 0;
            } else {
                String temp = Integer.toString(count);
                chars[index++] = chars[slow];
                for (int i = 0; i < temp.length(); i++) {
                    chars[index++] = temp.charAt(i);
                }
                count = 0;
            }
            slow = fast;

        }

        return index;

    }
}
