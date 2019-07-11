package problems;

public class q111_����������С��� {
	/*
	 * ע�������Ŀ������������������С��ȣ��Ǹ��ڵ㵽Ҷ�ӽڵ�����·��
		֮��Ľڵ������
		���ԣ�ֻ�е��ڵ���������Ӷ�Ϊ��ʱ������Ҷ�ӽڵ㡣
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
	
	//������һ��д��
	public int minDepth2(TreeNode root) {
		if(root==null)
            return 0;
        int left=minDepth2(root.left);
        int right=minDepth2(root.right);
        return (left==0||right==0) ?1+left+right:1+Math.min(left,right);
		
	}
	
}
