// package VO;

import java.util.*;

public class BinaryTreeVerticalOrderTransversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        Deque<TreeNode> de = new LinkedList<>();
        de.add(root);
        Map<Integer,Integer> getTreeIdmap = new HashMap<>();
        //垂直分组的索引
        getTreeIdmap.put(root.val,0);
        Map<Integer,List<Integer>> listmap = new HashMap<>();
        //记录最小的key值，方便遍历
        int smallmapinde = Integer.MAX_VALUE;
        //层序遍历+分组添加
        while(!de.isEmpty()){
            int size = de.size();
            for(int i = 0;i < size;i++){
                TreeNode node = de.poll();
                //获取getTreeIdmap里面当前节点值的分组索引，加入到指定的分组中
                int nodeindex = getTreeIdmap.get(node.val);
                //更新最小的key值，方便从左到右集合
                smallmapinde = Math.min(smallmapinde,nodeindex);
                //如果分组不存在就新建一个分组
                if(!listmap.containsKey(nodeindex)) listmap.put(nodeindex,new ArrayList<>());
                listmap.get(nodeindex).add(node.val);
                //添加节点时，记录分组的索引为当前索引-1和+1
                if(node.left != null){
                    de.add(node.left);
                    getTreeIdmap.put(node.left.val,nodeindex-1);
                }
                if(node.right != null){
                    de.add(node.right);
                    getTreeIdmap.put(node.right.val,nodeindex+1);
                }
            }
        }
        int mapsize = listmap.size();
        for(int i = smallmapinde;i < mapsize;i++) if(listmap.get(i) != null) list.add(listmap.get(i));
        return list;
    }

// 作者：hihihiu
// 链接：https://leetcode-cn.com/problems/binary-tree-vertical-order-traversal/solution/java-ceng-xu-bian-li-mapfen-zu-by-hihihi-4z2u/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
