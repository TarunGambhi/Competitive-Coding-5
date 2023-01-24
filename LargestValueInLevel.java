//https://leetcode.com/problems/find-largest-value-in-each-tree-row

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//TC : o(n)
//SC : o(h)
//bfs 
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        int max=Integer.MIN_VALUE;
        q.add(root);
        
        while(!q.isEmpty()){
            max=Integer.MIN_VALUE;
            int size = q.size();
            for(int i =0 ; i<size; i++){
                TreeNode node = q.poll();
                if(max<node.val) max = node.val;
                if(node.left != null ) q.add(node.left);
                if(node.right != null ) q.add(node.right);
            }
            result.add(max);
        }
        return result;
    }
}
//dfs
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        int max=Integer.MIN_VALUE;
        dfs(root,0,result);
        return result;
    }
    private void dfs(TreeNode root, int level,List<Integer> result){
        //base
        if(root==null) return;
        //logic
        if(result.size()==level){
            result.add(root.val);
        }else if(root.val>result.get(level)){
            result.set(level,root.val);
        }
        dfs(root.left,level+1,result);
        dfs(root.right,level+1,result);
    }
}
