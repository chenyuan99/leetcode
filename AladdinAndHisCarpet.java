
public class AladdinAndHisCarpet {
    public static void main(String[] args) {
        int[] magic = { 2, 4, 5, 2 };
        int[] dist = { 4, 3, 1, 3 };
        System.out.println(getStartPoint(magic, dist));
    }

    private static int getStartPoint(int[] magic, int[] dist) {
        int s = 0, r = 0, d = 0;
        for (int i = 0; i < magic.length; i++) {
            r += magic[i] - dist[i];
            if (r < 0) {
                s = i + 1;
                d += r;
                r = 0;
            }
        }
        return d + r >= 0 ? s : -1;
    }
}