package trees;

public class MySimpleTree {
	
	private TreeNode root;
	
	public int maxPathCount = 0;
	
	int max = 0;
	
	
	public class TreeNode {
		private int value;
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode (int value, TreeNode left, TreeNode right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	
	public int longestConsecPath (TreeNode root) {
		//longestConsecPathHelper4(root, 1, 0);
		helper2(root);
		return max;
		//return maxPathCount;
	}
	
	public int helper2(TreeNode root) {
        if (root == null)
            return 0;
 
        //int l = helper(root.left);
        //int r = helper(root.right);
 
        int fromLeft = 0;
        int fromRight= 0;
 
        if (root.left == null) {
            fromLeft = 1;
        }
        else if (root.left.value-1 == root.value) {
            fromLeft = helper2(root.left) + 1;
        }
        else{
            fromLeft = 1;
        }
 
        if (root.right == null){
            fromRight = 1;
        }
        else if (root.right.value-1==root.value) {
            fromRight = helper2(root.right) + 1;
        }
        else{
            fromRight = 1;
        }
 
        max = Math.max(max, fromLeft);
        max = Math.max(max, fromRight);
 
        return Math.max(fromLeft, fromRight);
    }
	
	
	public int helper(TreeNode root) {
        if(root==null)
            return 0;
 
        int l = helper(root.left);
        int r = helper(root.right);
 
        int fromLeft = 0;
        int fromRight= 0;
 
        if(root.left==null){
            fromLeft=1;
        }else if(root.left.value-1==root.value){
            fromLeft = l+1;
        }else{
            fromLeft=1;
        }
 
        if(root.right==null){
            fromRight=1;
        }else if(root.right.value-1==root.value){
            fromRight = r+1;
        }else{
            fromRight=1;
        }
 
        max = Math.max(max, fromLeft);
        max = Math.max(max, fromRight);
 
        return Math.max(fromLeft, fromRight);
    }
	
	
	public int longestConsecPathHelper4 (TreeNode root, int count, int max) {
		
		if (root == null)
			return max;
		
		if (root.left != null) {
			if (root.left.value - root.value == 1) {
				if (++count > max) 
					max = count;
				return longestConsecPathHelper4(root.left, count, max);
			}
			else {
				return longestConsecPathHelper4(root.left, count, 0);
			}
		}
		
		if (root.right != null) {
			if (root.right.value - root.value == 1) {
				if (++count > max) 
					max = count;
				return longestConsecPathHelper4(root.right, count, max);
			}
			else {
				return longestConsecPathHelper4(root.right, count, 0);
			}
		}
		
		return longestConsecPathHelper4(null, count, max);
	}
	
	
	public void longestConsecPathHelper3(TreeNode root, int maxCount) {
		
		if (root == null)
			return;
		
		if (root.left != null) {
			if (root.left.value - root.value == 1) {
				if (++maxCount > maxPathCount) 
					maxPathCount = maxCount;
				longestConsecPathHelper3(root.left, maxCount);
			}
			else {
				longestConsecPathHelper3(root.left, 1);
			}
		}
		
		if (root.right != null) {
			if (root.right.value - root.value == 1) {
				if (++maxCount > maxPathCount) 
					maxPathCount = maxCount;
				longestConsecPathHelper3(root.right, maxCount);
			}
			else {
				longestConsecPathHelper3(root.left, 1);
			}
		}
	
		
	}
	
	public void longestConsecPathHelper2(TreeNode root, int lastValue, int maxCount) {
		
		if (root.left == null && root.right == null) {
			if (root.value - lastValue == 1) {
				if (++maxCount > maxPathCount) 
					maxPathCount = maxCount;
			}
		}
		if (root.left != null) {
			if (root.value - lastValue == 1) {
				if (++maxCount > maxPathCount) 
					maxPathCount = maxCount;
				longestConsecPathHelper2(root.left, root.value, maxCount);
			}
			else {
				longestConsecPathHelper2(root.left, root.value, 1);
			}
		}
		
		if (root.right != null) {
			if (root.value - lastValue == 1) {
				if (++maxCount > maxPathCount) 
					maxPathCount = maxCount;
				longestConsecPathHelper2(root.right, root.value, maxCount);
			}
			else {
				longestConsecPathHelper2(root.right, root.value, 1);
			}
		}
		
	}
	
	public void longestConsecPathHelper (TreeNode root, int lastValue, int maxCount) {
		
		if (root == null) {
			return;
		}
		if (root.left != null) {
			if (root.value - lastValue == 1) {
				if (++maxCount > maxPathCount) 
					maxPathCount = maxCount;
				longestConsecPathHelper(root.left, root.value, maxCount);
			}
			else {
				longestConsecPathHelper(root.left, root.value, 1);
			}
		}
		if (root.right != null) {
			if (root.value - lastValue == 1) {
				if (++maxCount > maxPathCount)
					maxPathCount = maxCount;
				longestConsecPathHelper(root.right, root.value, maxCount);
			}
			else {
				longestConsecPathHelper(root.right, root.value, 1);
			}
		}
		
		if (root.left == null && root.right == null) {
			if (root.value - lastValue == 1) {
				if (++maxCount > maxPathCount)
					maxPathCount = maxCount;
				//longestConsecPathHelper(root.right, root.value, maxCount);
			}
			else {
				//longestConsecPathHelper(root.right, root.value, 1);
			}
		}

		
		
	}
	
	
	public static void main (String [] args) {
		
		System.out.println("----- MySimpleTree.java -----");
		
		MySimpleTree tree = new MySimpleTree();
		
		TreeNode r31 = tree.new TreeNode(14, null, null);
		
		TreeNode l22 = tree.new TreeNode(11, null, null);
		
		TreeNode l11 = tree.new TreeNode(10, null, l22);
		TreeNode l12 = tree.new TreeNode(6, null, null);
		
		TreeNode r21 = tree.new TreeNode(7, null, null);
		TreeNode r22 = tree.new TreeNode(5, null, null);
		TreeNode r23 = tree.new TreeNode(13, null, r31);
		TreeNode r24 = tree.new TreeNode(3, null, null);
		
		TreeNode l1 = tree.new TreeNode(9, l11, l12);
		
		TreeNode r11 = tree.new TreeNode(8, r21, r22);
		TreeNode r12 = tree.new TreeNode(12, r23, r24);
		
		TreeNode r1 = tree.new TreeNode(11, r11, r12);
		
		
		TreeNode root = tree.new TreeNode (10, l1, r1);
		
		int result = tree.longestConsecPath(root);
		
		System.out.println("Longest Consecutive Increasing Path = " + result);
	}

}
