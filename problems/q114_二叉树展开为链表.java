package problems;

public class q114_二叉树展开为链表 {
	//比较好理解的递归写法
	public void flatten(TreeNode root) {
		if(root==null)
			return ;
		flatten(root.left);
		flatten(root.right);
		TreeNode temp = root.right;
		root.right = root.left;
		root.left = null;
		while(root.right != null)
			root = root.right;
		root.right = temp;
	}
	
}
