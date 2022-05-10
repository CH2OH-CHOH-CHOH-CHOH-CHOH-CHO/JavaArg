package com.LeeCode.Offer;

public class B049 {
    int sum = 0;
    StringBuilder stringBuilder = new StringBuilder();
    int res = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        stringBuilder.append(root.val);
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {

        if(root.right==null && root.left==null) {

            res += Integer.parseInt(stringBuilder.toString());
        }
        if (root.left != null) {
            stringBuilder.append(root.left.val);
            dfs(root.left);
            stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
        }
        if (root.right != null) {
            stringBuilder.append(root.right.val);
            dfs(root.right);
            stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
        }
    }
}
