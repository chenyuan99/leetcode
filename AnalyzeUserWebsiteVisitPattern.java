import java.util.*;

public class AnalyzeUserWebsiteVisitPattern {
    class Node {
        public String user;
        public int time;
        public String web;

        Node(String user_, int time_, String web_) {
            user = user_;
            time = time_;
            web = web_;
        }
    }

    class Solution {
        public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
            int n = username.length;

            // ----统计所有结点，按时间升序排序
            Node[] nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(username[i], timestamp[i], website[i]);
            }
            Arrays.sort(nodes, new Comparator<>() {
                public int compare(Node a, Node b) {
                    return a.time - b.time;
                }
            });

            // ----统计每个用户，访问过的结点（已经是按时间升序）
            Map<String, List<Node>> user_visit = new HashMap<>();
            for (int i = 0; i < n; i++) {
                Node x = nodes[i];
                user_visit.putIfAbsent(x.user, new ArrayList<>());
                user_visit.get(x.user).add(x);
            }

            // ----每个用户，自己访问过的web，暴力构造长度为3的”路径“
            Map<String, Integer> path_freq = new HashMap<>();

            for (Map.Entry<String, List<Node>> entry : user_visit.entrySet()) {
                String user = entry.getKey();
                List<Node> visit = entry.getValue();

                Set<String> tmp_path_uset = new HashSet<>(); // ----防止一个路径重复访问（很容易WA）

                int nn = visit.size();
                for (int i = 0; i < nn; i++) {
                    for (int j = i + 1; j < nn; j++) {
                        for (int k = j + 1; k < nn; k++) {
                            String cur_path = visit.get(i).web + "#" + visit.get(j).web + "#" + visit.get(k).web;
                            tmp_path_uset.add(cur_path);
                        }
                    }
                }

                for (String path : tmp_path_uset)
                    path_freq.put(path, path_freq.getOrDefault(path, 0) + 1);

            }

            int max_freq = 0;
            String res = "";
            for (Map.Entry<String, Integer> entry : path_freq.entrySet()) {
                String path = entry.getKey();
                int f = entry.getValue();
                if (f > max_freq) {
                    max_freq = f;
                    res = path;
                } else if (f == max_freq) {
                    String[] rr = res.split("#");
                    String[] pp = path.split("#");
                    if (pp[0].compareTo(rr[0]) < 0 || (pp[0].equals(rr[0]) == true && pp[1].compareTo(rr[1]) < 0)
                            || (pp[0].equals(rr[0]) == true && pp[1].equals(rr[1]) == true
                                    && pp[2].compareTo(rr[2]) < 0)) {
                        res = path;
                    }
                }
            }

            String[] tmp = res.split("#");
            List<String> ans = new ArrayList<>();
            for (String tm : tmp)
                ans.add(tm);
            return ans;
        }
    }

    // 作者：Hanxin_Hanxin
    // 链接：https://leetcode-cn.com/problems/analyze-user-website-visit-pattern/solution/cpython3java-1pai-xu-tong-ji-bao-li-zu-h-4q7j/
    // 来源：力扣（LeetCode）
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}
