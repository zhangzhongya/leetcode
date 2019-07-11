package problems;

public class q111_二叉树的最小深度 {
	/*
	 * 注意这个题目的描述，二叉树的最小深度，是根节点到叶子节点的最短路径
		之间的节点个数。
		明显，只有当节点的两个孩子都为空时，才是叶子节点。
	*/
	public int minDepth(TreeNode root) {
        if(root==null)
            return 0;

        if(root.left!=null && root.right==null)
            return 1 + minDepth(root.left);
        
        if(root.right!=null && root.left==null)
            return 1 + minDepth(root.right);
        
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
	
	//更简洁的一种写法
	public int minDepth2(TreeNode root) {
		if(root==null)
            return 0;
        int left=minDepth2(root.left);
        int right=minDepth2(root.right);
        return (left==0||right==0) ?1+left+right:1+Math.min(left,right);
		
	}
	
}
