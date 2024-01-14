public class FileTree {
    
}

/*
Given a list of strings that represent files, output the Directory structure
represented by these files.

Example:
Input files =  [
  “/app/components/header”,
  “/app/services”,
  “/app/tests/components/header”,
  “/images/image.png”,
  "/tsconfig.json",
  "/index.html",
];

Output:
-- app
  -- components
		-- header
	-- services
	-- tests
		-- components
			-- header
-- images
  -- image.png
-- tsconfig.json
-- index.html
*/

import java.util.*;

class Node {
  String val;
  ArrayList<Node> children;

  public Node(String val) {
    this.val = val;
    this.children = new ArrayList<>();
  }
}

class Main {
  public static void main(String[] args) {
    ArrayList<String> input = new ArrayList<String>();
    input.add("/app/components/header");
    input.add("/app/services");
    input.add("/app/tests/components/header");
    input.add("/images/image.png");
    input.add("/tsconfig.json");
    input.add("/index.html");
    printFileStructure(input);
  }

  public static void printFileStructure(ArrayList<String> input) {
     Node root = new Node("root");
     
     for (String curr: input) {
       String[] currArr = curr.split("/");
       
       Node parent = saveChild(root, currArr[0]);
       for (int i = 1; i < currArr.length; i++) {
         Node child = saveChild(parent, currArr[i]);
         parent = child;
       }
     }
  
    print(root, "");
  }

  private static Node saveChild(Node parent, String childVal) {
    boolean found = false;
    List<Node> children = parent.children;
    for (Node n: children) {
      if (n.val.equals(childVal)) {
        found = true;
        return n;
      }
    }
    
    if (!found) {
      Node child = new Node(childVal);
      children.add(child);
      return child;
    }
    
    return null;
  }

  private static void print(Node n, String spaces) {
    System.out.println(spaces + n.val);
    List<Node> children = n.children;
    for (Node child: children) {
      print(child, spaces + " ");
    }
  }
}

// https://leetcode.com/discuss/interview-experience/1379020/Google-phone-screen