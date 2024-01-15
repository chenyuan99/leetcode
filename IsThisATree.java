import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class IsThisATree {

    public static String GetExpression(String s) {
        Boolean[][] graph = new Boolean[26][26];
        for(Boolean[] seats:graph){
            Arrays.fill(seats, false);
        }
        HashSet<Character> nodes = new HashSet<>();
        Boolean e2 = false;
        for (int i = 1; i < s.length(); i += 6) {
            int x = s.charAt(i) - 'A';
            // System.out.println(x);
            int y = s.charAt(i + 2) - 'A';
            // System.out.println(y);
            if (graph[x][y])
                e2 = true;
            graph[x][y] = true;
            nodes.add(s.charAt(i));
            nodes.add(s.charAt(i + 2));
        }

        Boolean e1 = false;
        for (int i = 0; i < 26; i++) {
            int count = 0;
            for (int j = 0; j < 26; j++) {
                if (graph[i][j])
                    count++;
            }
            if (count > 2)
                return "e1";
        }
        if (e2)
            return "e2";
        int numOfRoots = 0;
        Character root = ' ';
        for (Character node : nodes) {
            for (int i = 0; i < 26; i++) {
                if (graph[i][node - 'A'])
                    break;
                if (i == 25) {
                    numOfRoots++;
                    root = node;
                    Boolean[] visited = new Boolean[26];
                    Arrays.fill(visited, false);
                    if (IsCycle(node, graph, visited))
                        return "e3";
                }
            }
        }
        if (numOfRoots == 0)
            return "E3"; // if no root, must be a cycle
        if (numOfRoots > 1)
            return "E4"; // if more than one roots
        if (root == ' ')
            return "E5"; // if no edge in input String, invalid input error
        return GetExpressionHelper(root, graph);
    }

    private static Boolean IsCycle(char node, Boolean[][] graph, Boolean[] visited) {
        if (visited[node - 'A']) // node has already been visited, must has a cycle
            return true;
        visited[node - 'A'] = true;
        for (int i = 0; i < 26; i++) {
            if (graph[node - 'A'][i]) {
                if (IsCycle((char) (i + 'A'), graph, visited))
                    return true;
            }
        }
        return false;
    }

    // Recursive DFS to get the expression/construct the tree
    private static String GetExpressionHelper(char root, Boolean[][] graph) {
        String left = "", right = ""; // if no children, left and right should be empty
        for (int i = 0; i < 26; i++) {
            if (graph[root - 'A'][i]) {
                left = GetExpressionHelper((char) (i + 'A'), graph);
                for (int j = i + 1; j < 26; j++) {
                    if (graph[root - 'A'][j]) {
                        right = GetExpressionHelper((char) (j + 'A'), graph);
                        break;
                    }
                }
                break;
            }
        }
        return "(" + root + left + right + ")";
    }

    public static void main(String[] args) {
        String test = "(A,B) (A,C) (B,G) (C,H) (E,F) (B,D) (C,E)";
        System.out.println(GetExpression(test));
    }
}